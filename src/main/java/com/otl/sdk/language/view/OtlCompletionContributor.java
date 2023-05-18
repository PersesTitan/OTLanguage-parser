package com.otl.sdk.language.view;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiNamedElement;
import com.intellij.util.ProcessingContext;
import com.otl.sdk.language.OtlTypes;
import com.otl.sdk.language.psi.OtlElementType;
import com.otl.sdk.language.psi.OtlTokenType;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class OtlCompletionContributor extends CompletionContributor {
    public OtlCompletionContributor() {
        extend(CompletionType.BASIC, PlatformPatterns.psiElement(OtlTypes.KLASS_KEY), new CompletionProvider<>() {
            @Override
            protected void addCompletions(@NotNull CompletionParameters parameters,
                                          @NotNull ProcessingContext context,
                                          @NotNull CompletionResultSet result) {
                result.addElement(LookupElementBuilder.create("ㅋㅅㅋ"));
                result.addElement(LookupElementBuilder.create(OtlTypes.ㅁㅅㅁ));
                result.addElement(LookupElementBuilder.create(OtlTypes.ㅁㅆㅁ));
                result.addElement(LookupElementBuilder.create(OtlTypes.ㅇㅍㅇ));
            }
        });
    }
}
