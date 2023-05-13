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

%state IMPORT
%state CREATE_VARIABLE

%state DEFINE_KLASS IS_KLASS IS_NAME_KLASS
%state DEFINE_METHOD IS_METHOD IS_NAME_METHOD

%%

<YYINITIAL> {
    {REMARK}                  { yybegin(YYINITIAL); return OtlTypes.REMARK; }
    {IMPORT}                  { yybegin(IMPORT); return OtlTypes.ㅇㅍㅇ; }
    {KLASS}                   { yybegin(DEFINE_KLASS); return OtlTypes.ㅋㅅㅋ; }
    {METHOD}                  { yybegin(DEFINE_METHOD); return OtlTypes.ㅁㅅㅁ; }
}

<IMPORT> {
    {WHITE_SPACE}+             { return TokenType.WHITE_SPACE; }
    {ALL_CHARACTER}+           { yybegin(YYINITIAL); return OtlTypes.IMPORT_KEY; }
}

// =============== DEFINE_METHOD ===============
<DEFINE_METHOD> {
    {WHITE_SPACE}+             { return TokenType.WHITE_SPACE; }
    {METHOD_IDENTIFIER}        { return OtlTypes.METHOD_KEY; }
    {PARAM_S}                  { yybegin(IS_METHOD);  return OtlTypes.PARAM_S; }
    {LOOP_S}                   { yybegin(YYINITIAL); return OtlTypes.LOOP_S; }
    [^]                        { yybegin(YYINITIAL); return TokenType.BAD_CHARACTER; }
}

// <클래스 타입><공백> or <]>
<IS_METHOD> {
    {PARAM_E}                  { yybegin(DEFINE_METHOD); return OtlTypes.PARAM_E; }
    {KLASS_IDENTIFIER}         { return OtlTypes.KLASS_IDENTIFIER; }
    {WHITE_SPACE}+             { yybegin(IS_NAME_METHOD); return TokenType.WHITE_SPACE; }
}

// <변수명><]>
<IS_NAME_METHOD> {
    {VARIABLE_IDENTIFIER}      { return OtlTypes.VARIABLE_IDENTIFIER; }
    {PARAM_E}                  { yybegin(DEFINE_METHOD); return OtlTypes.PARAM_E; }
}

// =============== DEFINE KLASS ===============
<DEFINE_KLASS> {
    {WHITE_SPACE}+             { return TokenType.WHITE_SPACE; }
    {KLASS_IDENTIFIER}         { return OtlTypes.KLASS_KEY; }
    {PARAM_S}                  { yybegin(IS_KLASS); return OtlTypes.PARAM_S; }
    {LOOP_S}                   { yybegin(YYINITIAL); return OtlTypes.LOOP_S; }
    [^]                        { yybegin(YYINITIAL); return TokenType.BAD_CHARACTER; }
}

// <클래스 타입><공백> or <]>
<IS_KLASS> {
    {PARAM_E}                  { yybegin(DEFINE_KLASS); return OtlTypes.PARAM_E; }
    {KLASS_IDENTIFIER}         { return OtlTypes.KLASS_IDENTIFIER; }
    {WHITE_SPACE}+             { yybegin(IS_NAME_KLASS); return TokenType.WHITE_SPACE; }
}

// <변수명><]>
<IS_NAME_KLASS> {
    {VARIABLE_IDENTIFIER}      { return OtlTypes.VARIABLE_IDENTIFIER; }
    {PARAM_E}                  { yybegin(DEFINE_KLASS); return OtlTypes.PARAM_E; }
}

//<DEFINE_PARAMS> {
//
//}

{WHITE_SPACE}*{NEW_LINE}+{WHITE_SPACE}*            { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
[^]                                                { return TokenType.BAD_CHARACTER; }