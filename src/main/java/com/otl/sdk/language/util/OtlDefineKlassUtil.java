package com.otl.sdk.language.util;

import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.otl.sdk.language.OtlTypes;
import com.otl.sdk.language.psi.OtlDefineKlass;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class OtlDefineKlassUtil {
    public static String getKey(OtlDefineKlass item) {
        ASTNode node = item.getNode().findChildByType(OtlTypes.KLASS_NAME);
        return node != null ? node.getText() : null;
    }

    public static String getName(OtlDefineKlass item) {
        return getKey(item);
    }

    public static PsiElement getNameIdentifier(OtlDefineKlass item) {
        ASTNode node = item.getNode().findChildByType(OtlTypes.KLASS_NAME);
        return node != null ? node.getPsi() : null;
    }

    public static ItemPresentation getPresentation(OtlDefineKlass item) {
        return new ItemPresentation() {
            @Nullable
            @Override
            public String getPresentableText() {
                return item.getText();
            }

            @Nullable
            @Override
            public String getLocationString() {
                PsiFile psiFile = item.getContainingFile();
                return psiFile == null ? null : psiFile.getName();
            }

            @Nullable
            @Override
            public Icon getIcon(boolean unused) {
                return item.getIcon(0);
            }
        };
    }
}
