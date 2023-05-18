package com.otl.sdk.language.util.utils;

import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.PsiReferenceService;
import com.intellij.psi.ReferenceProviderType;
import com.intellij.psi.impl.source.resolve.reference.ReferenceProvidersRegistry;
import com.otl.sdk.language.OtlTypes;
import com.otl.sdk.language.psi.*;
import org.jetbrains.annotations.NotNull;

public class OtlPsiUtil {
    private static final PsiUtilItems<OtlDefineKlass> defineKlass = new PsiUtilItems<>(OtlTypes.KLASS_KEY);
    private static final PsiUtilItems<OtlDefineMethod> defineMethod = new PsiUtilItems<>(OtlTypes.METHOD_KEY);
    private static final PsiUtilItems<OtlKlassName> klassName = new PsiUtilItems<>(OtlTypes.KLASS_IDENTIFIER);
    private static final PsiUtilItems<OtlKlassKeyName> klassKeyName = new PsiUtilItems<>(OtlTypes.KLASS_KEY);
    private static final PsiUtilItems<OtlMethodKeyName> methodKeyName = new PsiUtilItems<>(OtlTypes.METHOD_KEY);

    public static String getKey(OtlDefineKlass item) {
        return defineKlass.getKey(item);
    }
    public static PsiElement setName(OtlDefineKlass element, String newName) {return defineKlass.setName(element, newName);}
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
    public static String getName(OtlKlassName item) {return getKey(item);}
    public static PsiReference getReference(OtlKlassName item) {return klassName.getReference(item);}
    public static PsiReference @NotNull [] getReferences(OtlKlassName item) {return klassName.getReferences(item);}

//    public static PsiReference[] getReferences(OtlKlassName item, PsiReferenceService.@NotNull Hints hints) {
//        return ReferenceProvidersRegistry.getReferencesFromProviders(item, hints);
//    }
//
//    public static PsiReference @NotNull [] getReferences(OtlKlassName item) {
//        return getReferences(item, PsiReferenceService.Hints.NO_HINTS);
//    }
//
//    public static PsiReference getReference(OtlKlassName item) {
//        PsiReference[] references = getReferences(item);
//        return references.length == 0 ? null : references[0];
//    }

    // get klass name
    public static String getKey(OtlKlassKeyName item) {return klassKeyName.getKey(item);}
    public static PsiElement setName(OtlKlassKeyName item, String newName) {return klassKeyName.setName(item, newName);}
    public static PsiElement getNameIdentifier(OtlKlassKeyName item) {return klassKeyName.getNameIdentifier(item);}
    public static ItemPresentation getPresentation(OtlKlassKeyName item) {return klassKeyName.getPresentation(item);}
    public static String getName(OtlKlassKeyName item) {return getKey(item);}
    public static PsiReference getReference(OtlKlassKeyName item) {return klassKeyName.getReference(item);}
    public static PsiReference @NotNull [] getReferences(OtlKlassKeyName item) {return klassKeyName.getReferences(item);}

    // get method name
    public static String getKey(OtlMethodKeyName item) {return methodKeyName.getKey(item);}
    public static PsiElement setName(OtlMethodKeyName item, String newName) {return methodKeyName.setName(item, newName);}
    public static PsiElement getNameIdentifier(OtlMethodKeyName item) {return methodKeyName.getNameIdentifier(item);}
    public static ItemPresentation getPresentation(OtlMethodKeyName item) {return methodKeyName.getPresentation(item);}
    public static String getName(OtlMethodKeyName item) {return getKey(item);}
}
