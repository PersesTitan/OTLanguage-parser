package com.otl.sdk.language.root;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.ide.projectView.PresentationData;
import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement;
import com.intellij.ide.util.treeView.smartTree.TreeElement;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.NavigatablePsiElement;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import com.otl.sdk.language.impl.OtlKlassKeyImpl;
import com.otl.sdk.language.impl.OtlMethodKeyImpl;
import com.otl.sdk.language.impl.OtlVariableKeyImpl;
import com.otl.sdk.language.psi.OtlKlassKey;
import com.otl.sdk.language.psi.OtlMethodKey;
import com.otl.sdk.language.psi.OtlVariableKey;
import org.jetbrains.annotations.NotNull;

public class OtlStructureViewElement implements StructureViewTreeElement, SortableTreeElement {
    private final NavigatablePsiElement element;

    public OtlStructureViewElement(NavigatablePsiElement element) {
        this.element = element;
    }

    @Override
    public Object getValue() {
        return element;
    }

    @Override
    public @NotNull String getAlphaSortKey() {
        String name = element.getName();
        return name != null ? name : "";
    }

    @Override
    public @NotNull ItemPresentation getPresentation() {
        ItemPresentation presentation = element.getPresentation();
        return presentation != null ? presentation : new PresentationData();
    }

    @Override
    public TreeElement @NotNull [] getChildren() {
        if (element instanceof OtlKlassKey) return getChildItem(OtlKlassKey.class, OtlKlassKeyImpl.class);
        else if (element instanceof OtlMethodKey) return getChildItem(OtlMethodKey.class, OtlMethodKeyImpl.class);
        else if (element instanceof OtlVariableKey) return getChildItem(OtlVariableKey.class, OtlVariableKeyImpl.class);
        else return EMPTY_ARRAY;
    }

    @NotNull
    private <T extends PsiElement, I extends ASTWrapperPsiElement> TreeElement[] getChildItem(Class<T> klass, Class<I> psi) {
        return PsiTreeUtil.getChildrenOfTypeAsList(element, klass)
                .stream()
                .map(psi::cast)
                .map(OtlStructureViewElement::new)
                .toArray(TreeElement[]::new);
    }

    @Override
    public void navigate(boolean requestFocus) {
        element.navigate(requestFocus);
    }

    @Override
    public boolean canNavigate() {
        return element.canNavigate();
    }

    @Override
    public boolean canNavigateToSource() {
        return element.canNavigateToSource();
    }
}
