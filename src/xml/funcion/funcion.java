/* funcion.java */
/* Generated By:JavaCC: Do not edit this line. funcion.java */
package xml.funcion;

public class funcion implements funcionConstants {
  public static void main(String args[]) throws ParseException {
    funcion parser = new funcion(System.in);
    parser.S();
    System.out.println("Exito!!");
  }

  final public void S() throws ParseException {
    FUNC();
  }

  final public void FUNC() throws ParseException {
    jj_consume_token(TOKEN_FUNC_ABRE);
    jj_consume_token(TOKEN_NOMBRE_ABRE);
    jj_consume_token(CADENA);
    jj_consume_token(TOKEN_NOMBRE_CIERRA);
    jj_consume_token(TOKEN_PARAMS_ABRE);
    LISTA_PARAMS();
    jj_consume_token(TOKEN_PARAMS_CIERRA);
    jj_consume_token(TOKEN_SRC_ABRE);
    jj_consume_token(CODIGO);
    jj_consume_token(TOKEN_SRC_CIERRA);
    jj_consume_token(TOKEN_TIPO_ABRE);
    jj_consume_token(CADENA);
    jj_consume_token(TOKEN_TIPO_CIERRA);
    jj_consume_token(TOKEN_FUNC_CIERRA);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case TOKEN_FUNC_ABRE:{
      FUNC();
      break;
      }
    default:
      jj_la1[0] = jj_gen;
      ;
    }
  }

  final public void LISTA_PARAMS() throws ParseException {
    PARAMS();
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case TOKEN_TEXT_ABRE:
    case TOKEN_INTEGER_ABRE:
    case TOKEN_DOUBLE_ABRE:
    case TOKEN_BOOL_ABRE:
    case TOKEN_DATE_ABRE:
    case TOKEN_DATETIME_ABRE:
    case TOKEN_ID_ABRE:{
      LISTA_PARAMS();
      break;
      }
    default:
      jj_la1[1] = jj_gen;
      ;
    }
  }

  final public void PARAMS() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case TOKEN_INTEGER_ABRE:{
      jj_consume_token(TOKEN_INTEGER_ABRE);
      jj_consume_token(CADENA);
      jj_consume_token(TOKEN_INTEGER_CIERRA);
      break;
      }
    case TOKEN_TEXT_ABRE:{
      jj_consume_token(TOKEN_TEXT_ABRE);
      jj_consume_token(CADENA);
      jj_consume_token(TOKEN_TEXT_CIERRA);
      break;
      }
    case TOKEN_DOUBLE_ABRE:{
      jj_consume_token(TOKEN_DOUBLE_ABRE);
      jj_consume_token(CADENA);
      jj_consume_token(TOKEN_DOUBLE_CIERRA);
      break;
      }
    case TOKEN_BOOL_ABRE:{
      jj_consume_token(TOKEN_BOOL_ABRE);
      jj_consume_token(CADENA);
      jj_consume_token(TOKEN_BOOL_CIERRA);
      break;
      }
    case TOKEN_DATE_ABRE:{
      jj_consume_token(TOKEN_DATE_ABRE);
      jj_consume_token(CADENA);
      jj_consume_token(TOKEN_DATE_CIERRA);
      break;
      }
    case TOKEN_DATETIME_ABRE:{
      jj_consume_token(TOKEN_DATETIME_ABRE);
      jj_consume_token(CADENA);
      jj_consume_token(TOKEN_DATETIME_CIERRA);
      break;
      }
    case TOKEN_ID_ABRE:{
      jj_consume_token(TOKEN_ID_ABRE);
      jj_consume_token(CADENA);
      jj_consume_token(TOKEN_ID_CIERRA);
      break;
      }
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  /** Generated Token Manager. */
  public funcionTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[3];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x2,0x8aaa00,0x8aaa00,};
   }

  /** Constructor with InputStream. */
  public funcion(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public funcion(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new funcionTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
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
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public funcion(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new funcionTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public funcion(funcionTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(funcionTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
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
    boolean[] la1tokens = new boolean[31];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 3; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 31; i++) {
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
