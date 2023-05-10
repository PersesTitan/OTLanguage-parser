package com.otl.sdk.language;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.PsiElement;import com.intellij.psi.tree.IElementType;
import com.otl.sdk.language.psi.OtlTokenType;
import com.intellij.psi.TokenType;

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
//ALL_CHARACTER=[^\r\n]

KLASS_IDENTIFIER=[a-zA-Zㄱ-ㅣ가-힝]+[a-zA-Zㄱ-ㅣ가-힝0-9_-]*
METHOD_IDENTIFIER=[a-zA-Zㄱ-ㅣ가-힝]+[a-zA-Zㄱ-ㅣ가-힝0-9_-]*
VARIABLE_IDENTIFIER=[a-zA-Zㄱ-ㅣ가-힝]+[a-zA-Zㄱ-ㅣ가-힝0-9_-]*

REMARK={WHITE_SPACE}*"#"[^\r\n]*

//CRLF=\R
WHITE_SPACE=[\ \t\f]
START={WHITE_SPACE}*[^\r\n]*
//NAME=[^\ \t\f\n]+
//PARAMS="[]"|{DEFINE_PARAMS}
//
//DEFINE_PARAM="[]"
//DEFINE_PARAMS=("["{KLASS_IDENTIFIER}{WHITE_SPACE}+{VARIABLE_IDENTIFIER}"]")+

//IMPORT="ㅇㅍㅇ"
KLASS="ㅋㅅㅋ"
METHOD="ㅁㅅㅁ"
LOOP_S="{"
LOOP_E="}"

%state WAITING_VALUE
%state DEFINE_KLASS, DEFINE_PARAMS
%%

<YYINITIAL> {
    {REMARK}                  { yybegin(YYINITIAL); return OtlTypes.REMARK; }
    {KLASS}                   { yybegin(DEFINE_KLASS); return OtlTypes.ㅋㅅㅋ; }
}

<DEFINE_KLASS> {
    {WHITE_SPACE}+             { return TokenType.WHITE_SPACE; }
    {KLASS_IDENTIFIER}         { return OtlTypes.KLASS_IDENTIFIER; }
    "["                        { return OtlTypes.PARAM_S; }
    {KLASS_IDENTIFIER}         { return OtlTypes.KLASS_IDENTIFIER; }
    {WHITE_SPACE}+             { return TokenType.WHITE_SPACE; }
    {VARIABLE_IDENTIFIER}      { return OtlTypes.VARIABLE_IDENTIFIER; }
    "]"                        { yybegin(DEFINE_KLASS); return OtlTypes.PARAM_E; }
    {WHITE_SPACE}*             { return TokenType.WHITE_SPACE; }
    {LOOP_S}                   { yybegin(YYINITIAL); return OtlTypes.LOOP_S; }
//    [^]                        { return TokenType.BAD_CHARACTER; }
}

{WHITE_SPACE}*{NEW_LINE}+{WHITE_SPACE}*            { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
[^]                                                { return TokenType.BAD_CHARACTER; }