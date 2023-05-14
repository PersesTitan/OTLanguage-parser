// This is a generated file. Not intended for manual editing.
package com.otl.sdk.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.otl.sdk.language.element.OtlNamedElement;
import com.intellij.navigation.ItemPresentation;

public interface OtlDefineMethod extends OtlNamedElement {

  @NotNull
  List<OtlCreateVariable> getCreateVariableList();

  @Nullable
  OtlDefineParams getDefineParams();

  @NotNull
  List<OtlImport> getImportList();

  @NotNull
  List<OtlKlassName> getKlassNameList();

  @NotNull
  List<OtlMethodName> getMethodNameList();

  @NotNull
  List<OtlRemarkToken> getRemarkTokenList();

  @NotNull
  List<OtlUpdateVariable> getUpdateVariableList();

  @NotNull
  List<OtlVariableName> getVariableNameList();

  String getKey();

  String getName();

  PsiElement setName(String name);

  PsiElement getNameIdentifier();

  ItemPresentation getPresentation();

}
