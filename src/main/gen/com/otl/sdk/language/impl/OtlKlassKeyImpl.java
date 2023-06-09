// This is a generated file. Not intended for manual editing.
package com.otl.sdk.language.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.otl.sdk.language.OtlTypes.*;
import com.otl.sdk.language.element.OtlNamedElementImpl;
import com.otl.sdk.language.psi.*;
import com.otl.sdk.language.util.utils.OtlPsiUtil;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiReference;

public class OtlKlassKeyImpl extends OtlNamedElementImpl implements OtlKlassKey {

  public OtlKlassKeyImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull OtlVisitor visitor) {
    visitor.visitKlassKey(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof OtlVisitor) accept((OtlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  public String getName() {
    return OtlPsiUtil.getName(this);
  }

  @Override
  public PsiElement getNameIdentifier() {
    return OtlPsiUtil.getNameIdentifier(this);
  }

  @Override
  public PsiElement setName(@NotNull String name) {
    return OtlPsiUtil.setName(this, name);
  }

  @Override
  public ItemPresentation getPresentation() {
    return OtlPsiUtil.getPresentation(this);
  }

  @Override
  public PsiReference getReference() {
    return OtlPsiUtil.getReference(this);
  }

  @Override
  public PsiReference @NotNull [] getReferences() {
    return OtlPsiUtil.getReferences(this);
  }

  @Override
  public PsiReference findReferenceAt(int offset) {
    return OtlPsiUtil.findReferenceAt(this, offset);
  }

}
