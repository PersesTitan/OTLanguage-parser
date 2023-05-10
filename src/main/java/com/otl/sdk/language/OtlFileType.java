package com.otl.sdk.language;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class OtlFileType extends LanguageFileType {
    public static final OtlFileType INSTANCE = new OtlFileType();

    protected OtlFileType() {
        super(OTLanguage.INSTANCE);
    }

    @Override
    public @NonNls @NotNull String getName() {
        return "OTLanguage";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "OTLanguage file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "otl";
    }

    @Override
    public Icon getIcon() {
        return OtlIcons.FILE;
    }
}
