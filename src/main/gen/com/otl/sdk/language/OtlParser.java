// This is a generated file. Not intended for manual editing.
package com.otl.sdk.language;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.otl.sdk.language.OtlTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class OtlParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return OtlFile(b, l + 1);
  }

  /* ********************************************************** */
  // BOOL_VALUE ( ('ㄸ' | 'ㄲ') BOOL_VALUE)*
  static boolean BOOL(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BOOL")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = BOOL_VALUE(b, l + 1);
    r = r && BOOL_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( ('ㄸ' | 'ㄲ') BOOL_VALUE)*
  private static boolean BOOL_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BOOL_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!BOOL_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "BOOL_1", c)) break;
    }
    return true;
  }

  // ('ㄸ' | 'ㄲ') BOOL_VALUE
  private static boolean BOOL_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BOOL_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = BOOL_1_0_0(b, l + 1);
    r = r && BOOL_VALUE(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'ㄸ' | 'ㄲ'
  private static boolean BOOL_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BOOL_1_0_0")) return false;
    boolean r;
    r = consumeToken(b, "ㄸ");
    if (!r) r = consumeToken(b, "ㄲ");
    return r;
  }

  /* ********************************************************** */
  // "regexp:ㅇㅇ|ㄴㄴ" | USE_VARIABLE | USE_METHOD | (NUMBERS ('ㅇ>ㅇ' | 'ㅇ<ㅇ' | 'ㅇ=ㅇ' | 'ㅇ!ㅇ' | 'ㅇ<=ㅇ' | 'ㅇ>=ㅇ') NUMBERS)
  static boolean BOOL_VALUE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BOOL_VALUE")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BOOL);
    if (!r) r = USE_VARIABLE(b, l + 1);
    if (!r) r = USE_METHOD(b, l + 1);
    if (!r) r = BOOL_VALUE_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // NUMBERS ('ㅇ>ㅇ' | 'ㅇ<ㅇ' | 'ㅇ=ㅇ' | 'ㅇ!ㅇ' | 'ㅇ<=ㅇ' | 'ㅇ>=ㅇ') NUMBERS
  private static boolean BOOL_VALUE_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BOOL_VALUE_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = NUMBERS(b, l + 1);
    r = r && BOOL_VALUE_3_1(b, l + 1);
    r = r && NUMBERS(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'ㅇ>ㅇ' | 'ㅇ<ㅇ' | 'ㅇ=ㅇ' | 'ㅇ!ㅇ' | 'ㅇ<=ㅇ' | 'ㅇ>=ㅇ'
  private static boolean BOOL_VALUE_3_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BOOL_VALUE_3_1")) return false;
    boolean r;
    r = consumeToken(b, GT);
    if (!r) r = consumeToken(b, LT);
    if (!r) r = consumeToken(b, EQ);
    if (!r) r = consumeToken(b, NQ);
    if (!r) r = consumeToken(b, LE);
    if (!r) r = consumeToken(b, GE);
    return r;
  }

  /* ********************************************************** */
  // CHAR_VALUE
  static boolean CHAR(PsiBuilder b, int l) {
    return CHAR_VALUE(b, l + 1);
  }

  /* ********************************************************** */
  // "regexp:'.'" | USE_VARIABLE | USE_METHOD
  static boolean CHAR_VALUE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CHAR_VALUE")) return false;
    boolean r;
    r = consumeToken(b, CHAR);
    if (!r) r = USE_VARIABLE(b, l + 1);
    if (!r) r = USE_METHOD(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // KLASS_NAME ('[' INT ']')? VARIABLE_NAME ':' value
  public static boolean CREATE_VARIABLE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CREATE_VARIABLE")) return false;
    if (!nextTokenIs(b, KLASS_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = KLASS_NAME(b, l + 1);
    r = r && CREATE_VARIABLE_1(b, l + 1);
    r = r && VARIABLE_NAME(b, l + 1);
    r = r && consumeToken(b, VAR_TOKEN);
    r = r && value(b, l + 1);
    exit_section_(b, m, CREATE_VARIABLE, r);
    return r;
  }

  // ('[' INT ']')?
  private static boolean CREATE_VARIABLE_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CREATE_VARIABLE_1")) return false;
    CREATE_VARIABLE_1_0(b, l + 1);
    return true;
  }

  // '[' INT ']'
  private static boolean CREATE_VARIABLE_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CREATE_VARIABLE_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PARAM_S);
    r = r && INT(b, l + 1);
    r = r && consumeToken(b, PARAM_E);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ㅋㅅㅋ KLASS_KEY DEFINE_PARAMS '{' (LINES | DEFINE_METHOD)* '}'
  public static boolean DEFINE_KLASS(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DEFINE_KLASS")) return false;
    if (!nextTokenIs(b, ㅋㅅㅋ)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, DEFINE_KLASS, null);
    r = consumeTokens(b, 1, ㅋㅅㅋ, KLASS_KEY);
    p = r; // pin = 1
    r = r && report_error_(b, DEFINE_PARAMS(b, l + 1));
    r = p && report_error_(b, consumeToken(b, LOOP_S)) && r;
    r = p && report_error_(b, DEFINE_KLASS_4(b, l + 1)) && r;
    r = p && consumeToken(b, LOOP_E) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (LINES | DEFINE_METHOD)*
  private static boolean DEFINE_KLASS_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DEFINE_KLASS_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!DEFINE_KLASS_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "DEFINE_KLASS_4", c)) break;
    }
    return true;
  }

  // LINES | DEFINE_METHOD
  private static boolean DEFINE_KLASS_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DEFINE_KLASS_4_0")) return false;
    boolean r;
    r = LINES(b, l + 1);
    if (!r) r = DEFINE_METHOD(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // ( ㅁㅅㅁ | ㅁㅆㅁ ) METHOD_KEY DEFINE_PARAMS '{' LINES* '}' ('=>' KLASS_NAME ':' value)?
  public static boolean DEFINE_METHOD(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DEFINE_METHOD")) return false;
    if (!nextTokenIs(b, "<define method>", ㅁㅅㅁ, ㅁㅆㅁ)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, DEFINE_METHOD, "<define method>");
    r = DEFINE_METHOD_0(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, consumeToken(b, METHOD_KEY));
    r = p && report_error_(b, DEFINE_PARAMS(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, LOOP_S)) && r;
    r = p && report_error_(b, DEFINE_METHOD_4(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, LOOP_E)) && r;
    r = p && DEFINE_METHOD_6(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ㅁㅅㅁ | ㅁㅆㅁ
  private static boolean DEFINE_METHOD_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DEFINE_METHOD_0")) return false;
    boolean r;
    r = consumeToken(b, ㅁㅅㅁ);
    if (!r) r = consumeToken(b, ㅁㅆㅁ);
    return r;
  }

  // LINES*
  private static boolean DEFINE_METHOD_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DEFINE_METHOD_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!LINES(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "DEFINE_METHOD_4", c)) break;
    }
    return true;
  }

  // ('=>' KLASS_NAME ':' value)?
  private static boolean DEFINE_METHOD_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DEFINE_METHOD_6")) return false;
    DEFINE_METHOD_6_0(b, l + 1);
    return true;
  }

  // '=>' KLASS_NAME ':' value
  private static boolean DEFINE_METHOD_6_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DEFINE_METHOD_6_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, REPLACE_TOKEN);
    r = r && KLASS_NAME(b, l + 1);
    r = r && consumeToken(b, VAR_TOKEN);
    r = r && value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '[]' | ('[' KLASS_NAME VARIABLE_NAME ']')+
  public static boolean DEFINE_PARAMS(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DEFINE_PARAMS")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DEFINE_PARAMS, "<define params>");
    r = consumeToken(b, "[]");
    if (!r) r = DEFINE_PARAMS_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ('[' KLASS_NAME VARIABLE_NAME ']')+
  private static boolean DEFINE_PARAMS_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DEFINE_PARAMS_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = DEFINE_PARAMS_1_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!DEFINE_PARAMS_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "DEFINE_PARAMS_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // '[' KLASS_NAME VARIABLE_NAME ']'
  private static boolean DEFINE_PARAMS_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DEFINE_PARAMS_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PARAM_S);
    r = r && KLASS_NAME(b, l + 1);
    r = r && VARIABLE_NAME(b, l + 1);
    r = r && consumeToken(b, PARAM_E);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // DOUBLE_VALUE (('ㅇ+ㅇ' | 'ㅇ-ㅇ' | 'ㅇ%ㅇ' | 'ㅇ*ㅇ' | 'ㅇ/ㅇ') DOUBLE_VALUE)*
  static boolean DOUBLE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DOUBLE")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = DOUBLE_VALUE(b, l + 1);
    r = r && DOUBLE_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (('ㅇ+ㅇ' | 'ㅇ-ㅇ' | 'ㅇ%ㅇ' | 'ㅇ*ㅇ' | 'ㅇ/ㅇ') DOUBLE_VALUE)*
  private static boolean DOUBLE_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DOUBLE_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!DOUBLE_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "DOUBLE_1", c)) break;
    }
    return true;
  }

  // ('ㅇ+ㅇ' | 'ㅇ-ㅇ' | 'ㅇ%ㅇ' | 'ㅇ*ㅇ' | 'ㅇ/ㅇ') DOUBLE_VALUE
  private static boolean DOUBLE_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DOUBLE_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = DOUBLE_1_0_0(b, l + 1);
    r = r && DOUBLE_VALUE(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'ㅇ+ㅇ' | 'ㅇ-ㅇ' | 'ㅇ%ㅇ' | 'ㅇ*ㅇ' | 'ㅇ/ㅇ'
  private static boolean DOUBLE_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DOUBLE_1_0_0")) return false;
    boolean r;
    r = consumeToken(b, ADD);
    if (!r) r = consumeToken(b, SUB);
    if (!r) r = consumeToken(b, REM);
    if (!r) r = consumeToken(b, MUL);
    if (!r) r = consumeToken(b, DIV);
    return r;
  }

  /* ********************************************************** */
  // "regexp:[-+]?(\d+\.\d{1,16})" | FLOAT_VALUE | USE_VARIABLE | USE_METHOD
  static boolean DOUBLE_VALUE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DOUBLE_VALUE")) return false;
    boolean r;
    r = consumeToken(b, DOUBLE);
    if (!r) r = FLOAT_VALUE(b, l + 1);
    if (!r) r = USE_VARIABLE(b, l + 1);
    if (!r) r = USE_METHOD(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // FLOAT_VALUE (('ㅇ+ㅇ' | 'ㅇ-ㅇ' | 'ㅇ%ㅇ' | 'ㅇ*ㅇ' | 'ㅇ/ㅇ') FLOAT_VALUE)*
  static boolean FLOAT(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FLOAT")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = FLOAT_VALUE(b, l + 1);
    r = r && FLOAT_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (('ㅇ+ㅇ' | 'ㅇ-ㅇ' | 'ㅇ%ㅇ' | 'ㅇ*ㅇ' | 'ㅇ/ㅇ') FLOAT_VALUE)*
  private static boolean FLOAT_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FLOAT_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!FLOAT_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "FLOAT_1", c)) break;
    }
    return true;
  }

  // ('ㅇ+ㅇ' | 'ㅇ-ㅇ' | 'ㅇ%ㅇ' | 'ㅇ*ㅇ' | 'ㅇ/ㅇ') FLOAT_VALUE
  private static boolean FLOAT_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FLOAT_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = FLOAT_1_0_0(b, l + 1);
    r = r && FLOAT_VALUE(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'ㅇ+ㅇ' | 'ㅇ-ㅇ' | 'ㅇ%ㅇ' | 'ㅇ*ㅇ' | 'ㅇ/ㅇ'
  private static boolean FLOAT_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FLOAT_1_0_0")) return false;
    boolean r;
    r = consumeToken(b, ADD);
    if (!r) r = consumeToken(b, SUB);
    if (!r) r = consumeToken(b, REM);
    if (!r) r = consumeToken(b, MUL);
    if (!r) r = consumeToken(b, DIV);
    return r;
  }

  /* ********************************************************** */
  // "regexp:[-+]?(\d+\.\d{1,7})" | LONG_VALUE | USE_VARIABLE | USE_METHOD
  static boolean FLOAT_VALUE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FLOAT_VALUE")) return false;
    boolean r;
    r = consumeToken(b, FLOAT);
    if (!r) r = LONG_VALUE(b, l + 1);
    if (!r) r = USE_VARIABLE(b, l + 1);
    if (!r) r = USE_METHOD(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // ㅇㅍㅇ IMPORT_KEY
  public static boolean IMPORT(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IMPORT")) return false;
    if (!nextTokenIs(b, ㅇㅍㅇ)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, IMPORT, null);
    r = consumeTokens(b, 1, ㅇㅍㅇ, IMPORT_KEY);
    p = r; // pin = 1
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // INT_VALUE (('ㅇ+ㅇ' | 'ㅇ-ㅇ' | 'ㅇ%ㅇ' | 'ㅇ*ㅇ' | 'ㅇ/ㅇ') INT_VALUE)*
  static boolean INT(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "INT")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = INT_VALUE(b, l + 1);
    r = r && INT_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (('ㅇ+ㅇ' | 'ㅇ-ㅇ' | 'ㅇ%ㅇ' | 'ㅇ*ㅇ' | 'ㅇ/ㅇ') INT_VALUE)*
  private static boolean INT_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "INT_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!INT_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "INT_1", c)) break;
    }
    return true;
  }

  // ('ㅇ+ㅇ' | 'ㅇ-ㅇ' | 'ㅇ%ㅇ' | 'ㅇ*ㅇ' | 'ㅇ/ㅇ') INT_VALUE
  private static boolean INT_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "INT_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = INT_1_0_0(b, l + 1);
    r = r && INT_VALUE(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'ㅇ+ㅇ' | 'ㅇ-ㅇ' | 'ㅇ%ㅇ' | 'ㅇ*ㅇ' | 'ㅇ/ㅇ'
  private static boolean INT_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "INT_1_0_0")) return false;
    boolean r;
    r = consumeToken(b, ADD);
    if (!r) r = consumeToken(b, SUB);
    if (!r) r = consumeToken(b, REM);
    if (!r) r = consumeToken(b, MUL);
    if (!r) r = consumeToken(b, DIV);
    return r;
  }

  /* ********************************************************** */
  // "regexp:[-+]?\d{1,10}" | USE_VARIABLE | USE_METHOD
  static boolean INT_VALUE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "INT_VALUE")) return false;
    boolean r;
    r = consumeToken(b, INT);
    if (!r) r = USE_VARIABLE(b, l + 1);
    if (!r) r = USE_METHOD(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // KLASS_IDENTIFIER
  public static boolean KLASS_NAME(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KLASS_NAME")) return false;
    if (!nextTokenIs(b, KLASS_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KLASS_IDENTIFIER);
    exit_section_(b, m, KLASS_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // REMARK_TOKEN | IMPORT | UPDATE_VARIABLE | CREATE_VARIABLE
  static boolean LINES(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LINES")) return false;
    boolean r;
    r = REMARK_TOKEN(b, l + 1);
    if (!r) r = IMPORT(b, l + 1);
    if (!r) r = UPDATE_VARIABLE(b, l + 1);
    if (!r) r = CREATE_VARIABLE(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // LONG_VALUE (('ㅇ+ㅇ' | 'ㅇ-ㅇ' | 'ㅇ%ㅇ' | 'ㅇ*ㅇ' | 'ㅇ/ㅇ') LONG_VALUE)*
  static boolean LONG(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LONG")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = LONG_VALUE(b, l + 1);
    r = r && LONG_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (('ㅇ+ㅇ' | 'ㅇ-ㅇ' | 'ㅇ%ㅇ' | 'ㅇ*ㅇ' | 'ㅇ/ㅇ') LONG_VALUE)*
  private static boolean LONG_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LONG_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!LONG_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "LONG_1", c)) break;
    }
    return true;
  }

  // ('ㅇ+ㅇ' | 'ㅇ-ㅇ' | 'ㅇ%ㅇ' | 'ㅇ*ㅇ' | 'ㅇ/ㅇ') LONG_VALUE
  private static boolean LONG_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LONG_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = LONG_1_0_0(b, l + 1);
    r = r && LONG_VALUE(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'ㅇ+ㅇ' | 'ㅇ-ㅇ' | 'ㅇ%ㅇ' | 'ㅇ*ㅇ' | 'ㅇ/ㅇ'
  private static boolean LONG_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LONG_1_0_0")) return false;
    boolean r;
    r = consumeToken(b, ADD);
    if (!r) r = consumeToken(b, SUB);
    if (!r) r = consumeToken(b, REM);
    if (!r) r = consumeToken(b, MUL);
    if (!r) r = consumeToken(b, DIV);
    return r;
  }

  /* ********************************************************** */
  // "regexp:[-+]?\d{1,19}" | INT_VALUE | USE_VARIABLE | USE_METHOD
  static boolean LONG_VALUE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LONG_VALUE")) return false;
    boolean r;
    r = consumeToken(b, LONG);
    if (!r) r = INT_VALUE(b, l + 1);
    if (!r) r = USE_VARIABLE(b, l + 1);
    if (!r) r = USE_METHOD(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // METHOD_NAME param?
  static boolean METHOD_ITEM(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "METHOD_ITEM")) return false;
    if (!nextTokenIs(b, METHOD_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = METHOD_NAME(b, l + 1);
    r = r && METHOD_ITEM_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // param?
  private static boolean METHOD_ITEM_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "METHOD_ITEM_1")) return false;
    param(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // METHOD_IDENTIFIER
  public static boolean METHOD_NAME(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "METHOD_NAME")) return false;
    if (!nextTokenIs(b, METHOD_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, METHOD_IDENTIFIER);
    exit_section_(b, m, METHOD_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // INT | LONG | FLOAT | DOUBLE
  static boolean NUMBERS(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NUMBERS")) return false;
    boolean r;
    r = INT(b, l + 1);
    if (!r) r = LONG(b, l + 1);
    if (!r) r = FLOAT(b, l + 1);
    if (!r) r = DOUBLE(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // (LINES | DEFINE_METHOD | DEFINE_KLASS)*
  static boolean OtlFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "OtlFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!OtlFile_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "OtlFile", c)) break;
    }
    return true;
  }

  // LINES | DEFINE_METHOD | DEFINE_KLASS
  private static boolean OtlFile_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "OtlFile_0")) return false;
    boolean r;
    r = LINES(b, l + 1);
    if (!r) r = DEFINE_METHOD(b, l + 1);
    if (!r) r = DEFINE_KLASS(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // '#' "regexp:[^\n\r]*"
  public static boolean REMARK_TOKEN(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "REMARK_TOKEN")) return false;
    if (!nextTokenIs(b, REMARK)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, REMARK_TOKEN, null);
    r = consumeToken(b, REMARK);
    p = r; // pin = 1
    r = r && consumeToken(b, "regexp:[^\n\r]*");
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // STRING_VALUE
  static boolean STRING(PsiBuilder b, int l) {
    return STRING_VALUE(b, l + 1);
  }

  /* ********************************************************** */
  // "regexp:\"[^]]*\"" | USE_VARIABLE | USE_METHOD
  static boolean STRING_VALUE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "STRING_VALUE")) return false;
    boolean r;
    r = consumeToken(b, "regexp:\"[^]]*\"");
    if (!r) r = USE_VARIABLE(b, l + 1);
    if (!r) r = USE_METHOD(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // USE_VARIABLE ':' value
  public static boolean UPDATE_VARIABLE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "UPDATE_VARIABLE")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, UPDATE_VARIABLE, "<update variable>");
    r = USE_VARIABLE(b, l + 1);
    r = r && consumeToken(b, VAR_TOKEN);
    r = r && value(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (USE_VARIABLE | METHOD_ITEM | KLASS_NAME) ('~' METHOD_ITEM)*
  static boolean USE_METHOD(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "USE_METHOD")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = USE_METHOD_0(b, l + 1);
    r = r && USE_METHOD_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // USE_VARIABLE | METHOD_ITEM | KLASS_NAME
  private static boolean USE_METHOD_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "USE_METHOD_0")) return false;
    boolean r;
    r = USE_VARIABLE(b, l + 1);
    if (!r) r = METHOD_ITEM(b, l + 1);
    if (!r) r = KLASS_NAME(b, l + 1);
    return r;
  }

  // ('~' METHOD_ITEM)*
  private static boolean USE_METHOD_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "USE_METHOD_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!USE_METHOD_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "USE_METHOD_1", c)) break;
    }
    return true;
  }

  // '~' METHOD_ITEM
  private static boolean USE_METHOD_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "USE_METHOD_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ACCESS);
    r = r && METHOD_ITEM(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ':'? '~'* VARIABLE_NAME
  static boolean USE_VARIABLE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "USE_VARIABLE")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = USE_VARIABLE_0(b, l + 1);
    r = r && USE_VARIABLE_1(b, l + 1);
    r = r && VARIABLE_NAME(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ':'?
  private static boolean USE_VARIABLE_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "USE_VARIABLE_0")) return false;
    consumeToken(b, VAR_TOKEN);
    return true;
  }

  // '~'*
  private static boolean USE_VARIABLE_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "USE_VARIABLE_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, ACCESS)) break;
      if (!empty_element_parsed_guard_(b, "USE_VARIABLE_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // VARIABLE_IDENTIFIER
  public static boolean VARIABLE_NAME(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VARIABLE_NAME")) return false;
    if (!nextTokenIs(b, VARIABLE_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, VARIABLE_IDENTIFIER);
    exit_section_(b, m, VARIABLE_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // ('[' value ']')+ | value
  static boolean param(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "param")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = param_0(b, l + 1);
    if (!r) r = value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ('[' value ']')+
  private static boolean param_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "param_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = param_0_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!param_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "param_0", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // '[' value ']'
  private static boolean param_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "param_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PARAM_S);
    r = r && value(b, l + 1);
    r = r && consumeToken(b, PARAM_E);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // USE_VARIABLE | USE_METHOD | INT | LONG | FLOAT | DOUBLE | BOOL | STRING | CHAR
  static boolean value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value")) return false;
    boolean r;
    r = USE_VARIABLE(b, l + 1);
    if (!r) r = USE_METHOD(b, l + 1);
    if (!r) r = INT(b, l + 1);
    if (!r) r = LONG(b, l + 1);
    if (!r) r = FLOAT(b, l + 1);
    if (!r) r = DOUBLE(b, l + 1);
    if (!r) r = BOOL(b, l + 1);
    if (!r) r = STRING(b, l + 1);
    if (!r) r = CHAR(b, l + 1);
    return r;
  }

}
