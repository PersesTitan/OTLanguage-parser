// This is a generated file. Not intended for manual editing.
package com.otl.sdk.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.otl.sdk.language.element.OtlNamedElement;
import com.intellij.navigation.ItemPresentation;

public interface OtlMethodKeyName extends OtlNamedElement {

  String getKey();

  String getName();

  PsiElement setName(String newName);

  PsiElement getNameIdentifier();

  ItemPresentation getPresentation();

}
