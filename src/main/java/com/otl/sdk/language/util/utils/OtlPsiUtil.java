package com.otl.sdk.language.util.utils;

import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiElement;
import com.otl.sdk.language.OtlTypes;
import com.otl.sdk.language.psi.OtlDefineKlass;
import com.otl.sdk.language.psi.OtlKlassName;

public class OtlPsiUtil {
    private static final PsiUtilItems<OtlDefineKlass> otlDefineKlass = new PsiUtilItems<>(OtlTypes.KLASS_KEY);
    private static final PsiUtilItems<OtlKlassName> otlKlassName = new PsiUtilItems<>(OtlTypes.KLASS_IDENTIFIER);

    public static String getKey(OtlDefineKlass item) {
        return otlDefineKlass.getKey(item);
    }

    public static PsiElement setName(OtlDefineKlass element, String newName) {
        return otlDefineKlass.setName(element, newName);
    }

    public static PsiElement getNameIdentifier(OtlDefineKlass item) {
        return otlDefineKlass.getNameIdentifier(item);
    }

    public static ItemPresentation getPresentation(OtlDefineKlass item) {
        return otlDefineKlass.getPresentation(item);
    }

    public static String getName(OtlDefineKlass item) {
        return getKey(item);
    }

    // get klass name
    public static String getKey(OtlKlassName item) {
        return otlKlassName.getKey(item);
    }

    public static PsiElement setName(OtlKlassName item, String newName) {
        return otlKlassName.setName(item, newName);
    }

    public static PsiElement getNameIdentifier(OtlKlassName item) {
        return otlKlassName.getNameIdentifier(item);
    }

    public static ItemPresentation getPresentation(OtlKlassName item) {
        return otlKlassName.getPresentation(item);
    }

    public static String getName(OtlKlassName item) {
        return getKey(item);
    }
}
