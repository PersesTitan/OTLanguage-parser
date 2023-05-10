package com.otl.sdk.language.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.otl.sdk.language.OTLanguage;
import com.otl.sdk.language.OtlFileType;
import org.jetbrains.annotations.NotNull;

public class OtlFile extends PsiFileBase {
    public OtlFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, OTLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return OtlFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "OTLanguage Type";
    }
}
