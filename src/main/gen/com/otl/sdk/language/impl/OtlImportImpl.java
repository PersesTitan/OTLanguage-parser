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
import com.otl.sdk.language.util.OtlDefineKlassUtil;

public class OtlImportImpl extends ASTWrapperPsiElement implements OtlImport {

  public OtlImportImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull OtlVisitor visitor) {
    visitor.visitImport(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof OtlVisitor) accept((OtlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<OtlKlassName> getKlassNameList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, OtlKlassName.class);
  }

  @Override
  @NotNull
  public List<OtlMethodName> getMethodNameList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, OtlMethodName.class);
  }

  @Override
  @Nullable
  public OtlVariableName getVariableName() {
    return findChildByClass(OtlVariableName.class);
  }

}
