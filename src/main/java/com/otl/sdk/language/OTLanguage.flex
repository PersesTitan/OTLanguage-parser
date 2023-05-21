package com.otl.sdk.language;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.TokenType;
import java.util.Stack;

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

WHITE_SPACE=[\ \t\f]
PARAM_VALUE=[^\]]

REMARK="#"

IMPORT="ㅇㅍㅇ"
KLASS="ㅋㅅㅋ"
METHOD="ㅁㅅㅁ"
STATIC="ㅁㅆㅁ"
LOOP_S="{"
LOOP_E="}"
PARAM_S="["
PARAM_E="]"

%{
    Stack<Integer> state = new Stack<>();
    public int pop() {
//        return state.isEmpty() ? YYINITIAL : state.lastElement();
        return state.isEmpty() ? YYINITIAL : state.lastElement();
    }
%}

%state IMPORT
%state VALUE LINE
%state CREATE_VARIABLE UPDATE_VARIABLE
%state IS_KLASS IS_METHOD

%state KLASS_LOOP METHOD_LOOP
%%

<VALUE>                     {ALL_CHARACTER}*    { yybegin(pop()); return OtlTypes.VALUE; }
<KLASS_LOOP, METHOD_LOOP>   {LOOP_E}            { state.pop(); yybegin(pop()); return OtlTypes.LOOP_E; }

<YYINITIAL, KLASS_LOOP, METHOD_LOOP> {
    {IMPORT}{WHITE_SPACE}+
        { yypushback(OtlFlex.min(this)); return OtlFlex.checkType(this); }
    {KLASS_IDENTIFIER}{WHITE_SPACE}+{VARIABLE_IDENTIFIER}":"
        { yypushback(OtlFlex.min(this)); yybegin(CREATE_VARIABLE); return OtlTypes.KLASS_IDENTIFIER; }
    ":"?{VARIABLE_IDENTIFIER}":"
        { yypushback(1); yybegin(OtlLexer.UPDATE_VARIABLE); return OtlTypes.VARIABLE_IDENTIFIER; }
}

<YYINITIAL, KLASS_LOOP>({METHOD}|{STATIC}){WHITE_SPACE}+
    { yypushback(OtlFlex.min(this)); state.add(METHOD_LOOP); return OtlFlex.checkType(this); }
<YYINITIAL>{KLASS}{WHITE_SPACE}+
    { yypushback(OtlFlex.min(this)); state.add(KLASS_LOOP); return OtlFlex.checkType(this); }

<IMPORT>                            {WHITE_SPACE}+     { yybegin(VALUE); return TokenType.WHITE_SPACE; }
<CREATE_VARIABLE, UPDATE_VARIABLE>  ":"                { yybegin(VALUE); return OtlTypes.VAR_TOKEN; }
<CREATE_VARIABLE> {
    {WHITE_SPACE}+                  { return TokenType.WHITE_SPACE; }
    {PARAM_S}{PARAM_VALUE}          { yypushback(yylength()-1); return OtlTypes.PARAM_S; }
    {PARAM_VALUE}{PARAM_E}          { yypushback(2); return OtlTypes.VALUE; }
    {PARAM_E}{VARIABLE_IDENTIFIER}  { yypushback(yylength()-1); return OtlTypes.PARAM_E; }
    {VARIABLE_IDENTIFIER}":"        { yypushback(1); return OtlTypes.VARIABLE_IDENTIFIER; }
}

<IS_METHOD, IS_KLASS> {
    {WHITE_SPACE}+({KLASS_IDENTIFIER}|{METHOD_IDENTIFIER})
        { yypushback(OtlFlex.max(this)); return TokenType.WHITE_SPACE; }
    ({KLASS_IDENTIFIER}|{METHOD_IDENTIFIER}){PARAM_S}
        { yypushback(1); return OtlFlex.tokenKM(this); }
    {PARAM_S}({KLASS_IDENTIFIER}|{PARAM_E})
        { yypushback(yylength()-1); return OtlTypes.PARAM_S; }
    {KLASS_IDENTIFIER}{WHITE_SPACE}+
        { yypushback(OtlFlex.min(this)); return OtlTypes.KLASS_IDENTIFIER; }
    {VARIABLE_IDENTIFIER}{PARAM_E}
        { yypushback(1); return OtlTypes.VARIABLE_IDENTIFIER; }
    {PARAM_E}
        { return OtlTypes.PARAM_E; }
    {WHITE_SPACE}*{LOOP_S}
        { yybegin(OtlFlex.loopKM(this)); return OtlTypes.LOOP_S; }
}

({WHITE_SPACE}*{NEW_LINE}+{WHITE_SPACE}*)+    { return OtlTypes.CRLF; }
{REMARK}{ALL_CHARACTER}*                      { return OtlTypes.REMARK; }
[^]                                           { return TokenType.BAD_CHARACTER; }