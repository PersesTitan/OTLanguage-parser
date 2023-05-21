package com.otl.sdk.language.syntax;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import com.otl.sdk.language.OtlLexerAdapter;
import com.otl.sdk.language.OtlTypes;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.DefaultLanguageHighlighterColors.*;
import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class OtlSyntaxHighlighter extends SyntaxHighlighterBase {

    @Override
    public @NotNull Lexer getHighlightingLexer() {
        return new OtlLexerAdapter();
    }

    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
        return OtlSyntaxHighlighterItem.getKeys(tokenType);
    }
}
