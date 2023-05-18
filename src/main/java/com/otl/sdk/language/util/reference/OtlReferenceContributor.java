package com.otl.sdk.language.util.reference;

import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.*;
import com.intellij.util.ProcessingContext;
import com.otl.sdk.language.psi.OtlKlassKeyName;
import com.otl.sdk.language.psi.OtlKlassName;
import org.jetbrains.annotations.NotNull;

public class OtlReferenceContributor extends PsiReferenceContributor {
    @Override
    public void registerReferenceProviders(@NotNull PsiReferenceRegistrar registrar) {
        registrar.registerReferenceProvider(PlatformPatterns.psiElement(OtlKlassKeyName.class), new PsiReferenceProvider() {
                    @Override
                    public PsiReference @NotNull [] getReferencesByElement(@NotNull PsiElement element,
                                                                           @NotNull ProcessingContext context) {
                        OtlKlassKeyName okn = (OtlKlassKeyName) element;
                        return new PsiReference[]{new OtlKlassReference(element, okn.getTextRange())};
                    }
        });

        registrar.registerReferenceProvider(PlatformPatterns.psiElement(OtlKlassName.class), new PsiReferenceProvider() {
            @Override
            public PsiReference @NotNull [] getReferencesByElement(@NotNull PsiElement element,
                                                                   @NotNull ProcessingContext context) {
                OtlKlassName okn = (OtlKlassName) element;
                System.out.println(okn);
                return new PsiReference[0];
            }
        });
    }
}
