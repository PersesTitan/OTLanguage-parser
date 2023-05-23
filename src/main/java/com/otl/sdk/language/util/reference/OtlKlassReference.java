package com.otl.sdk.language.util.reference;

import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import com.otl.sdk.language.psi.OtlDefineKlass;
import com.otl.sdk.language.psi.OtlKlassKey;
import com.otl.sdk.language.util.OtlDefineKlassUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class OtlKlassReference extends PsiReferenceBase<PsiElement> implements PsiPolyVariantReference {
    private final String key;

    public OtlKlassReference(@NotNull PsiElement element, TextRange textRange) {
        super(element, textRange);
        this.key = element.getText();
    }

    @Override
    public ResolveResult @NotNull [] multiResolve(boolean incompleteCode) {
        Project project = myElement.getProject();
        List<OtlKlassKey> list = OtlDefineKlassUtil.findChild(OtlKlassKey.class, project, key);
        System.out.println(list);
        int size = list.size();
        ResolveResult[] results = new ResolveResult[size];
        for (int i = 0; i<size; i++) results[i] = new PsiElementResolveResult(list.get(i));
        return results;
    }

    @Override
    public @Nullable PsiElement resolve() {
        Project project = myElement.getProject();
        List<OtlDefineKlass> list = OtlDefineKlassUtil.findChild(OtlDefineKlass.class, project, key);
        System.out.println(list);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public Object @NotNull [] getVariants() {
        return OtlDefineKlassUtil.findChild(OtlKlassKey.class, myElement.getProject(), key)
                .stream()
                .filter(v -> v.getName() != null && v.getName().length() > 0)
                .map(v -> (LookupElement) LookupElementBuilder
                        .create(v)
                        .withTypeText(v.getContainingFile().getName())
                )
                .toArray();
    }
}