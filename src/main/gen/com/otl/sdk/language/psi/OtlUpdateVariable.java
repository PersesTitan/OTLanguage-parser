// This is a generated file. Not intended for manual editing.
package com.otl.sdk.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface OtlUpdateVariable extends PsiElement {

  @NotNull
  List<OtlKlassName> getKlassNameList();

  @NotNull
  List<OtlMethodName> getMethodNameList();

  @NotNull
  List<OtlVariableName> getVariableNameList();

}