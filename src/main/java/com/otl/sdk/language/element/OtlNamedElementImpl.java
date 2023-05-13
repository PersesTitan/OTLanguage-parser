package com.otl.sdk.language.element;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;

public abstract class OtlNamedElementImpl extends ASTWrapperPsiElement implements OtlNamedElement {
    public OtlNamedElementImpl(@NotNull ASTNode node) {
        super(node);
    }
}
