package com.otl.sdk.language;

import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.otl.sdk.language.annotator.OtlToken;

public class OtlFlex {
    public static IElementType tokenKM(int state) {
        return switch (state) {
            case OtlLexer.IS_KLASS -> OtlTypes.KLASS_KEY;
            case OtlLexer.IS_METHOD -> OtlTypes.METHOD_KEY;
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

    // 텍스트<공백> => "공백" 길이
    public static int backBlank(CharSequence text) {
        int size = 0;
        for (int i = text.length()-1; i>=0; i--) {
            if (OtlToken.BLANKS.contains(text.charAt(i))) size++;
        }
        return size;
    }

    // <공백>텍스트 => "텍스트" 길이
    public static int blank(CharSequence text) {
        int count = 0;
        for (char c : text.toString().toCharArray()) {
            if (OtlToken.BLANKS.contains(c)) count++;
            else break;
        }
        return text.length() - count;
    }

    public static int max(OtlLexer lexer) {
        return max(lexer.yytext().toString());
    }

    public static int min(OtlLexer lexer) {
        return min(lexer.yytext().toString());
    }

    private static final char[] BLANKS = {' ', '\t', '\f'};
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
        int i, value = text.length();
        for (char blank : BLANKS) if ((i=text.indexOf(blank))>=0) value = Math.min(value, i);
        return text.length() - value;
    }

    public static IElementType checkType(OtlLexer lexer) {
        String text = lexer.yytext().toString();
        return switch (text) {
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
