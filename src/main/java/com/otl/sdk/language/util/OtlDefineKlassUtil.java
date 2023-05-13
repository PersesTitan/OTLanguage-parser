package com.otl.sdk.language.util;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import com.otl.sdk.language.OtlFileType;
import com.otl.sdk.language.psi.OtlDefineKlass;
import com.otl.sdk.language.psi.OtlFile;

import java.util.*;

public class OtlDefineKlassUtil {
    public static List<OtlDefineKlass> findDefineKlass(Project project, String key) {
        List<OtlDefineKlass> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles =
                FileTypeIndex.getFiles(OtlFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            if (PsiManager.getInstance(project).findFile(virtualFile) instanceof OtlFile otlFile) {
                OtlDefineKlass[] items = PsiTreeUtil.getChildrenOfType(otlFile, OtlDefineKlass.class);
                if (items != null) {
                    for (OtlDefineKlass item : items) {
                        if (key.equals(item.getKey())) result.add(item);
                    }
                }
            }
        }
        return result;
    }

    public static List<OtlDefineKlass> findDefineKlass(Project project) {
        List<OtlDefineKlass> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles =
                FileTypeIndex.getFiles(OtlFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            if (PsiManager.getInstance(project).findFile(virtualFile) instanceof OtlFile otlFile) {
                OtlDefineKlass[] items = PsiTreeUtil.getChildrenOfType(otlFile, OtlDefineKlass.class);
                if (items != null) Collections.addAll(result, items);
            }
        }
        return result;
    }

    public static boolean isDefineKlass(Project project, String type) {
        for (VirtualFile vf : FileTypeIndex.getFiles(OtlFileType.INSTANCE, GlobalSearchScope.allScope(project))) {
            OtlDefineKlass[] ks;
            if (PsiManager.getInstance(project).findFile(vf) instanceof OtlFile otlFile
                    && (ks = PsiTreeUtil.getChildrenOfType(otlFile, OtlDefineKlass.class)) != null) {
                for (OtlDefineKlass k : ks) if (type.equals(k.getKey())) return true;
            }
        }
        return false;
    }
}
