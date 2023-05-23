package com.otl.sdk.language.element;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.NlsSafe;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.PsiReferenceBase;
import com.intellij.psi.PsiReferenceService;
import com.intellij.psi.impl.source.resolve.reference.ReferenceProvidersRegistry;
import com.intellij.psi.impl.source.resolve.reference.impl.PsiMultiReference;
import com.intellij.util.IncorrectOperationException;
import com.otl.sdk.language.psi.OtlKlassKey;
import com.otl.sdk.language.psi.OtlMethodKey;
import com.otl.sdk.language.psi.OtlVariableKey;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class OtlNamedElementImpl extends ASTWrapperPsiElement implements OtlNamedElement {
    public OtlNamedElementImpl(@NotNull ASTNode node) {
        super(node);
    }
}
