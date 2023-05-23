// Generated by JFlex 1.9.1 http://jflex.de/  (tweaked for IntelliJ platform)
// source: OTLanguage.flex

package com.otl.sdk.language;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.TokenType;
import java.util.Stack;


class OtlLexer implements FlexLexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int IMPORT = 2;
  public static final int VALUE = 4;
  public static final int LINE = 6;
  public static final int CREATE_VARIABLE = 8;
  public static final int UPDATE_VARIABLE = 10;
  public static final int IS_KLASS = 12;
  public static final int IS_METHOD = 14;
  public static final int KLASS_LOOP = 16;
  public static final int METHOD_LOOP = 18;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = {
     0,  0,  1,  1,  2,  2,  3,  3,  4,  4,  5,  5,  6,  6,  6,  6, 
     7,  7,  8, 8
  };

  /**
   * Top-level table for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_TOP = zzUnpackcmap_top();

  private static final String ZZ_CMAP_TOP_PACKED_0 =
    "\1\0\60\u0100\1\u0200\172\u0100\53\u0300\1\u0400\u1028\u0100";

  private static int [] zzUnpackcmap_top() {
    int [] result = new int[4352];
    int offset = 0;
    offset = zzUnpackcmap_top(ZZ_CMAP_TOP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_top(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Second-level tables for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_BLOCKS = zzUnpackcmap_blocks();

  private static final String ZZ_CMAP_BLOCKS_PACKED_0 =
    "\11\0\1\1\1\2\1\0\1\1\1\2\22\0\1\1"+
    "\2\0\1\3\11\0\1\4\2\0\12\4\1\5\6\0"+
    "\32\6\1\7\1\0\1\10\1\0\1\4\1\0\32\6"+
    "\1\11\1\0\1\12\u01b3\0\20\6\1\13\3\6\1\14"+
    "\1\15\1\16\3\6\1\17\1\6\1\20\26\6\234\0"+
    "\u019e\6\142\0";

  private static int [] zzUnpackcmap_blocks() {
    int [] result = new int[1280];
    int offset = 0;
    offset = zzUnpackcmap_blocks(ZZ_CMAP_BLOCKS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_blocks(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /**
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\2\0\1\1\13\0\2\2\1\3\1\4\5\2\1\5"+
    "\1\1\1\2\1\6\1\3\1\4\1\7\3\2\1\7"+
    "\3\2\1\10\1\11\1\12\11\0\1\13\3\0\1\14"+
    "\1\6\1\14\1\0\1\15\1\16\1\17\1\0\1\20"+
    "\1\21\1\0\1\22\1\16\5\0\1\23\1\24\1\25"+
    "\1\26";

  private static int [] zzUnpackAction() {
    int [] result = new int[75];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\21\0\42\0\63\0\104\0\125\0\146\0\167"+
    "\0\210\0\231\0\252\0\273\0\314\0\335\0\356\0\377"+
    "\0\u0110\0\u0121\0\u0132\0\u0143\0\u0154\0\u0165\0\u0176\0\u0187"+
    "\0\u0198\0\u01a9\0\u01ba\0\u01cb\0\u01dc\0\u01a9\0\u01ed\0\u01fe"+
    "\0\u020f\0\356\0\u0220\0\u0231\0\u0242\0\356\0\356\0\356"+
    "\0\u0253\0\u0264\0\273\0\314\0\335\0\377\0\u0275\0\u0286"+
    "\0\u0143\0\356\0\u0297\0\u02a8\0\u02b9\0\356\0\u02ca\0\u0121"+
    "\0\u02db\0\356\0\356\0\u02ec\0\u0220\0\u02fd\0\u030e\0\u0231"+
    "\0\356\0\u031f\0\u0330\0\u0341\0\u0352\0\u0363\0\u0374\0\356"+
    "\0\u0385\0\u0396\0\u03a7";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[75];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length() - 1;
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /**
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpacktrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\17\1\20\1\21\1\22\1\17\1\23\1\24\4\17"+
    "\1\25\2\24\1\26\1\27\1\24\1\17\1\30\1\21"+
    "\1\22\15\17\1\31\1\3\1\21\16\31\1\17\1\20"+
    "\1\21\1\22\15\17\1\32\1\33\1\34\1\35\1\32"+
    "\1\36\1\37\1\40\1\41\2\32\6\37\1\17\1\20"+
    "\1\21\1\22\1\17\1\42\14\17\1\43\1\21\1\22"+
    "\2\17\1\44\1\45\1\46\1\47\1\17\6\44\1\17"+
    "\1\20\1\21\1\22\1\17\1\23\1\24\3\17\1\50"+
    "\1\25\2\24\1\26\2\24\1\17\1\20\1\21\1\22"+
    "\1\17\1\23\1\24\3\17\1\50\3\24\1\26\2\24"+
    "\6\0\1\51\4\0\6\51\5\0\1\52\14\0\1\53"+
    "\23\0\1\15\1\0\1\54\4\0\6\54\1\0\1\55"+
    "\41\0\1\56\1\21\17\0\2\21\16\0\2\22\1\0"+
    "\16\22\6\0\1\57\4\0\6\57\1\0\1\60\2\0"+
    "\1\61\1\62\1\61\4\0\6\61\1\0\1\60\2\0"+
    "\1\61\1\62\1\61\4\0\1\61\2\63\3\61\1\0"+
    "\1\60\2\0\1\61\1\62\1\61\4\0\5\61\1\64"+
    "\1\0\1\60\2\0\1\61\1\62\1\61\4\0\1\61"+
    "\1\65\4\61\1\0\1\30\1\21\16\0\2\31\1\0"+
    "\16\31\10\0\1\66\11\0\1\67\1\21\5\0\1\66"+
    "\11\0\2\21\5\0\1\66\10\0\2\22\1\0\5\22"+
    "\1\70\10\22\4\0\1\71\1\72\1\71\1\0\1\66"+
    "\2\0\6\71\10\73\1\66\10\73\6\0\1\74\4\0"+
    "\6\74\1\0\1\75\1\21\3\0\1\76\2\0\1\47"+
    "\1\0\6\76\1\0\1\77\2\0\1\100\1\0\1\100"+
    "\1\101\1\72\2\0\6\100\6\0\1\102\1\0\1\73"+
    "\2\0\6\102\4\0\1\51\1\0\1\51\4\0\6\51"+
    "\4\0\1\52\1\0\1\103\4\0\6\103\4\0\1\57"+
    "\1\62\1\57\4\0\6\57\1\0\1\60\4\0\1\104"+
    "\4\0\6\104\1\0\1\60\2\0\1\61\1\62\1\61"+
    "\4\0\1\105\5\61\1\0\1\60\2\0\1\61\1\62"+
    "\1\61\4\0\3\61\1\106\2\61\1\0\1\60\2\0"+
    "\1\61\1\62\1\61\4\0\4\61\1\107\1\61\1\0"+
    "\1\67\1\21\22\0\1\71\1\72\1\71\4\0\6\71"+
    "\4\0\1\74\1\0\1\74\4\0\6\74\4\0\1\76"+
    "\1\0\1\76\4\0\6\76\1\0\1\77\23\0\1\102"+
    "\1\0\1\102\4\0\6\102\1\0\1\55\2\0\1\52"+
    "\1\0\1\103\4\0\6\103\4\0\1\104\1\110\1\104"+
    "\4\0\6\104\1\0\1\111\2\0\1\61\1\62\1\61"+
    "\4\0\6\61\1\0\1\112\2\0\1\61\1\62\1\61"+
    "\4\0\6\61\1\0\1\113\2\0\1\61\1\62\1\61"+
    "\4\0\6\61\1\0\1\111\4\0\1\104\4\0\6\104"+
    "\1\0\1\112\4\0\1\104\4\0\6\104\1\0\1\113"+
    "\4\0\1\104\4\0\6\104";

  private static int [] zzUnpacktrans() {
    int [] result = new int[952];
    int offset = 0;
    offset = zzUnpacktrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpacktrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String[] ZZ_ERROR_MSG = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state {@code aState}
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\2\0\1\1\13\0\1\11\22\1\1\11\3\1\3\11"+
    "\1\1\1\0\3\1\4\0\1\11\3\0\1\11\2\1"+
    "\1\0\2\11\1\1\1\0\2\1\1\0\1\11\1\1"+
    "\5\0\1\11\3\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[75];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** For the backwards DFA of general lookahead statements */
  private boolean [] zzFin = new boolean [Math.min(ZZ_BUFFERSIZE, zzMaxBufferLen())+1];

  /** Number of newlines encountered up to the start of the matched text. */
  private int yyline;

  /** Number of characters from the last newline up to the start of the matched text. */
  @SuppressWarnings("unused")
  protected int yycolumn;

  /** Number of characters up to the start of the matched text. */
  @SuppressWarnings("unused")
  private long yychar;

  /** Whether the scanner is currently at the beginning of a line. */
  @SuppressWarnings("unused")
  private boolean zzAtBOL = true;

  /** Whether the user-EOF-code has already been executed. */
  private boolean zzEOFDone;

  /* user code: */
    Stack<Integer> state = new Stack<>();
    public int pop() {
//        return state.isEmpty() ? YYINITIAL : state.lastElement();
        return state.isEmpty() ? YYINITIAL : state.lastElement();
    }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  OtlLexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** Returns the maximum size of the scanner buffer, which limits the size of tokens. */
  private int zzMaxBufferLen() {
    return Integer.MAX_VALUE;
  }

  /**  Whether the scanner buffer can grow to accommodate a larger token. */
  private boolean zzCanGrow() {
    return true;
  }

  /**
   * Translates raw input code points to DFA table row
   */
  private static int zzCMap(int input) {
    int offset = input & 255;
    return offset == input ? ZZ_CMAP_BLOCKS[offset] : ZZ_CMAP_BLOCKS[ZZ_CMAP_TOP[input >> 8] | offset];
  }

  public final int getTokenStart() {
    return zzStartRead;
  }

  public final int getTokenEnd() {
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end, int initialState) {
    zzBuffer = buffer;
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      {@code false}, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position {@code pos} from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() {
    if (!zzEOFDone) {
      zzEOFDone = true;
    
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException
  {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':
          yyline++;
          zzR = false;
          break;
        case '\r':
          yyline++;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
          }
          break;
        default:
          zzR = false;
        }
      }

      if (zzR) {
        // peek one character ahead if it is
        // (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL.charAt(zzMarkedPosL) == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof)
            zzPeek = false;
          else
            zzPeek = zzBufferL.charAt(zzMarkedPosL) == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMap(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
        return null;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1:
            { yybegin(pop()); return OtlTypes.VALUE;
            }
          // fall through
          case 23: break;
          case 2:
            { return TokenType.BAD_CHARACTER;
            }
          // fall through
          case 24: break;
          case 3:
            { return OtlTypes.CRLF;
            }
          // fall through
          case 25: break;
          case 4:
            { return OtlTypes.REMARK;
            }
          // fall through
          case 26: break;
          case 5:
            { yybegin(VALUE); return TokenType.WHITE_SPACE;
            }
          // fall through
          case 27: break;
          case 6:
            { return TokenType.WHITE_SPACE;
            }
          // fall through
          case 28: break;
          case 7:
            { yybegin(VALUE); return OtlTypes.VAR_TOKEN;
            }
          // fall through
          case 29: break;
          case 8:
            { return OtlTypes.PARAM_E;
            }
          // fall through
          case 30: break;
          case 9:
            { yybegin(OtlFlex.loopKM(this)); return OtlTypes.LOOP_S;
            }
          // fall through
          case 31: break;
          case 10:
            { state.pop(); yybegin(pop()); return OtlTypes.LOOP_E;
            }
          // fall through
          case 32: break;
          case 11:
            // lookahead expression with fixed lookahead length
            zzMarkedPos = Character.offsetByCodePoints
                (zzBufferL, zzMarkedPos, -1);
            { yybegin(OtlLexer.UPDATE_VARIABLE); return OtlTypes.VARIABLE_IDENTIFIER;
            }
          // fall through
          case 33: break;
          case 12:
            // lookahead expression with fixed base length
            zzMarkedPos = Character.offsetByCodePoints
                (zzBufferL, zzStartRead, 1);
            { return OtlTypes.VALUE;
            }
          // fall through
          case 34: break;
          case 13:
            // lookahead expression with fixed lookahead length
            zzMarkedPos = Character.offsetByCodePoints
                (zzBufferL, zzMarkedPos, -1);
            { return OtlTypes.VARIABLE_IDENTIFIER;
            }
          // fall through
          case 35: break;
          case 14:
            // lookahead expression with fixed base length
            zzMarkedPos = Character.offsetByCodePoints
                (zzBufferL, zzStartRead, 1);
            { return OtlTypes.PARAM_S;
            }
          // fall through
          case 36: break;
          case 15:
            // lookahead expression with fixed base length
            zzMarkedPos = Character.offsetByCodePoints
                (zzBufferL, zzStartRead, 1);
            { return OtlTypes.PARAM_E;
            }
          // fall through
          case 37: break;
          case 16:
            // general lookahead, find correct zzMarkedPos
            { int zzFState = 11;
              int zzFPos = zzStartRead;
              if (zzFin.length <= zzBufferL.length()) {
                zzFin = new boolean[zzBufferL.length()+1];
              }
              boolean zzFinL[] = zzFin;
              while (zzFState != -1 && zzFPos < zzMarkedPos) {
                zzFinL[zzFPos] = ((zzAttrL[zzFState] & 1) == 1);
                zzInput = Character.codePointAt(zzBufferL, zzFPos);
                zzFPos += Character.charCount(zzInput);
                zzFState = zzTransL[ zzRowMapL[zzFState] + zzCMap(zzInput) ];
              }
              if (zzFState != -1) {
                zzFinL[zzFPos++] = ((zzAttrL[zzFState] & 1) == 1);
              }
              while (zzFPos <= zzMarkedPos) {
                zzFinL[zzFPos++] = false;
              }

              zzFState = 12;
              zzFPos = zzMarkedPos;
              while (!zzFinL[zzFPos] || (zzAttrL[zzFState] & 1) != 1) {
                zzInput = Character.codePointBefore(zzBufferL, zzFPos);
                zzFPos -= Character.charCount(zzInput);
                zzFState = zzTransL[ zzRowMapL[zzFState] + zzCMap(zzInput) ];
              };
              zzMarkedPos = zzFPos;
            }
            { return TokenType.WHITE_SPACE;
            }
          // fall through
          case 38: break;
          case 17:
            // general lookahead, find correct zzMarkedPos
            { int zzFState = 9;
              int zzFPos = zzStartRead;
              if (zzFin.length <= zzBufferL.length()) {
                zzFin = new boolean[zzBufferL.length()+1];
              }
              boolean zzFinL[] = zzFin;
              while (zzFState != -1 && zzFPos < zzMarkedPos) {
                zzFinL[zzFPos] = ((zzAttrL[zzFState] & 1) == 1);
                zzInput = Character.codePointAt(zzBufferL, zzFPos);
                zzFPos += Character.charCount(zzInput);
                zzFState = zzTransL[ zzRowMapL[zzFState] + zzCMap(zzInput) ];
              }
              if (zzFState != -1) {
                zzFinL[zzFPos++] = ((zzAttrL[zzFState] & 1) == 1);
              }
              while (zzFPos <= zzMarkedPos) {
                zzFinL[zzFPos++] = false;
              }

              zzFState = 13;
              zzFPos = zzMarkedPos;
              while (!zzFinL[zzFPos] || (zzAttrL[zzFState] & 1) != 1) {
                zzInput = Character.codePointBefore(zzBufferL, zzFPos);
                zzFPos -= Character.charCount(zzInput);
                zzFState = zzTransL[ zzRowMapL[zzFState] + zzCMap(zzInput) ];
              };
              zzMarkedPos = zzFPos;
            }
            { return OtlTypes.KLASS_IDENTIFIER;
            }
          // fall through
          case 39: break;
          case 18:
            // lookahead expression with fixed lookahead length
            zzMarkedPos = Character.offsetByCodePoints
                (zzBufferL, zzMarkedPos, -1);
            { return OtlFlex.tokenKM(this);
            }
          // fall through
          case 40: break;
          case 19:
            // general lookahead, find correct zzMarkedPos
            { int zzFState = 9;
              int zzFPos = zzStartRead;
              if (zzFin.length <= zzBufferL.length()) {
                zzFin = new boolean[zzBufferL.length()+1];
              }
              boolean zzFinL[] = zzFin;
              while (zzFState != -1 && zzFPos < zzMarkedPos) {
                zzFinL[zzFPos] = ((zzAttrL[zzFState] & 1) == 1);
                zzInput = Character.codePointAt(zzBufferL, zzFPos);
                zzFPos += Character.charCount(zzInput);
                zzFState = zzTransL[ zzRowMapL[zzFState] + zzCMap(zzInput) ];
              }
              if (zzFState != -1) {
                zzFinL[zzFPos++] = ((zzAttrL[zzFState] & 1) == 1);
              }
              while (zzFPos <= zzMarkedPos) {
                zzFinL[zzFPos++] = false;
              }

              zzFState = 10;
              zzFPos = zzMarkedPos;
              while (!zzFinL[zzFPos] || (zzAttrL[zzFState] & 1) != 1) {
                zzInput = Character.codePointBefore(zzBufferL, zzFPos);
                zzFPos -= Character.charCount(zzInput);
                zzFState = zzTransL[ zzRowMapL[zzFState] + zzCMap(zzInput) ];
              };
              zzMarkedPos = zzFPos;
            }
            { yybegin(CREATE_VARIABLE); return OtlTypes.KLASS_IDENTIFIER;
            }
          // fall through
          case 41: break;
          case 20:
            // lookahead expression with fixed base length
            zzMarkedPos = Character.offsetByCodePoints
                (zzBufferL, zzStartRead, 3);
            { state.add(METHOD_LOOP); return OtlFlex.checkType(this);
            }
          // fall through
          case 42: break;
          case 21:
            // lookahead expression with fixed base length
            zzMarkedPos = Character.offsetByCodePoints
                (zzBufferL, zzStartRead, 3);
            { return OtlFlex.checkType(this);
            }
          // fall through
          case 43: break;
          case 22:
            // lookahead expression with fixed base length
            zzMarkedPos = Character.offsetByCodePoints
                (zzBufferL, zzStartRead, 3);
            { state.add(KLASS_LOOP); return OtlFlex.checkType(this);
            }
          // fall through
          case 44: break;
          default:
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
