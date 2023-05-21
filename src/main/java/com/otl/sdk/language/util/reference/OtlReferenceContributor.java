package com.otl.sdk.language.util.reference;

import com.intellij.openapi.project.Project;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.*;
import com.intellij.util.ProcessingContext;
import com.otl.sdk.language.impl.OtlDefineKlassImpl;
import com.otl.sdk.language.psi.OtlDefineKlass;
import com.otl.sdk.language.psi.OtlKlassKey;
import com.otl.sdk.language.util.OtlDefineKlassUtil;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

public class OtlReferenceContributor extends PsiReferenceContributor {
    @Override
    public void registerReferenceProviders(@NotNull PsiReferenceRegistrar registrar) {
        registrar.registerReferenceProvider(PlatformPatterns.psiElement(OtlKlassKey.class), new PsiReferenceProvider() {
                    @Override
                    public PsiReference @NotNull [] getReferencesByElement(@NotNull PsiElement element,
                                                                           @NotNull ProcessingContext context) {
                        if (element.getParent() instanceof OtlDefineKlass odk) {
                            return new PsiReference[]{new OtlKlassReference(element, element.getTextRange())};
                        } else return PsiReference.EMPTY_ARRAY;
                    }
        });

//        registrar.registerReferenceProvider(PlatformPatterns.psiElement(OtlKlassName.class), new PsiReferenceProvider() {
//            @Override
//            public PsiReference @NotNull [] getReferencesByElement(@NotNull PsiElement element,
//                                                                   @NotNull ProcessingContext context) {
//                OtlKlassName okn = (OtlKlassName) element;
//                System.out.println(okn);
//                return new PsiReference[0];
//            }
//        });
    }
}
