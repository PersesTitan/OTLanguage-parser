package com.otl.sdk.language;

import com.intellij.lang.Language;

public class OTLanguage extends Language {
    public static final OTLanguage INSTANCE = new OTLanguage();

    private OTLanguage() {
        super("OTLanguage");
    }
}
