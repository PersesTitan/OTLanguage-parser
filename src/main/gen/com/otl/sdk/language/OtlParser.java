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
  // 'ㅇㅇ'|'ㄴㄴ'
  static boolean BOOL_VALUE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BOOL_VALUE")) return false;
    if (!nextTokenIs(b, "", FALSE, TRUE)) return false;
    boolean r;
    r = consumeToken(b, TRUE);
    if (!r) r = consumeToken(b, FALSE);
    return r;
  }

  /* ********************************************************** */
  // KLASS_KEY ('[' VALUE_KEY ']')? VARIABLE_KEY ':' VALUE_KEY
  public static boolean CREATE_VARIABLE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CREATE_VARIABLE")) return false;
    if (!nextTokenIs(b, KLASS_IDENTIFIER)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CREATE_VARIABLE, null);
    r = KLASS_KEY(b, l + 1);
    r = r && CREATE_VARIABLE_1(b, l + 1);
    r = r && VARIABLE_KEY(b, l + 1);
    r = r && consumeToken(b, VAR_TOKEN);
    p = r; // pin = 4
    r = r && VALUE_KEY(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ('[' VALUE_KEY ']')?
  private static boolean CREATE_VARIABLE_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CREATE_VARIABLE_1")) return false;
    CREATE_VARIABLE_1_0(b, l + 1);
    return true;
  }

  // '[' VALUE_KEY ']'
  private static boolean CREATE_VARIABLE_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CREATE_VARIABLE_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PARAM_S);
    r = r && VALUE_KEY(b, l + 1);
    r = r && consumeToken(b, PARAM_E);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ㅋㅅㅋ KLASS_KEY DEFINE_PARAMS '{' (LINES|DEFINE_METHOD CRLF)* '}'
  public static boolean DEFINE_KLASS(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DEFINE_KLASS")) return false;
    if (!nextTokenIs(b, ㅋㅅㅋ)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, DEFINE_KLASS, null);
    r = consumeToken(b, ㅋㅅㅋ);
    p = r; // pin = 1
    r = r && report_error_(b, KLASS_KEY(b, l + 1));
    r = p && report_error_(b, DEFINE_PARAMS(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, LOOP_S)) && r;
    r = p && report_error_(b, DEFINE_KLASS_4(b, l + 1)) && r;
    r = p && consumeToken(b, LOOP_E) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (LINES|DEFINE_METHOD CRLF)*
  private static boolean DEFINE_KLASS_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DEFINE_KLASS_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!DEFINE_KLASS_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "DEFINE_KLASS_4", c)) break;
    }
    return true;
  }

  // LINES|DEFINE_METHOD CRLF
  private static boolean DEFINE_KLASS_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DEFINE_KLASS_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = LINES(b, l + 1);
    if (!r) r = DEFINE_KLASS_4_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // DEFINE_METHOD CRLF
  private static boolean DEFINE_KLASS_4_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DEFINE_KLASS_4_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = DEFINE_METHOD(b, l + 1);
    r = r && consumeToken(b, CRLF);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (ㅁㅅㅁ|ㅁㅆㅁ) METHOD_KEY DEFINE_PARAMS '{' LINES* '}' ('=>' KLASS_KEY ':' VALUE_KEY )
  public static boolean DEFINE_METHOD(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DEFINE_METHOD")) return false;
    if (!nextTokenIs(b, "<define method>", ㅁㅅㅁ, ㅁㅆㅁ)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, DEFINE_METHOD, "<define method>");
    r = DEFINE_METHOD_0(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, METHOD_KEY(b, l + 1));
    r = p && report_error_(b, DEFINE_PARAMS(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, LOOP_S)) && r;
    r = p && report_error_(b, DEFINE_METHOD_4(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, LOOP_E)) && r;
    r = p && DEFINE_METHOD_6(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ㅁㅅㅁ|ㅁㅆㅁ
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

  // '=>' KLASS_KEY ':' VALUE_KEY
  private static boolean DEFINE_METHOD_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DEFINE_METHOD_6")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, REPLACE_TOKEN);
    r = r && KLASS_KEY(b, l + 1);
    r = r && consumeToken(b, VAR_TOKEN);
    r = r && VALUE_KEY(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '[]' | ('[' KLASS_KEY VARIABLE_KEY ']')+
  public static boolean DEFINE_PARAMS(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DEFINE_PARAMS")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DEFINE_PARAMS, "<define params>");
    r = consumeToken(b, "[]");
    if (!r) r = DEFINE_PARAMS_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ('[' KLASS_KEY VARIABLE_KEY ']')+
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

  // '[' KLASS_KEY VARIABLE_KEY ']'
  private static boolean DEFINE_PARAMS_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DEFINE_PARAMS_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PARAM_S);
    r = r && KLASS_KEY(b, l + 1);
    r = r && VARIABLE_KEY(b, l + 1);
    r = r && consumeToken(b, PARAM_E);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "regexp:[-+]?(\d+\.\d{1,16})"
  static boolean DOUBLE_VALUE(PsiBuilder b, int l) {
    return consumeToken(b, DOUBLE);
  }

  /* ********************************************************** */
  // "regexp:[-+]?(\d+\.\d{1,7})"
  static boolean FLOAT_VALUE(PsiBuilder b, int l) {
    return consumeToken(b, FLOAT);
  }

  /* ********************************************************** */
  // ㅇㅍㅇ VALUE_KEY
  public static boolean IMPORT(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IMPORT")) return false;
    if (!nextTokenIs(b, ㅇㅍㅇ)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, IMPORT, null);
    r = consumeToken(b, ㅇㅍㅇ);
    p = r; // pin = 1
    r = r && VALUE_KEY(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // "regexp:[-+]?\d{1,10}"
  static boolean INT_VALUE(PsiBuilder b, int l) {
    return consumeToken(b, INT);
  }

  /* ********************************************************** */
  // KLASS_IDENTIFIER
  public static boolean KLASS_KEY(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KLASS_KEY")) return false;
    if (!nextTokenIs(b, KLASS_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KLASS_IDENTIFIER);
    exit_section_(b, m, KLASS_KEY, r);
    return r;
  }

  /* ********************************************************** */
  // REMARK_TOKEN|IMPORT|UPDATE_VARIABLE|CREATE_VARIABLE|USE|CRLF
  static boolean LINES(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LINES")) return false;
    boolean r;
    r = REMARK_TOKEN(b, l + 1);
    if (!r) r = IMPORT(b, l + 1);
    if (!r) r = UPDATE_VARIABLE(b, l + 1);
    if (!r) r = CREATE_VARIABLE(b, l + 1);
    if (!r) r = USE(b, l + 1);
    if (!r) r = consumeToken(b, CRLF);
    return r;
  }

  /* ********************************************************** */
  // LINES|DEFINE_KLASS|DEFINE_METHOD
  static boolean LINES_ITEM(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LINES_ITEM")) return false;
    boolean r;
    r = LINES(b, l + 1);
    if (!r) r = DEFINE_KLASS(b, l + 1);
    if (!r) r = DEFINE_METHOD(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // "regexp:[-+]?\d{1,19}"
  static boolean LONG_VALUE(PsiBuilder b, int l) {
    return consumeToken(b, LONG);
  }

  /* ********************************************************** */
  // METHOD_IDENTIFIER
  public static boolean METHOD_KEY(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "METHOD_KEY")) return false;
    if (!nextTokenIs(b, METHOD_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, METHOD_IDENTIFIER);
    exit_section_(b, m, METHOD_KEY, r);
    return r;
  }

  /* ********************************************************** */
  // LINES_ITEM*
  static boolean OtlFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "OtlFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!LINES_ITEM(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "OtlFile", c)) break;
    }
    return true;
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
  // USE_VARIABLE ':' VALUE_KEY
  public static boolean UPDATE_VARIABLE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "UPDATE_VARIABLE")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, UPDATE_VARIABLE, "<update variable>");
    r = USE_VARIABLE(b, l + 1);
    r = r && consumeToken(b, VAR_TOKEN);
    p = r; // pin = 2
    r = r && VALUE_KEY(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // USE_START ('~' USE_METHOD)*
  public static boolean USE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "USE")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, USE, "<use>");
    r = USE_START(b, l + 1);
    r = r && USE_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ('~' USE_METHOD)*
  private static boolean USE_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "USE_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!USE_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "USE_1", c)) break;
    }
    return true;
  }

  // '~' USE_METHOD
  private static boolean USE_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "USE_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ACCESS);
    r = r && USE_METHOD(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // METHOD_KEY (VALUE_KEY|USE_PARAMS)
  static boolean USE_METHOD(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "USE_METHOD")) return false;
    if (!nextTokenIs(b, METHOD_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = METHOD_KEY(b, l + 1);
    r = r && USE_METHOD_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // VALUE_KEY|USE_PARAMS
  private static boolean USE_METHOD_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "USE_METHOD_1")) return false;
    boolean r;
    r = VALUE_KEY(b, l + 1);
    if (!r) r = USE_PARAMS(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // ('[' VALUE_KEY ']')*
  static boolean USE_PARAMS(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "USE_PARAMS")) return false;
    while (true) {
      int c = current_position_(b);
      if (!USE_PARAMS_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "USE_PARAMS", c)) break;
    }
    return true;
  }

  // '[' VALUE_KEY ']'
  private static boolean USE_PARAMS_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "USE_PARAMS_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PARAM_S);
    r = r && VALUE_KEY(b, l + 1);
    r = r && consumeToken(b, PARAM_E);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // USE_VARIABLE | USE_METHOD | KLASS_KEY USE_PARAMS | KLASS_KEY '~' USE_METHOD
  static boolean USE_START(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "USE_START")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = USE_VARIABLE(b, l + 1);
    if (!r) r = USE_METHOD(b, l + 1);
    if (!r) r = USE_START_2(b, l + 1);
    if (!r) r = USE_START_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // KLASS_KEY USE_PARAMS
  private static boolean USE_START_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "USE_START_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = KLASS_KEY(b, l + 1);
    r = r && USE_PARAMS(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // KLASS_KEY '~' USE_METHOD
  private static boolean USE_START_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "USE_START_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = KLASS_KEY(b, l + 1);
    r = r && consumeToken(b, ACCESS);
    r = r && USE_METHOD(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ':'? '~'* VARIABLE_KEY
  static boolean USE_VARIABLE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "USE_VARIABLE")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = USE_VARIABLE_0(b, l + 1);
    r = r && USE_VARIABLE_1(b, l + 1);
    r = r && VARIABLE_KEY(b, l + 1);
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
  // VALUE | INT_VALUE | LONG_VALUE | FLOAT_VALUE | DOUBLE_VALUE | BOOL_VALUE | USE
  public static boolean VALUE_KEY(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VALUE_KEY")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VALUE_KEY, "<value key>");
    r = consumeToken(b, VALUE);
    if (!r) r = INT_VALUE(b, l + 1);
    if (!r) r = LONG_VALUE(b, l + 1);
    if (!r) r = FLOAT_VALUE(b, l + 1);
    if (!r) r = DOUBLE_VALUE(b, l + 1);
    if (!r) r = BOOL_VALUE(b, l + 1);
    if (!r) r = USE(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // VARIABLE_IDENTIFIER
  public static boolean VARIABLE_KEY(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VARIABLE_KEY")) return false;
    if (!nextTokenIs(b, VARIABLE_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, VARIABLE_IDENTIFIER);
    exit_section_(b, m, VARIABLE_KEY, r);
    return r;
  }

}
