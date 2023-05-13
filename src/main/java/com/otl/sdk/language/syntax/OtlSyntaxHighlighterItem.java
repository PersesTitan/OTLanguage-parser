package com.otl.sdk.language.syntax;

import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.otl.sdk.language.OtlTypes;

import static com.intellij.openapi.editor.DefaultLanguageHighlighterColors.*;

public enum OtlSyntaxHighlighterItem {
    REMARK("OTL_REMARK", OtlTypes.REMARK, LINE_COMMENT),
    ㅋㅅㅋ("ㅋㅅㅋ", OtlTypes.ㅋㅅㅋ, CLASS_REFERENCE),
    ㅁㅅㅁ("ㅁㅅㅁ", OtlTypes.ㅁㅅㅁ, FUNCTION_DECLARATION),

//    KLASS_DEFINE("OTL_KLASS", OtlTypes.KLASS_KEY, CLASS_NAME),
    KLASS_NAME("OTL_KLASS_NAME", OtlTypes.KLASS_IDENTIFIER, CLASS_NAME),
//    METHOD_DEFINE("OTL_METHOD", OtlTypes.METHOD_KEY, FUNCTION_CALL),
    METHOD_NAME("OTL_METHOD_NAME", OtlTypes.METHOD_IDENTIFIER, FUNCTION_CALL),
    VARIABLE_DEFINE("OTL_VARIABLE", OtlTypes.VARIABLE_IDENTIFIER, LOCAL_VARIABLE),

    BAD_CHARACTER("OTL_BAD_CHARACTER", TokenType.BAD_CHARACTER, HighlighterColors.BAD_CHARACTER)
    ;

    private final static TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];
    private final IElementType type;
    private final TextAttributesKey[] keys;
    public final TextAttributesKey key;

    OtlSyntaxHighlighterItem(String name, IElementType type, TextAttributesKey key, TextAttributesKey[] keys) {
        this.key = TextAttributesKey.createTextAttributesKey(name, key);
        this.type = type;
        this.keys = keys;
    }

    OtlSyntaxHighlighterItem(String name, IElementType type, TextAttributesKey key) {
        this(name, type, key, new TextAttributesKey[]{key});
    }

    public static TextAttributesKey[] getKeys(IElementType tokenType) {
        for (OtlSyntaxHighlighterItem item : OtlSyntaxHighlighterItem.values()) {
            if (item.type.equals(tokenType)) return item.keys;
        }
        return EMPTY_KEYS;
    }
}
