package com.otl.sdk.language.root;

import com.intellij.ide.structureView.StructureViewModel;
import com.intellij.ide.structureView.StructureViewModelBase;
import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.util.treeView.smartTree.Sorter;
import com.intellij.openapi.editor.Editor;
import com.intellij.psi.PsiFile;
import com.otl.sdk.language.psi.OtlKlassKey;
import com.otl.sdk.language.psi.OtlMethodKey;
import com.otl.sdk.language.psi.OtlVariableKey;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class OtlStructureViewModel extends StructureViewModelBase implements StructureViewModel.ElementInfoProvider {
    public OtlStructureViewModel(@Nullable Editor editor, PsiFile psiFile) {
        super(psiFile, editor, new OtlStructureViewElement(psiFile));
    }

    @Override
    public Sorter @NotNull [] getSorters() {
        return new Sorter[]{Sorter.ALPHA_SORTER};
    }

    @Override
    public boolean isAlwaysShowsPlus(StructureViewTreeElement element) {
        return false;
    }

    @Override
    public boolean isAlwaysLeaf(StructureViewTreeElement element) {
        Object value = element.getValue();
        return value instanceof OtlKlassKey
                || value instanceof OtlMethodKey
                || value instanceof OtlVariableKey;
    }

    @Override
    protected Class<?> @NotNull [] getSuitableClasses() {
        return new Class[] {OtlKlassKey.class, OtlMethodKey.class, OtlVariableKey.class};
    }
}
