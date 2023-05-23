package com.otl.sdk.language;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import com.otl.sdk.language.syntax.OtlSyntaxHighlighter;
import com.otl.sdk.language.syntax.OtlSyntaxHighlighterItem;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

public class OtlColorSettingsPage implements ColorSettingsPage {
    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("Class", OtlSyntaxHighlighterItem.ㅋㅅㅋ.key),
            new AttributesDescriptor("Method", OtlSyntaxHighlighterItem.ㅁㅅㅁ.key),
    };

    @Override
    public @Nullable Icon getIcon() {
        return OtlIcons.FILE;
    }

    @Override
    public @NotNull SyntaxHighlighter getHighlighter() {
        return new OtlSyntaxHighlighter();
    }

    @Override
    public @NonNls @NotNull String getDemoText() {
        return
                """
                ㅋㅅㅋ 클래스명[] {
                    ㅁㅅㅁ 메소드1[] {
                        ㅆㅁㅆ Hello World
                    }
                }
                """;
    }

    @Override
    public @Nullable Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }

    @Override
    public AttributesDescriptor @NotNull [] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @Override
    public ColorDescriptor @NotNull [] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @Override
    public @NotNull String getDisplayName() {
        return "OTLanguage";
    }
}
