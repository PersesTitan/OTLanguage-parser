package com.otl.sdk.language;

import com.intellij.lexer.FlexAdapter;

public class OtlLexerAdapter extends FlexAdapter {
    public OtlLexerAdapter() {
        super(new OtlLexer(null));
    }
}
