package com.otl.sdk.language;

import com.intellij.lang.cacheBuilder.DefaultWordsScanner;
import com.intellij.lang.cacheBuilder.WordsScanner;
import com.intellij.lang.findUsages.FindUsagesProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.tree.TokenSet;
import com.otl.sdk.language.psi.OtlTokenSets;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import otl.EditToken;

public class OtlFindUsagesProvider implements FindUsagesProvider, EditToken {
    @Override
    public @Nullable WordsScanner getWordsScanner() {
        return new DefaultWordsScanner(new OtlLexerAdapter(),
                OtlTokenSets.KLASS_IDENTIFIER,
                OtlTokenSets.METHOD_IDENTIFIER,
                OtlTokenSets.VARIABLE_IDENTIFIER,
                TokenSet.EMPTY);
    }

    @Override
    public boolean canFindUsagesFor(@NotNull PsiElement psiElement) {
        return psiElement instanceof PsiNamedElement;
    }

    @Override
    public @Nullable @NonNls String getHelpId(@NotNull PsiElement psiElement) {
        return null;
    }

    @Override
    public @Nls @NotNull String getType(@NotNull PsiElement element) {
        return EditToken.super.getType(element);
    }

    @Override
    public @Nls @NotNull String getDescriptiveName(@NotNull PsiElement element) {
        return getName(element);
    }

    @Override
    public @Nls @NotNull String getNodeText(@NotNull PsiElement element, boolean useFullName) {
        return getText(element);
    }
}
