// This is a generated file. Not intended for manual editing.
package com.otl.sdk.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface OtlCreateVariable extends PsiElement {

  @NotNull
  OtlKlassKey getKlassKey();

  @NotNull
  List<OtlValueKey> getValueKeyList();

  @NotNull
  OtlVariableKey getVariableKey();

}
