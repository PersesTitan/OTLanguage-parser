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
import com.otl.sdk.language.psi.*;

import java.util.*;

public class OtlDefineKlassUtil extends OtlUtilFind {
    public static List<OtlKlassKey> findKlassName(Project project, String key) {
        return findChild(OtlKlassKey.class, project, key);
    }

    public static List<OtlKlassKey> findKlassName(Project project) {
        return findChild(OtlKlassKey.class, project);
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
        return type != null && OtlToken.ORIGIN_TYPE.contains(type) || isFind(OtlDefineKlass.class, project, type);
    }
}
