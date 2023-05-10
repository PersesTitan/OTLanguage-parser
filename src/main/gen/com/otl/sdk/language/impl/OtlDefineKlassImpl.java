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
import com.intellij.navigation.ItemPresentation;

public class OtlDefineKlassImpl extends ASTWrapperPsiElement implements OtlDefineKlass {

  public OtlDefineKlassImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull OtlVisitor visitor) {
    visitor.visitDefineKlass(this);
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
  @NotNull
  public List<OtlDefineMethod> getDefineMethodList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, OtlDefineMethod.class);
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
  @Nullable
  public OtlKlassName getKlassName() {
    return findChildByClass(OtlKlassName.class);
  }

  @Override
  @NotNull
  public List<OtlUpdateVariable> getUpdateVariableList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, OtlUpdateVariable.class);
  }

  @Override
  public String getKey() {
    return OtlDefineKlassUtil.getKey(this);
  }

  @Override
  public String getName() {
    return OtlDefineKlassUtil.getName(this);
  }

  @Override
  public PsiElement getNameIdentifier() {
    return OtlDefineKlassUtil.getNameIdentifier(this);
  }

  @Override
  public ItemPresentation getPresentation() {
    return OtlDefineKlassUtil.getPresentation(this);
  }

}
