package com.otl.sdk.language.annotator;

import com.intellij.codeInspection.ProblemHighlightType;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.otl.sdk.language.psi.OtlCreateVariable;
import com.otl.sdk.language.psi.OtlDefineKlass;
import com.otl.sdk.language.psi.OtlDefineParams;
import com.otl.sdk.language.psi.OtlKlassName;
import com.otl.sdk.language.util.OtlCreateDefineQuickFix;
import com.otl.sdk.language.util.OtlDefineKlassUtil;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class OtlAnnotator implements Annotator {
    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
//        element = element.getParent();
        if (element instanceof OtlDefineKlass item) {
            String key = item.getKey();
            TextRange textRange = item.getNameIdentifier().getTextRange();

//            holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
//                    .range(textRange)
//                    .textAttributes(DefaultLanguageHighlighterColors.KEYWORD)
//                    .create();

            List<OtlDefineKlass> otls = OtlDefineKlassUtil.findDefineKlass(element.getProject(), item.getKey());
            if (otls.isEmpty())
                holder.newAnnotation(HighlightSeverity.ERROR, "Unresolved class")
                    .highlightType(ProblemHighlightType.LIKE_UNKNOWN_SYMBOL)
                    .range(textRange)
                    .withFix(new OtlCreateDefineQuickFix(key))
                    .create();
            else
                holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .textAttributes(DefaultLanguageHighlighterColors.KEYWORD)
                    .range(textRange)
                    .create();
        } else if (element instanceof OtlDefineParams items) {
            for (OtlKlassName item : items.getKlassNameList()) checkKlass(holder, element.getProject(), item);
        } else if (element instanceof OtlCreateVariable items) {
            for (OtlKlassName item : items.getKlassNameList()) checkKlass(holder, element.getProject(), item);
        }
    }

    private void checkKlass(AnnotationHolder holder, Project project, OtlKlassName item) {
        String key = item.getKey();
        TextRange textRange = item.getNameIdentifier().getTextRange();
        if (OtlToken.ORIGIN_TYPE.contains(key) || OtlDefineKlassUtil.isDefineKlass(project, item.getKey()))
            holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .textAttributes(DefaultLanguageHighlighterColors.KEYWORD)
                    .range(textRange)
                    .create();
        else holder.newAnnotation(HighlightSeverity.ERROR, "Unresolved type")
                    .range(textRange)
                    .create();
    }
}
