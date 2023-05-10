package com.otl.sdk.language.view;

import com.intellij.lang.BracePair;
import com.intellij.lang.PairedBraceMatcher;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class OtlTypedHandler implements PairedBraceMatcher {
//    private static final BracePair[] PAIR = {
//            new BracePair(GeneratedTypes.);
//    };

    @Override
    public BracePair @NotNull [] getPairs() {
        return new BracePair[0];
    }

    @Override
    public boolean isPairedBracesAllowedBeforeType(@NotNull IElementType lbraceType,
                                                   @Nullable IElementType contextType) {
        return false;
    }

    @Override
    public int getCodeConstructStart(PsiFile file, int openingBraceOffset) {
        return 0;
    }
}
