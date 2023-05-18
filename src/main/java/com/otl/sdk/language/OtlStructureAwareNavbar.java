package com.otl.sdk.language;

import com.intellij.ide.navigationToolbar.StructureAwareNavBarModelExtension;
import com.intellij.lang.Language;
import com.otl.sdk.language.psi.OtlFile;
import com.otl.sdk.language.psi.OtlKlassKeyName;
import com.otl.sdk.language.psi.OtlKlassName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class OtlStructureAwareNavbar extends StructureAwareNavBarModelExtension {
    @NotNull
    @Override
    protected Language getLanguage() {
        return OTLanguage.INSTANCE;
    }

    @Override
    public @Nullable String getPresentableText(Object object) {
        if (object instanceof OtlFile item) return item.getName();
        else if (object instanceof OtlKlassName item) return item.getName();
//        else if (object instanceof OtlDefineKlass item) return item.getName();
        else if (object instanceof OtlKlassKeyName item) return item.getName();
        return null;
    }
}
