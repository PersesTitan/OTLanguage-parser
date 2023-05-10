package com.otl.sdk.language.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.otl.sdk.language.psi.OtlNamedElement;
import org.jetbrains.annotations.NotNull;

public abstract class OtlNamedElementImpl extends ASTWrapperPsiElement implements OtlNamedElement {
    public OtlNamedElementImpl(@NotNull ASTNode node) {
        super(node);
    }
}
