package com.otl.sdk.language.util;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import com.otl.sdk.language.OtlFileType;
import com.otl.sdk.language.annotator.OtlToken;
import com.otl.sdk.language.element.OtlNamedElement;
import com.otl.sdk.language.psi.OtlDefineKlass;
import com.otl.sdk.language.psi.OtlFile;
import com.otl.sdk.language.psi.OtlKlassKeyName;
import com.otl.sdk.language.psi.OtlKlassName;

import java.util.*;

public class OtlDefineKlassUtil extends OtlUtilFind {
    public static List<OtlKlassKeyName> findDefineKlass(Project project, String key) {
        return findName(OtlKlassKeyName.class, project, key);
    }

    public static List<OtlKlassKeyName> findDefineKlass(Project project) {
        return findName(OtlKlassKeyName.class, project);
    }

    public static List<OtlKlassName> findKlassName(Project project, String key) {
        return findChild(OtlKlassName.class, project, key);
    }

    public static List<OtlKlassName> findKlassName(Project project) {
        return findChild(OtlKlassName.class, project);
    }

    public static <T extends PsiElement> boolean isFind(Class<T> klass, Project project, String key) {
        int count = 0;
        for (VirtualFile vf : FileTypeIndex.getFiles(OtlFileType.INSTANCE, GlobalSearchScope.allScope(project))) {
            if (PsiManager.getInstance(project).findFile(vf) instanceof OtlFile otlFile) {
                for (T t : PsiTreeUtil.getChildrenOfTypeAsList(otlFile, klass)) {
                    if (t.getChildren()[0] instanceof OtlNamedElement one
                            && key.equals(one.getName()) && count++ > 1) return false;
                }
            }
        }
        return count == 1;
    }

    public static boolean isDefineKlass(Project project, String type) {
        return !OtlToken.ORIGIN_TYPE.contains(type) && isFind(OtlDefineKlass.class, project, type);
    }

    public static boolean isKlass(Project project, String type) {
        if (OtlToken.ORIGIN_TYPE.contains(type)) return true;
        for (VirtualFile vf : FileTypeIndex.getFiles(OtlFileType.INSTANCE, GlobalSearchScope.allScope(project))) {
            OtlDefineKlass[] ts;
            if (PsiManager.getInstance(project).findFile(vf) instanceof OtlFile otlFile
                    && (ts = PsiTreeUtil.getChildrenOfType(otlFile, OtlDefineKlass.class)) != null) {
                for (OtlDefineKlass t : ts) {
                    OtlKlassKeyName kkn = t.getKlassKeyName();
                    if (kkn != null && type.equals(kkn.getKey())) return true;
                }
            }
        }
        return false;
    }

    private static <T extends PsiElement> boolean isDefineKlass(Class<T> klass, Project project, String type) {
        for (VirtualFile vf : FileTypeIndex.getFiles(OtlFileType.INSTANCE, GlobalSearchScope.allScope(project))) {
            T[] ts;
            if (PsiManager.getInstance(project).findFile(vf) instanceof OtlFile otlFile
                    && (ts = PsiTreeUtil.getChildrenOfType(otlFile, klass)) != null) {
                for (T t : ts) if (type.equals(t.getText())) return true;
            }
        }
        return false;
    }
}
