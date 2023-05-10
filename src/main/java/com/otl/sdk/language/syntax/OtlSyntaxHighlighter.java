package com.otl.sdk.language.syntax;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
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
    public static final TextAttributesKey
            REMARK = createTextAttributesKey("OTL_REMARK", LINE_COMMENT),
            KLASS_DEFINE = createTextAttributesKey("OTL_KLASS", CLASS_REFERENCE),
            KLASS_NAME = createTextAttributesKey("OTL_KLASS_NAME", CLASS_NAME),
            METHOD_DEFINE = createTextAttributesKey("OTL_METHOD", FUNCTION_DECLARATION),
            METHOD_NAME = createTextAttributesKey("OTL_METHOD_NAME", FUNCTION_CALL)
            ;

    private static final TextAttributesKey[]
            REMARK_KEYS = new TextAttributesKey[]{REMARK},
            KLASS_DEFINE_KEYS = new TextAttributesKey[]{KLASS_DEFINE},
            KLASS_NAME_KEYS = new TextAttributesKey[]{KLASS_NAME},
            METHOD_DEFINE_KEYS = new TextAttributesKey[]{METHOD_DEFINE},
            METHOD_NAME_KEYS = new TextAttributesKey[]{METHOD_NAME}
            ;

    // default syntax highlighter
    public static final TextAttributesKey
            BAD_CHARACTER = createTextAttributesKey("OTL_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);

    private static final TextAttributesKey[]
            BAD_CHARACTER_KEYS = new TextAttributesKey[] {BAD_CHARACTER},
            EMPTY_KEYS = new TextAttributesKey[0]
            ;

    @Override
    public @NotNull Lexer getHighlightingLexer() {
        return new OtlLexerAdapter();
    }

    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
        if (tokenType.equals(OtlTypes.REMARK)) return REMARK_KEYS;
        else if (tokenType.equals(OtlTypes.ㅋㅅㅋ)) return KLASS_DEFINE_KEYS;
        else if (tokenType.equals(OtlTypes.ㅁㅅㅁ)) return METHOD_DEFINE_KEYS;
        else if (tokenType.equals(OtlTypes.METHOD_NAME)) return METHOD_NAME_KEYS;
        else return EMPTY_KEYS;
    }
}
