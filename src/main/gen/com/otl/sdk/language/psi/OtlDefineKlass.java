// This is a generated file. Not intended for manual editing.
package com.otl.sdk.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.otl.sdk.language.element.OtlNamedElement;
import com.intellij.navigation.ItemPresentation;

public interface OtlDefineKlass extends OtlNamedElement {

  @NotNull
  List<OtlCreateVariable> getCreateVariableList();

  @NotNull
  List<OtlDefineMethod> getDefineMethodList();

  @Nullable
  OtlDefineParams getDefineParams();

  @NotNull
  List<OtlImport> getImportList();

  @NotNull
  List<OtlRemarkToken> getRemarkTokenList();

  @NotNull
  List<OtlUpdateVariable> getUpdateVariableList();

  String getKey();

  String getName();

  PsiElement setName(String newName);

  PsiElement getNameIdentifier();

  ItemPresentation getPresentation();

}
