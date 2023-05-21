package com.otl.sdk.language.view;

import com.intellij.lang.refactoring.RefactoringSupportProvider;
import com.intellij.psi.PsiElement;
import com.otl.sdk.language.psi.OtlKlassKey;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class OtlRefactoringSupportProvider extends RefactoringSupportProvider {
    @Override
    public boolean isMemberInplaceRenameAvailable(@NotNull PsiElement element, @Nullable PsiElement context) {
        return element instanceof OtlKlassKey;
    }
}
