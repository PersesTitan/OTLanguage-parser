// This is a generated file. Not intended for manual editing.
package com.otl.sdk.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface OtlDefineKlass extends PsiElement {

  @NotNull
  List<OtlCreateVariable> getCreateVariableList();

  @NotNull
  List<OtlDefineMethod> getDefineMethodList();

  @Nullable
  OtlDefineParams getDefineParams();

  @NotNull
  List<OtlImport> getImportList();

  @Nullable
  OtlKlassKeyName getKlassKeyName();

  @NotNull
  List<OtlRemarkToken> getRemarkTokenList();

  @NotNull
  List<OtlUpdateVariable> getUpdateVariableList();

}
