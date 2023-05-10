package com.otl.sdk.language.view;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiNamedElement;
import com.intellij.util.ProcessingContext;
import com.otl.sdk.language.psi.OtlElementType;
import com.otl.sdk.language.psi.OtlTokenType;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class OtlCompletionContributor extends CompletionContributor {
    public OtlCompletionContributor() {
//        extend(CompletionType.CLASS_NAME, PlatformPatterns.psiElement(GeneratedTypes.KLASS), new CompletionProvider<>() {
//            @Override
//            protected void addCompletions(@NotNull CompletionParameters parameters,
//                                          @NotNull ProcessingContext context,
//                                          @NotNull CompletionResultSet result) {
//                result.addAllElements(List.of(
//                        LookupElementBuilder.create(GeneratedTypes.ㅇㄱㅇ),
//                        LookupElementBuilder.create(GeneratedTypes.ㅇㅁㅇ),
//                        LookupElementBuilder.create(GeneratedTypes.ㅇㅂㅇ),
//                        LookupElementBuilder.create(GeneratedTypes.ㅇㅅㅇ),
//                        LookupElementBuilder.create(GeneratedTypes.ㅇㅆㅇ),
//                        LookupElementBuilder.create(GeneratedTypes.ㅇㅈㅇ),
//                        LookupElementBuilder.create(GeneratedTypes.ㅇㅉㅇ),
//                        LookupElementBuilder.create(GeneratedTypes.ㅇㅍㅇ)
//                ));
//            }
//        });
    }
}
