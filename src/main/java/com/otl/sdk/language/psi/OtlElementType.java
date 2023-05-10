package com.otl.sdk.language.psi;

import com.intellij.psi.tree.IElementType;
import com.otl.sdk.language.OTLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class OtlElementType extends IElementType {
    public OtlElementType(@NonNls @NotNull String debugName) {
        super(debugName, OTLanguage.INSTANCE);
    }
}
