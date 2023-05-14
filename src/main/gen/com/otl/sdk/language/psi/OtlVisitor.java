// This is a generated file. Not intended for manual editing.
package com.otl.sdk.language.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;
import com.otl.sdk.language.element.OtlNamedElement;

public class OtlVisitor extends PsiElementVisitor {

  public void visitCreateVariable(@NotNull OtlCreateVariable o) {
    visitPsiElement(o);
  }

  public void visitDefineKlass(@NotNull OtlDefineKlass o) {
    visitNamedElement(o);
  }

  public void visitDefineMethod(@NotNull OtlDefineMethod o) {
    visitNamedElement(o);
  }

  public void visitDefineParams(@NotNull OtlDefineParams o) {
    visitPsiElement(o);
  }

  public void visitImport(@NotNull OtlImport o) {
    visitPsiElement(o);
  }

  public void visitKlassName(@NotNull OtlKlassName o) {
    visitNamedElement(o);
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

  public void visitNamedElement(@NotNull OtlNamedElement o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
