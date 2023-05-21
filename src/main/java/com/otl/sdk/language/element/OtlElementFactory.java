package com.otl.sdk.language.element;

import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFileFactory;
import com.otl.sdk.language.OtlFileType;
import com.otl.sdk.language.psi.OtlDefineKlass;
import com.otl.sdk.language.psi.OtlDefineParams;
import com.otl.sdk.language.psi.OtlFile;

public class OtlElementFactory {
    public static <T> T create(Project project, String name) {
        return (T) createFile(project, name).getFirstChild();
    }

    public static OtlFile createFile(Project project, String text) {
        return (OtlFile) PsiFileFactory
                .getInstance(project)
                .createFileFromText("dummy.otl", OtlFileType.INSTANCE, text);
    }

    public static OtlDefineKlass createKlass(Project project, String name, String value) {
        return (OtlDefineKlass) createFile(project, name + " = " + value);
    }

    public static PsiElement createCRLF(Project project) {
        return createFile(project, System.lineSeparator()).getFirstChild();
    }
}
