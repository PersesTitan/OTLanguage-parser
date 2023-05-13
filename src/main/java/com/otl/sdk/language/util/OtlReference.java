package com.otl.sdk.language.util;

import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class OtlReference extends PsiReferenceBase<PsiElement> implements PsiPolyVariantReference {
    private final String key;

    public OtlReference(@NotNull PsiElement element, TextRange rangeInElement) {
        super(element, rangeInElement);
        this.key = element.getText().substring(rangeInElement.getStartOffset(), rangeInElement.getEndOffset());
        System.out.println(key);
    }

    @Override
    public ResolveResult @NotNull [] multiResolve(boolean incompleteCode) {
        Project project = myElement.getProject();
        return OtlDefineKlassUtil.findDefineKlass(project, key)
                .stream()
                .map(PsiElementResolveResult::new)
                .toArray(ResolveResult[]::new);
    }

    @Override
    public @Nullable PsiElement resolve() {
        ResolveResult[] resolveResults = multiResolve(false);
        return resolveResults.length == 1 ? resolveResults[0].getElement() : null;
    }

    @Override
    public Object @NotNull [] getVariants() {
        return OtlDefineKlassUtil.findDefineKlass(myElement.getProject())
                .stream()
                .filter(v -> v.getKey() != null && v.getKey().length() > 0)
                .map(v -> (LookupElement) LookupElementBuilder
                        .create(v)
                        .withTypeText(v.getContainingFile().getName())
                )
                .toArray();
    }
}
