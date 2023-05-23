// This is a generated file. Not intended for manual editing.
package com.otl.sdk.language.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.otl.sdk.language.OtlTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.otl.sdk.language.psi.*;
import com.otl.sdk.language.util.utils.OtlPsiUtil;

public class OtlUseImpl extends ASTWrapperPsiElement implements OtlUse {

  public OtlUseImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull OtlVisitor visitor) {
    visitor.visitUse(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof OtlVisitor) accept((OtlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public OtlKlassKey getKlassKey() {
    return findChildByClass(OtlKlassKey.class);
  }

  @Override
  @NotNull
  public List<OtlMethodKey> getMethodKeyList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, OtlMethodKey.class);
  }

  @Override
  @NotNull
  public List<OtlValueKey> getValueKeyList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, OtlValueKey.class);
  }

  @Override
  @Nullable
  public OtlVariableKey getVariableKey() {
    return findChildByClass(OtlVariableKey.class);
  }

}
