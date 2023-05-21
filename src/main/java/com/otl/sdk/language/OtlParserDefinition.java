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

    @NotNull
    @Override
    public PsiParser createParser(Project project) {
        return new OtlParser();
    }

    @NotNull
    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }

    @NotNull
    @Override
    public TokenSet getCommentTokens() {
        return OtlTokenSets.REMARK;
    }

    @NotNull
    @Override
    public TokenSet getStringLiteralElements() {
        return TokenSet.EMPTY;
    }

    @NotNull
    @Override
    public PsiElement createElement(ASTNode node) {
        return OtlTypes.Factory.createElement(node);
    }

    @NotNull
    @Override
    public PsiFile createFile(@NotNull FileViewProvider viewProvider) {
        return new OtlFile(viewProvider);
    }
}
