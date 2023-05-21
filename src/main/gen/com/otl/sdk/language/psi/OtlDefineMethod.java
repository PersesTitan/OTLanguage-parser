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

  @Nullable
  OtlKlassKey getKlassKey();

  @Nullable
  OtlMethodKey getMethodKey();

  @NotNull
  List<OtlRemarkToken> getRemarkTokenList();

  @NotNull
  List<OtlUpdateVariable> getUpdateVariableList();

  @NotNull
  List<OtlUse> getUseList();

  @Nullable
  OtlValueKey getValueKey();

}
