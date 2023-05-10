// This is a generated file. Not intended for manual editing.
package com.otl.sdk.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface OtlDefineMethod extends PsiElement {

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
  List<OtlUpdateVariable> getUpdateVariableList();

  @NotNull
  List<OtlVariableName> getVariableNameList();

}
