/* ghtml.java */
/* Generated By:JavaCC: Do not edit this line. ghtml.java */
package gramatica_HTML;
import archivos.memoria;

public class ghtml implements ghtmlConstants {
  public static void main(String args[]) throws ParseException {
    ghtml parser = new ghtml(System.in);
    parser.S();
  }

  final public void S() throws ParseException {
    jj_consume_token(TOKEN_HTML_ABRE);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case TOKEN_HEAD_ABRE:{
      jj_consume_token(TOKEN_HEAD_ABRE);
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case ID:{
        LISTA_ID();
        break;
        }
      default:
        jj_la1[0] = jj_gen;
        ;
      }
      jj_consume_token(TOKEN_HEAD_CIERRA);
      break;
      }
    default:
      jj_la1[1] = jj_gen;
      ;
    }
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case TOKEN_BODY_ABRE:{
      jj_consume_token(TOKEN_BODY_ABRE);
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case TOKEN_HEADER_ABRE:
      case TOKEN_TABLE_ABRE:
      case TOKEN_DIV_ABRE:
      case TOKEN_USQL_ABRE:{
        LISTA_CUERPO();
        break;
        }
      default:
        jj_la1[2] = jj_gen;
        ;
      }
      jj_consume_token(TOKEN_BODY_CIERRA);
      break;
      }
    default:
      jj_la1[3] = jj_gen;
      ;
    }
    jj_consume_token(TOKEN_HTML_CIERRA);
  }

  final public void LISTA_CUERPO() throws ParseException {
    CUERPO();
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case TOKEN_HEADER_ABRE:
    case TOKEN_TABLE_ABRE:
    case TOKEN_DIV_ABRE:
    case TOKEN_USQL_ABRE:{
      LISTA_CUERPO();
      break;
      }
    default:
      jj_la1[4] = jj_gen;
      ;
    }
  }

  final public void CUERPO() throws ParseException {String codigo;
Token cod;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case TOKEN_TABLE_ABRE:{
      TABLE();
      break;
      }
    case TOKEN_HEADER_ABRE:{
      jj_consume_token(TOKEN_HEADER_ABRE);
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case ID:{
        LISTA_ID();
        break;
        }
      default:
        jj_la1[5] = jj_gen;
        ;
      }
      jj_consume_token(TOKEN_HEADER_CIERRA);
      break;
      }
    case TOKEN_DIV_ABRE:{
      jj_consume_token(TOKEN_DIV_ABRE);
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case ID:{
        LISTA_ID();
        break;
        }
      default:
        jj_la1[6] = jj_gen;
        ;
      }
      jj_consume_token(TOKEN_DIV_CIERRA);
      break;
      }
    case TOKEN_USQL_ABRE:{
      jj_consume_token(TOKEN_USQL_ABRE);
      cod = jj_consume_token(CODIGO);
      jj_consume_token(TOKEN_USQL_CIERRA);
codigo = cod.image;
                                                          codigo = codigo.substring(1, codigo.length()-1);
                                                          memoria.codigoHTML += codigo + " ";
      break;
      }
    default:
      jj_la1[7] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void TABLE() throws ParseException {
    jj_consume_token(TOKEN_TABLE_ABRE);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case TOKEN_TH_ABRE:
    case TOKEN_TR_ABRE:
    case TOKEN_TD_ABRE:{
      CUERPO_TABLA();
      break;
      }
    default:
      jj_la1[8] = jj_gen;
      ;
    }
    jj_consume_token(TOKEN_TABLE_CIERRA);
  }

  final public void CUERPO_TABLA() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case TOKEN_TH_ABRE:{
      jj_consume_token(TOKEN_TH_ABRE);
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case ID:{
        LISTA_ID();
        break;
        }
      default:
        jj_la1[9] = jj_gen;
        ;
      }
      jj_consume_token(TOKEN_TH_ABRE);
      break;
      }
    case TOKEN_TR_ABRE:{
      jj_consume_token(TOKEN_TR_ABRE);
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case ID:{
        LISTA_ID();
        break;
        }
      default:
        jj_la1[10] = jj_gen;
        ;
      }
      jj_consume_token(TOKEN_TR_ABRE);
      break;
      }
    case TOKEN_TD_ABRE:{
      jj_consume_token(TOKEN_TD_ABRE);
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case ID:{
        LISTA_ID();
        break;
        }
      default:
        jj_la1[11] = jj_gen;
        ;
      }
      jj_consume_token(TOKEN_TD_ABRE);
      break;
      }
    default:
      jj_la1[12] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void LISTA_ID() throws ParseException {
    jj_consume_token(ID);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case ID:{
      LISTA_ID();
      break;
      }
    default:
      jj_la1[13] = jj_gen;
      ;
    }
  }

  /** Generated Token Manager. */
  public ghtmlTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[14];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x200000,0x8,0x280a0,0x80000,0x280a0,0x200000,0x200000,0x280a0,0x2a00,0x200000,0x200000,0x200000,0x2a00,0x200000,};
   }

  /** Constructor with InputStream. */
  public ghtml(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public ghtml(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new ghtmlTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 14; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 14; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public ghtml(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new ghtmlTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 14; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 14; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public ghtml(ghtmlTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 14; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(ghtmlTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 14; i++) jj_la1[i] = -1;
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk_f() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[28];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 14; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 28; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

}
