package com.otl.sdk.language.util;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import com.otl.sdk.language.OtlFileType;
import com.otl.sdk.language.element.OtlNamedElement;
import com.otl.sdk.language.psi.OtlFile;

import java.util.ArrayList;
import java.util.List;

class OtlUtilFind {
    public static <T extends PsiElement> List<T> findName(Class<T> klass, Project project) {
        List<T> result = new ArrayList<>();
        for (VirtualFile vf : FileTypeIndex.getFiles(OtlFileType.INSTANCE, GlobalSearchScope.allScope(project))) {
            if (PsiManager.getInstance(project).findFile(vf) instanceof OtlFile otlFile)
                result.addAll(PsiTreeUtil.getChildrenOfTypeAsList(otlFile, klass));
        }
        return result;
    }

    public static <T extends PsiElement> List<T> findName(Class<T> klass, Project project, String key) {
        List<T> result = new ArrayList<>();
        for (VirtualFile vf : FileTypeIndex.getFiles(OtlFileType.INSTANCE, GlobalSearchScope.allScope(project))) {
            if (PsiManager.getInstance(project).findFile(vf) instanceof OtlFile otlFile) {
                for (T t : PsiTreeUtil.getChildrenOfTypeAsList(otlFile, klass)) {
                    if (t.getChildren()[0] instanceof OtlNamedElement one && key.equals(one.getName())) result.add(t);
                }
            }
        }
        return result;
    }

    public static <T extends PsiElement> List<T> find(Class<T> klass, Project project, String key) {
        List<T> result = new ArrayList<>();
        for (VirtualFile vf : FileTypeIndex.getFiles(OtlFileType.INSTANCE, GlobalSearchScope.allScope(project))) {
            if (PsiManager.getInstance(project).findFile(vf) instanceof OtlFile otlFile) {
                for (T t : PsiTreeUtil.getChildrenOfTypeAsList(otlFile, klass)) {
                    if (key.equals(t.getText())) result.add(t);
                }
            }
        }
        return result;
    }

    public static <T extends PsiElement> List<T> findChild(Class<T> klass, Project project, String key) {
        List<T> result = new ArrayList<>();
        for (VirtualFile vf : FileTypeIndex.getFiles(OtlFileType.INSTANCE, GlobalSearchScope.allScope(project))) {
            if (PsiManager.getInstance(project).findFile(vf) instanceof OtlFile otlFile) {
                for (PsiElement pe : otlFile.getChildren()) addChild(klass, result, key, pe);
            }
        }
        return result;
    }

    private static <T extends PsiElement> void addChild(Class<T> klass, List<T> result,
                                                        String key, PsiElement elements) {
        for (PsiElement element : elements.getChildren()) {
            if (key != null && klass.isInstance(element) && key.equals(element.getText())) result.add(klass.cast(element));
            else addChild(klass, result, key, element);
        }
    }

    public static <T extends PsiElement> List<T> findChild(Class<T> klass, Project project) {
        List<T> result = new ArrayList<>();
        for (VirtualFile vf : FileTypeIndex.getFiles(OtlFileType.INSTANCE, GlobalSearchScope.allScope(project))) {
            if (PsiManager.getInstance(project).findFile(vf) instanceof OtlFile otlFile) {
                for (PsiElement pe : otlFile.getChildren()) addChild(klass, result, pe);
            }
        }
        return result;
    }

    private static <T extends PsiElement> void addChild(Class<T> klass, List<T> result, PsiElement elements) {
        for (PsiElement element : elements.getChildren()) {
            if (klass.isInstance(element)) result.add(klass.cast(element));
            else addChild(klass, result, element);
        }
    }
}
