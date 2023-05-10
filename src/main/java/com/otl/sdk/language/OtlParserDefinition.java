package com.otl.sdk.language;

import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import com.otl.sdk.language.psi.OtlFile;
import com.otl.sdk.language.psi.OtlTokenSets;
import org.jetbrains.annotations.NotNull;

public class OtlParserDefinition implements ParserDefinition {
    private final static IFileElementType FILE = new IFileElementType(OTLanguage.INSTANCE);

    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new OtlLexerAdapter();
    }

    @Override
    public @NotNull PsiParser createParser(Project project) {
        return new OtlParser();
    }

    @Override
    public @NotNull IFileElementType getFileNodeType() {
        return FILE;
    }

    @Override
    public @NotNull TokenSet getCommentTokens() {
        return OtlTokenSets.REMARK;
    }

    @Override
    public @NotNull TokenSet getStringLiteralElements() {
        return TokenSet.EMPTY;
    }

    @Override
    public @NotNull PsiElement createElement(ASTNode node) {
        return OtlTypes.Factory.createElement(node);
    }

    @Override
    public @NotNull PsiFile createFile(@NotNull FileViewProvider viewProvider) {
        return new OtlFile(viewProvider);
    }
}
