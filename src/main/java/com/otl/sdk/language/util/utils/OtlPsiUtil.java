package com.otl.sdk.language.util.utils;

import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiElement;
import com.otl.sdk.language.OtlTypes;
import com.otl.sdk.language.psi.OtlDefineKlass;
import com.otl.sdk.language.psi.OtlDefineMethod;
import com.otl.sdk.language.psi.OtlKlassName;

public class OtlPsiUtil {
    private static final PsiUtilItems<OtlDefineKlass> defineKlass = new PsiUtilItems<>(OtlTypes.KLASS_KEY);
    private static final PsiUtilItems<OtlDefineMethod> defineMethod = new PsiUtilItems<>(OtlTypes.METHOD_KEY);
    private static final PsiUtilItems<OtlKlassName> klassName = new PsiUtilItems<>(OtlTypes.KLASS_IDENTIFIER);

    public static String getKey(OtlDefineKlass item) {
        return defineKlass.getKey(item);
    }

    public static PsiElement setName(OtlDefineKlass element, String newName) {
        return defineKlass.setName(element, newName);
    }

    public static PsiElement getNameIdentifier(OtlDefineKlass item) {
        return defineKlass.getNameIdentifier(item);
    }

    public static ItemPresentation getPresentation(OtlDefineKlass item) {
        return defineKlass.getPresentation(item);
    }

    public static String getName(OtlDefineKlass item) {
        return getKey(item);
    }

    // define method name
    public static String getKey(OtlDefineMethod item) {
        return defineMethod.getKey(item);
    }

    public static PsiElement setName(OtlDefineMethod item, String name) {
        return defineMethod.setName(item, name);
    }

    public static PsiElement getNameIdentifier(OtlDefineMethod item) {
        return defineMethod.getNameIdentifier(item);
    }

    public static ItemPresentation getPresentation(OtlDefineMethod item) {
        return defineMethod.getPresentation(item);
    }

    public static String getName(OtlDefineMethod item) {
        return getKey(item);
    }

    // get klass name
    public static String getKey(OtlKlassName item) {
        return klassName.getKey(item);
    }

    public static PsiElement setName(OtlKlassName item, String newName) {
        return klassName.setName(item, newName);
    }

    public static PsiElement getNameIdentifier(OtlKlassName item) {
        return klassName.getNameIdentifier(item);
    }

    public static ItemPresentation getPresentation(OtlKlassName item) {
        return klassName.getPresentation(item);
    }

    public static String getName(OtlKlassName item) {
        return getKey(item);
    }
}
