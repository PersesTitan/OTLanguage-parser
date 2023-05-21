package com.otl.sdk.language;

import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.otl.sdk.language.annotator.OtlToken;

public class OtlFlex {
    public static IElementType tokenKM(OtlLexer lexer) {
        return switch (lexer.yystate()) {
            case OtlLexer.IS_KLASS -> OtlTypes.KLASS_IDENTIFIER;
            case OtlLexer.IS_METHOD -> OtlTypes.METHOD_IDENTIFIER;
            default -> TokenType.BAD_CHARACTER;
        };
    }

    public static int loopKM(OtlLexer lexer) {
        return switch (lexer.yystate()) {
            case OtlLexer.IS_KLASS -> OtlLexer.KLASS_LOOP;
            case OtlLexer.IS_METHOD -> OtlLexer.METHOD_LOOP;
            default -> OtlLexer.YYINITIAL;
        };
    }

    public static int max(OtlLexer lexer) {
        return max(lexer.yytext().toString());
    }

    public static int min(OtlLexer lexer) {
        return min(lexer.yytext().toString());
    }

    private static int max(String text) {
        int result = 0;
        for (char c : text.toCharArray()) {
            if (c == ' ' || c == '\t' || c == '\f') result++;
            else break;
        }
        return text.length() - result;
    }

    //   0    1    2    3    4    5
    // ['a', 'b', 'c', ' ', 'd', ' '] => 3
    private static int min(String text) {
        int value = 0;
        for (char c : text.toCharArray()) {
            if (c == ' ' || c == '\t' || c == '\f') break;
            else value++;
        }
        return text.length() - value;
    }

    public static IElementType checkType(OtlLexer lexer) {
        return switch (lexer.yytext().toString()) {
            case OtlToken.KLASS -> {
                lexer.yybegin(OtlLexer.IS_KLASS);
                yield OtlTypes.ㅋㅅㅋ;
            }
            case OtlToken.METHOD -> {
                lexer.yybegin(OtlLexer.IS_METHOD);
                yield OtlTypes.ㅁㅅㅁ;
            }
            case OtlToken.STATIC_METHOD -> {
                lexer.yybegin(OtlLexer.IS_METHOD);
                yield OtlTypes.ㅁㅆㅁ;
            }
            case OtlToken.IMPORT -> {
                lexer.yybegin(OtlLexer.IMPORT);
                yield OtlTypes.ㅇㅍㅇ;
            }
            default -> {
                lexer.yybegin(OtlLexer.CREATE_VARIABLE);
                yield OtlTypes.KLASS_IDENTIFIER;
            }
        };
    }
}
