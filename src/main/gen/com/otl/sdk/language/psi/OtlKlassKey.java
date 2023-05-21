// This is a generated file. Not intended for manual editing.
package com.otl.sdk.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.otl.sdk.language.element.OtlNamedElement;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiReference;

public interface OtlKlassKey extends OtlNamedElement {

  String getKey();

  String getName();

  Object getValue();

  PsiElement setName(@NotNull String name);

  PsiElement getNameIdentifier();

  ItemPresentation getPresentation();

  PsiReference getReference();

  PsiReference @NotNull [] getReferences();

  PsiReference findReferenceAt(int offset);

}