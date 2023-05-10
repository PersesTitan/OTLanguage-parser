package com.otl.sdk.language.psi;

import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

public interface OtlProperty extends OtlNamedElement {
    String getKlass();
    String getName();
    String getValue();

    PsiElement setName(@NotNull String newName);
    PsiElement getNameIdentifier();

    ItemPresentation getPresentation();
}
