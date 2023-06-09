package com.otl.sdk.language.util.utils;

import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.*;
import com.intellij.psi.impl.source.resolve.reference.ReferenceProvidersRegistry;
import com.intellij.psi.tree.IElementType;
import com.otl.sdk.language.element.OtlElementFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Arrays;

class PsiUtilItems<T extends PsiElement> {
    private final IElementType type;

    public PsiUtilItems(IElementType type) {
        this.type = type;
    }

    public String getKey(T item) {
        ASTNode node = item.getNode().findChildByType(type);
        return node != null ? node.getText() : null;
    }

    public PsiElement setName(T element, String newName) {
        ASTNode node = element.getNode().findChildByType(type);
        if (node != null) element.getNode().replaceChild(node, OtlElementFactory
                    .<T>create(element.getProject(), newName)
                    .getFirstChild()
                    .getNode());
        return element;
    }

    public PsiElement getNameIdentifier(T item) {
        ASTNode node = item.getNode().findChildByType(type);
        return node != null ? node.getPsi() : null;
    }

    public ItemPresentation getPresentation(T item) {
        return new ItemPresentation() {
            @Nullable
            @Override
            public String getPresentableText() {
                return item.getText();
            }

            @Nullable
            @Override
            public String getLocationString() {
                PsiFile psiFile = item.getContainingFile();
                return psiFile == null ? null : psiFile.getName();
            }

            @Nullable
            @Override
            public Icon getIcon(boolean unused) {
                return item.getIcon(0);
            }
        };
    }

    public PsiReference getReference(T item) {
        PsiReference[] references = getReferences(item);
        return references.length == 0 ? null : references[0];
    }

    @NotNull
    public PsiReference[] getReferences(T item) {
        return ReferenceProvidersRegistry.getReferencesFromProviders(item);
    }

    public PsiReference findReferenceAt(T item, int offset) {
        return getReferences(item)[offset];
    }
}
