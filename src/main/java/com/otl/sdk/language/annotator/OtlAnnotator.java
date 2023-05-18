package com.otl.sdk.language.annotator;

import com.intellij.codeInspection.ProblemHighlightType;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.otl.sdk.language.psi.*;
import com.otl.sdk.language.util.OtlDefineKlassUtil;
import org.jetbrains.annotations.NotNull;

public class OtlAnnotator implements Annotator {
    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        Project project = element.getProject();
        if (element instanceof OtlKlassKeyName item) {
            TextRange textRange = item.getTextRange();
            if (OtlDefineKlassUtil.isDefineKlass(project, item.getKey())) {
                holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                        .textAttributes(DefaultLanguageHighlighterColors.KEYWORD)
                        .range(textRange)
                        .create();
            } else {
                holder.newAnnotation(HighlightSeverity.ERROR, item.getKey() + " is already defined class name")
                        .range(textRange)
                        .create();
            }
        } else if (element instanceof OtlDefineParams items) {
            for (OtlKlassName item : items.getKlassNameList()) checkKlass(holder, project, item);
        } else if (element instanceof OtlCreateVariable items) {
            for (OtlKlassName item : items.getKlassNameList()) checkKlass(holder, project, item);
        }
    }

    private void checkKlass(AnnotationHolder holder, Project project, OtlKlassName item) {
        TextRange textRange = item.getTextRange();
        if (OtlDefineKlassUtil.isKlass(project, item.getKey()))
            holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .textAttributes(DefaultLanguageHighlighterColors.KEYWORD)
                    .range(textRange)
                    .create();
        else holder.newAnnotation(HighlightSeverity.ERROR, "Unresolved type")
                    .range(textRange)
                    .create();
    }
}
