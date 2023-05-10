// This is a generated file. Not intended for manual editing.
package com.otl.sdk.language.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class OtlVisitor extends PsiElementVisitor {

  public void visitCreateVariable(@NotNull OtlCreateVariable o) {
    visitPsiElement(o);
  }

  public void visitDefineKlass(@NotNull OtlDefineKlass o) {
    visitPsiElement(o);
  }

  public void visitDefineMethod(@NotNull OtlDefineMethod o) {
    visitPsiElement(o);
  }

  public void visitDefineParams(@NotNull OtlDefineParams o) {
    visitPsiElement(o);
  }

  public void visitImport(@NotNull OtlImport o) {
    visitPsiElement(o);
  }

  public void visitKlassName(@NotNull OtlKlassName o) {
    visitDefineKlass(o);
  }

  public void visitMethodName(@NotNull OtlMethodName o) {
    visitPsiElement(o);
  }

  public void visitRemarkToken(@NotNull OtlRemarkToken o) {
    visitPsiElement(o);
  }

  public void visitUpdateVariable(@NotNull OtlUpdateVariable o) {
    visitPsiElement(o);
  }

  public void visitVariableName(@NotNull OtlVariableName o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
