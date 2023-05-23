package com.otl.sdk.language.util.utils;

import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.*;
import com.intellij.psi.impl.source.resolve.reference.ReferenceProvidersRegistry;
import com.otl.sdk.language.OtlTypes;
import com.otl.sdk.language.psi.*;
import org.jetbrains.annotations.NotNull;

public class OtlPsiUtil {
    private static final PsiUtilItems<OtlKlassKey> klassKey = new PsiUtilItems<>(OtlTypes.KLASS_IDENTIFIER);
    private static final PsiUtilItems<OtlMethodKey> methodKey = new PsiUtilItems<>(OtlTypes.METHOD_IDENTIFIER);
    private static final PsiUtilItems<OtlVariableKey> variableKey = new PsiUtilItems<>(OtlTypes.VARIABLE_IDENTIFIER);

    // CLASS DEFINE
    public static String getKey(OtlKlassKey item) {return klassKey.getKey(item);}
    public static PsiElement setName(OtlKlassKey item, @NotNull String name) {return klassKey.setName(item, name);}
    public static PsiElement getNameIdentifier(OtlKlassKey item) {return klassKey.getNameIdentifier(item);}
    public static ItemPresentation getPresentation(OtlKlassKey item) {return klassKey.getPresentation(item);}
    public static String getName(OtlKlassKey item) {return getKey(item);}
    public static Object getValue(OtlKlassKey item) {return null;}
    public static PsiReference getReference(OtlKlassKey item) {return klassKey.getReference(item);}
    public static PsiReference @NotNull [] getReferences(OtlKlassKey item) {return klassKey.getReferences(item);}
    public static PsiReference findReferenceAt(OtlKlassKey item, int offset) {return klassKey.findReferenceAt(item, offset);}

    // METHOD DEFINE
    public static String getKey(OtlMethodKey item) {return methodKey.getKey(item);}
    public static PsiElement setName(OtlMethodKey item, @NotNull String name) {return methodKey.setName(item, name);}
    public static PsiElement getNameIdentifier(OtlMethodKey item) {return methodKey.getNameIdentifier(item);}
    public static ItemPresentation getPresentation(OtlMethodKey item) {return methodKey.getPresentation(item);}
    public static String getName(OtlMethodKey item) {return getKey(item);}
    public static Object getValue(OtlMethodKey item) {return null;}
    public static PsiReference getReference(OtlMethodKey item) {return methodKey.getReference(item);}
    public static PsiReference @NotNull [] getReferences(OtlMethodKey item) {return methodKey.getReferences(item);}
    public static PsiReference findReferenceAt(OtlMethodKey item, int offset) {return methodKey.findReferenceAt(item, offset);}

    // VARIABLE DEFINE
    public static String getKey(OtlVariableKey item) {return variableKey.getKey(item);}
    public static PsiElement setName(OtlVariableKey item, @NotNull String name) {return variableKey.setName(item, name);}
    public static PsiElement getNameIdentifier(OtlVariableKey item) {return variableKey.getNameIdentifier(item);}
    public static ItemPresentation getPresentation(OtlVariableKey item) {return variableKey.getPresentation(item);}
    public static String getName(OtlVariableKey item) {return getKey(item);}
    public static Object getValue(OtlVariableKey item) {return null;}
    public static PsiReference getReference(OtlVariableKey item) {return variableKey.getReference(item);}
    public static PsiReference @NotNull [] getReferences(OtlVariableKey item) {return variableKey.getReferences(item);}
    public static PsiReference findReferenceAt(OtlVariableKey item, int offset) {return variableKey.findReferenceAt(item, offset);}
}
