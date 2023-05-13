package com.otl.sdk.language.util;

import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.*;
import com.intellij.util.ProcessingContext;
import com.otl.sdk.language.psi.OtlDefineKlass;
import com.otl.sdk.language.psi.OtlDefineParams;
import org.jetbrains.annotations.NotNull;

public class OtlReferenceContributor extends PsiReferenceContributor {
    @Override
    public void registerReferenceProviders(@NotNull PsiReferenceRegistrar registrar) {

        registrar.registerReferenceProvider(PlatformPatterns.psiElement(OtlDefineKlass.class),
                new PsiReferenceProvider() {
            @Override
            public PsiReference @NotNull [] getReferencesByElement(@NotNull PsiElement element,
                                                                   @NotNull ProcessingContext context) {
//                @NotNull PsiElement ele = element.getParent();
                System.out.println(element);
                if (element instanceof OtlDefineParams items) {
//                    return items
//                            .getKlassNameList()
//                            .stream()
//                            .map(item -> new OtlReference(element, item.getNameIdentifier().getTextRange()))
//                            .toArray(PsiReference[]::new);
                }
                return PsiReference.EMPTY_ARRAY;
            }
        });
    }
}
