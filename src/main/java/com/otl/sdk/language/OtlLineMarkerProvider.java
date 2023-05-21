package com.otl.sdk.language;

import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo;
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerProvider;
import com.intellij.codeInsight.navigation.NavigationGutterIconBuilder;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.otl.sdk.language.psi.OtlKlassKey;
import com.otl.sdk.language.util.OtlDefineKlassUtil;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;

public class OtlLineMarkerProvider extends RelatedItemLineMarkerProvider {
    @Override
    protected void collectNavigationMarkers(@NotNull PsiElement element,
                                            @NotNull Collection<? super RelatedItemLineMarkerInfo<?>> result) {
        Project project = element.getProject();
        if (element instanceof OtlKlassKey okn) {
            List<OtlKlassKey> names = OtlDefineKlassUtil.findKlassName(project, okn.getKey());
            if (names.size() > 0) {
                result.add(
                        NavigationGutterIconBuilder
                                .create(OtlIcons.FILE)
                                .setTargets(names)
                                .createLineMarkerInfo(element)
                );
            }
        }
    }
}
