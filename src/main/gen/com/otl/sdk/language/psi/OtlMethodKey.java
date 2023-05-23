// This is a generated file. Not intended for manual editing.
package com.otl.sdk.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.otl.sdk.language.element.OtlNamedElement;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiReference;

public interface OtlMethodKey extends OtlNamedElement {

  String getName();

  PsiElement getNameIdentifier();

  PsiElement setName(@NotNull String name);

  ItemPresentation getPresentation();

  PsiReference getReference();

  PsiReference @NotNull [] getReferences();

  PsiReference findReferenceAt(int offset);

}
