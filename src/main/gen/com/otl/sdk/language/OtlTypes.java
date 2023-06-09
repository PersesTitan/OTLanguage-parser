// This is a generated file. Not intended for manual editing.
package com.otl.sdk.language;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.otl.sdk.language.psi.OtlElementType;
import com.otl.sdk.language.psi.OtlTokenType;
import com.otl.sdk.language.impl.*;

public interface OtlTypes {

  IElementType CREATE_VARIABLE = new OtlElementType("CREATE_VARIABLE");
  IElementType DEFINE_KLASS = new OtlElementType("DEFINE_KLASS");
  IElementType DEFINE_METHOD = new OtlElementType("DEFINE_METHOD");
  IElementType DEFINE_PARAMS = new OtlElementType("DEFINE_PARAMS");
  IElementType IMPORT = new OtlElementType("IMPORT");
  IElementType KLASS_KEY = new OtlElementType("KLASS_KEY");
  IElementType METHOD_KEY = new OtlElementType("METHOD_KEY");
  IElementType REMARK_TOKEN = new OtlElementType("REMARK_TOKEN");
  IElementType UPDATE_VARIABLE = new OtlElementType("UPDATE_VARIABLE");
  IElementType USE = new OtlElementType("USE");
  IElementType VALUE_KEY = new OtlElementType("VALUE_KEY");
  IElementType VARIABLE_KEY = new OtlElementType("VARIABLE_KEY");

  IElementType ACCESS = new OtlTokenType("~");
  IElementType ADD = new OtlTokenType("ㅇ+ㅇ");
  IElementType BOOL = new OtlTokenType("BOOL");
  IElementType CHAR = new OtlTokenType("CHAR");
  IElementType CRLF = new OtlTokenType("CRLF");
  IElementType DIV = new OtlTokenType("ㅇ/ㅇ");
  IElementType DOUBLE = new OtlTokenType("DOUBLE");
  IElementType EQ = new OtlTokenType("ㅇ=ㅇ");
  IElementType FALSE = new OtlTokenType("ㄴㄴ");
  IElementType FLOAT = new OtlTokenType("FLOAT");
  IElementType GE = new OtlTokenType("ㅇ>=ㅇ");
  IElementType GT = new OtlTokenType("ㅇ>ㅇ");
  IElementType IF = new OtlTokenType("?ㅅ?");
  IElementType INT = new OtlTokenType("INT");
  IElementType KLASS_IDENTIFIER = new OtlTokenType("KLASS_IDENTIFIER");
  IElementType LE = new OtlTokenType("ㅇ<=ㅇ");
  IElementType LONG = new OtlTokenType("LONG");
  IElementType LOOP_E = new OtlTokenType("}");
  IElementType LOOP_S = new OtlTokenType("{");
  IElementType LT = new OtlTokenType("ㅇ<ㅇ");
  IElementType METHOD_IDENTIFIER = new OtlTokenType("METHOD_IDENTIFIER");
  IElementType MUL = new OtlTokenType("ㅇ*ㅇ");
  IElementType NOT = new OtlTokenType("ㅇㄴ");
  IElementType NQ = new OtlTokenType("ㅇ!ㅇ");
  IElementType PARAM_E = new OtlTokenType("]");
  IElementType PARAM_S = new OtlTokenType("[");
  IElementType PUT_TOKEN = new OtlTokenType("<=");
  IElementType REM = new OtlTokenType("ㅇ%ㅇ");
  IElementType REMARK = new OtlTokenType("#");
  IElementType REPLACE_TOKEN = new OtlTokenType("=>");
  IElementType SET_E = new OtlTokenType(")");
  IElementType SET_S = new OtlTokenType("(");
  IElementType STRING = new OtlTokenType("STRING");
  IElementType SUB = new OtlTokenType("ㅇ-ㅇ");
  IElementType TRUE = new OtlTokenType("ㅇㅇ");
  IElementType VALUE = new OtlTokenType("VALUE");
  IElementType VARIABLE_IDENTIFIER = new OtlTokenType("VARIABLE_IDENTIFIER");
  IElementType VAR_TOKEN = new OtlTokenType(":");
  IElementType ㅁㅅㅁ = new OtlTokenType("ㅁㅅㅁ");
  IElementType ㅁㅆㅁ = new OtlTokenType("ㅁㅆㅁ");
  IElementType ㅇㅍㅇ = new OtlTokenType("ㅇㅍㅇ");
  IElementType ㅋㅅㅋ = new OtlTokenType("ㅋㅅㅋ");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == CREATE_VARIABLE) {
        return new OtlCreateVariableImpl(node);
      }
      else if (type == DEFINE_KLASS) {
        return new OtlDefineKlassImpl(node);
      }
      else if (type == DEFINE_METHOD) {
        return new OtlDefineMethodImpl(node);
      }
      else if (type == DEFINE_PARAMS) {
        return new OtlDefineParamsImpl(node);
      }
      else if (type == IMPORT) {
        return new OtlImportImpl(node);
      }
      else if (type == KLASS_KEY) {
        return new OtlKlassKeyImpl(node);
      }
      else if (type == METHOD_KEY) {
        return new OtlMethodKeyImpl(node);
      }
      else if (type == REMARK_TOKEN) {
        return new OtlRemarkTokenImpl(node);
      }
      else if (type == UPDATE_VARIABLE) {
        return new OtlUpdateVariableImpl(node);
      }
      else if (type == USE) {
        return new OtlUseImpl(node);
      }
      else if (type == VALUE_KEY) {
        return new OtlValueKeyImpl(node);
      }
      else if (type == VARIABLE_KEY) {
        return new OtlVariableKeyImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
