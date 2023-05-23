package com.otl.sdk.language.root;

import com.intellij.icons.AllIcons;
import com.intellij.ide.navigationToolbar.StructureAwareNavBarModelExtension;
import com.intellij.lang.Language;
import com.otl.sdk.language.OTLanguage;
import com.otl.sdk.language.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class OtlStructureAwareNavbar extends StructureAwareNavBarModelExtension {
    @NotNull
    @Override
    protected Language getLanguage() {
        return OTLanguage.INSTANCE;
    }

    @Override
    public @Nullable String getPresentableText(Object object) {
        if (object instanceof OtlFile item) return item.getName();
        else if (object instanceof OtlKlassKey item) return item.getName();
        return null;
    }

    @Override
    public @Nullable Icon getIcon(Object object) {
        if (object instanceof OtlKlassKey) return AllIcons.Nodes.Class;
        else if (object instanceof OtlMethodKey) return AllIcons.Nodes.Method;
        else if (object instanceof OtlValueKey) return AllIcons.Nodes.Variable;
        else return null;
    }
}
