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

public class OtlMethodKeyNameImpl extends OtlNamedElementImpl implements OtlMethodKeyName {

  public OtlMethodKeyNameImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull OtlVisitor visitor) {
    visitor.visitMethodKeyName(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof OtlVisitor) accept((OtlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  public String getKey() {
    return OtlPsiUtil.getKey(this);
  }

  @Override
  public String getName() {
    return OtlPsiUtil.getName(this);
  }

  @Override
  public PsiElement setName(String newName) {
    return OtlPsiUtil.setName(this, newName);
  }

  @Override
  public PsiElement getNameIdentifier() {
    return OtlPsiUtil.getNameIdentifier(this);
  }

  @Override
  public ItemPresentation getPresentation() {
    return OtlPsiUtil.getPresentation(this);
  }

}
