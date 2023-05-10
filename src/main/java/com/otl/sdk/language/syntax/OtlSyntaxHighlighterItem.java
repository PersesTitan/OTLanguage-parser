package com.otl.sdk.language.syntax;

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;

public enum OtlSyntaxHighlighterItem {
    REMARK("OTL_REMARK", DefaultLanguageHighlighterColors.LINE_COMMENT),
    KLASS_DEFINE("OTL_KLASS", DefaultLanguageHighlighterColors.CLASS_REFERENCE)
    ;

    private final String name;
    private final TextAttributesKey key;
    private final TextAttributesKey[] keys;

    OtlSyntaxHighlighterItem(String name, TextAttributesKey key, TextAttributesKey[] keys) {
        this.name = name;
        this.key = TextAttributesKey.createTextAttributesKey(name, key);
        this.keys = keys;
    }

    OtlSyntaxHighlighterItem(String name, TextAttributesKey key) {
        this(name, key, new TextAttributesKey[]{key});
    }

    public String getName() {
        return name;
    }

    public TextAttributesKey getKey() {
        return key;
    }

    public TextAttributesKey[] getKeys() {
        return keys;
    }
}
