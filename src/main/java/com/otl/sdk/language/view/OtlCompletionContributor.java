package com.otl.sdk.language.view;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiNamedElement;
import com.intellij.util.ProcessingContext;
import com.otl.sdk.language.OtlTypes;
import com.otl.sdk.language.annotator.OtlToken;
import com.otl.sdk.language.psi.OtlElementType;
import com.otl.sdk.language.psi.OtlTokenSets;
import com.otl.sdk.language.psi.OtlTokenType;
import org.jetbrains.annotations.NotNull;
import otl.EditToken;

import java.util.Arrays;
import java.util.List;

public class OtlCompletionContributor extends CompletionContributor {
    public OtlCompletionContributor() {
        extend(CompletionType.BASIC, PlatformPatterns.psiElement(OtlTypes.KLASS_KEY), new CompletionProvider<>() {
            @Override
            protected void addCompletions(@NotNull CompletionParameters parameters,
                                          @NotNull ProcessingContext context,
                                          @NotNull CompletionResultSet result) {
                result.addAllElements(OtlToken.ORIGIN_TYPE.stream().map(LookupElementBuilder::create).toList());
            }
        });

        extend(CompletionType.BASIC, PlatformPatterns.psiElement(OtlTypes.DEFINE_KLASS), new CompletionProvider<>() {
            @Override
            protected void addCompletions(@NotNull CompletionParameters parameters,
                                          @NotNull ProcessingContext context,
                                          @NotNull CompletionResultSet result) {
                result.addElement(LookupElementBuilder.create(OtlTypes.ㅋㅅㅋ));
            }
        });
    }
}
