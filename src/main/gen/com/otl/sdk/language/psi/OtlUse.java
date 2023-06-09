// This is a generated file. Not intended for manual editing.
package com.otl.sdk.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface OtlUse extends PsiElement {

  @Nullable
  OtlKlassKey getKlassKey();

  @NotNull
  List<OtlMethodKey> getMethodKeyList();

  @NotNull
  List<OtlValueKey> getValueKeyList();

  @Nullable
  OtlVariableKey getVariableKey();

}
