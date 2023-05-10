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

public class OtlDefineMethodImpl extends ASTWrapperPsiElement implements OtlDefineMethod {

  public OtlDefineMethodImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull OtlVisitor visitor) {
    visitor.visitDefineMethod(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof OtlVisitor) accept((OtlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<OtlCreateVariable> getCreateVariableList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, OtlCreateVariable.class);
  }

  @Override
  @Nullable
  public OtlDefineParams getDefineParams() {
    return findChildByClass(OtlDefineParams.class);
  }

  @Override
  @NotNull
  public List<OtlImport> getImportList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, OtlImport.class);
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
  @NotNull
  public List<OtlUpdateVariable> getUpdateVariableList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, OtlUpdateVariable.class);
  }

  @Override
  @NotNull
  public List<OtlVariableName> getVariableNameList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, OtlVariableName.class);
  }

}
