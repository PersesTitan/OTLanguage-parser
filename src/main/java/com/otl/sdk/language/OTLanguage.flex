package com.otl.sdk.language;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.TokenType;
import com.otl.sdk.language.annotator.OtlToken;

%%
%class OtlLexer
%implements FlexLexer
%unicode
%line
%function advance
%type IElementType
%eof{  return;
%eof}


NEW_LINE=\r|\n|\r\n
ALL_CHARACTER=[^\r\n]

VARIABLE_IDENTIFIER=[a-zA-Zㄱ-ㅣ가-힝]+[a-zA-Zㄱ-ㅣ가-힝0-9_-]*
KLASS_IDENTIFIER=[a-zA-Zㄱ-ㅣ가-힝]+[a-zA-Zㄱ-ㅣ가-힝0-9_-]*
METHOD_IDENTIFIER=[a-zA-Zㄱ-ㅣ가-힝]+[a-zA-Zㄱ-ㅣ가-힝0-9_-]*

REMARK={WHITE_SPACE}*"#"{ALL_CHARACTER}*

//CRLF=\R
WHITE_SPACE=[\ \t\f]
START={WHITE_SPACE}*[^\r\n]*
//NAME=[^\ \t\f\n]+
//PARAMS="[]"|{DEFINE_PARAMS}
//
//DEFINE_PARAM="[]"
//DEFINE_PARAMS=("["{KLASS_IDENTIFIER}{WHITE_SPACE}+{VARIABLE_IDENTIFIER}"]")+

IMPORT="ㅇㅍㅇ"
KLASS="ㅋㅅㅋ"
METHOD="ㅁㅅㅁ"
LOOP_S="{"
LOOP_E="}"
PARAM_S="["
PARAM_E="]"

%{
    IElementType gokm() {
        return switch (yystate()) {
            case IS_KLASS -> OtlTypes.KLASS_KEY;
            case IS_METHOD -> OtlTypes.METHOD_KEY;
            default -> TokenType.BAD_CHARACTER;
        };
    }

    // 텍스트<공백> => "공백" 길이
    int backBlank() {
        CharSequence cs = yytext();
        int size = 0;
        for (int i=cs.length()-1; i>=0; i--) {
            if (OtlToken.BLANKS.contains(cs.charAt(i))) size++;
        }
        return size;
    }

    // <공백>텍스트 => "텍스트" 길이
    int blank() {
        int count = 0;
        for (char c : yytext().toString().toCharArray()) {
            if (OtlToken.BLANKS.contains(c)) count++;
            else break;
        }
        return yylength() - count;
    }
%}
%state IMPORT
%state VALUE
%state CREATE_VARIABLE
%state IS_KLASS IS_METHOD
%%

<YYINITIAL> {
    {REMARK}                  { yybegin(YYINITIAL); return OtlTypes.REMARK; }
    {IMPORT}{WHITE_SPACE}+    { yypushback(backBlank()); yybegin(IMPORT); return OtlTypes.ㅇㅍㅇ; }
    {KLASS}{WHITE_SPACE}+     { yypushback(backBlank()); yybegin(IS_KLASS); return OtlTypes.ㅋㅅㅋ; }
    {METHOD}{WHITE_SPACE}+    { yypushback(backBlank()); yybegin(IS_METHOD); return OtlTypes.ㅁㅅㅁ; }
    {KLASS_IDENTIFIER}{WHITE_SPACE}+ { yypushback(backBlank()); yybegin(CREATE_VARIABLE); return OtlTypes.KLASS_IDENTIFIER; }
}

<IMPORT> {
    {WHITE_SPACE}+             { return TokenType.WHITE_SPACE; }
    {ALL_CHARACTER}+           { yybegin(YYINITIAL); return OtlTypes.IMPORT_KEY; }
}

<CREATE_VARIABLE> {
    {WHITE_SPACE}+{VARIABLE_IDENTIFIER}     { yypushback(blank()); return TokenType.WHITE_SPACE; }
    ":"{ALL_CHARACTER}*                     { yypushback(yylength()-1); yybegin(VALUE); return OtlTypes.VAR_TOKEN; }
    {VARIABLE_IDENTIFIER}":"                { yypushback(1); return OtlTypes.VARIABLE_IDENTIFIER; }
}

<VALUE>{ALL_CHARACTER}*           { yybegin(YYINITIAL); return OtlTypes.VALUE_KEY; }

<IS_KLASS, IS_METHOD> {
    {WHITE_SPACE}+({KLASS_IDENTIFIER}|{METHOD_IDENTIFIER})   { yypushback(blank()); return TokenType.WHITE_SPACE; }
    ({KLASS_IDENTIFIER}|{METHOD_IDENTIFIER}){PARAM_S}        { yypushback(1); return gokm(); }
    {PARAM_S}({PARAM_E}|{KLASS_IDENTIFIER})                  { yypushback(yylength()-1); return OtlTypes.PARAM_S; }
    {PARAM_E}                                                { return OtlTypes.PARAM_E; }
    {KLASS_IDENTIFIER}{WHITE_SPACE}+                         { yypushback(backBlank()); return OtlTypes.KLASS_IDENTIFIER; }
    {WHITE_SPACE}+{VARIABLE_IDENTIFIER}                      { yypushback(blank()); return TokenType.WHITE_SPACE; }
    {VARIABLE_IDENTIFIER}{PARAM_E}                           { yypushback(1); return OtlTypes.VARIABLE_IDENTIFIER; }
    {WHITE_SPACE}*{LOOP_S}                                   { yybegin(YYINITIAL); return OtlTypes.LOOP_S; }
}

{WHITE_SPACE}*{NEW_LINE}+{WHITE_SPACE}*            { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
[^]                                                { return TokenType.BAD_CHARACTER; }