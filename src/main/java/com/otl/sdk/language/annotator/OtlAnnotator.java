package com.otl.sdk.language.annotator;

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
        if (element instanceof OtlKlassKey item) {
            TextRange textRange = item.getTextRange();
            if (OtlDefineKlassUtil.isDefineKlass(project, item.getKey())) addHolder(holder, textRange);
            else addHolder(holder, item.getKey() + " is already defined class name", textRange);
        } else if (element instanceof OtlDefineParams items) {
            for (OtlKlassKey item : items.getKlassKeyList()) checkKlass(holder, project, item);
        } else if (element instanceof OtlCreateVariable items) checkKlass(holder, project, items.getKlassKey());
    }


    private void checkKlass(AnnotationHolder holder, Project project, OtlKlassKey item) {
        TextRange textRange = item.getTextRange();
        if (OtlDefineKlassUtil.isDefineKlass(project, item.getKey()))
            addHolder(holder, textRange);
        else addHolder(holder, "Unresolved type", textRange);
    }

    private void addHolder(AnnotationHolder holder, TextRange textRange) {
        holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                .textAttributes(DefaultLanguageHighlighterColors.KEYWORD)
                .range(textRange)
                .create();
    }

    private void addHolder(AnnotationHolder holder, String message, TextRange textRange) {
        holder.newAnnotation(HighlightSeverity.ERROR, message)
                .range(textRange)
                .create();
    }
}
