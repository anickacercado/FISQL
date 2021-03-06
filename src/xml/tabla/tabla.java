/* tabla.java */
/* Generated By:JavaCC: Do not edit this line. tabla.java */
package xml.tabla;
import java.util.ArrayList;
import archivos.tabla.*;
import DML.*;
import archivos.memoria;

public class tabla implements tablaConstants {

  accionTabla at = new accionTabla();
  private ArrayList<registro_objeto> lro = new ArrayList<registro_objeto>();
  private String nombre_campo, valor;




  public static void main(String args[]) throws ParseException {
    tabla parser = new tabla(System.in);
    parser.S();
  }

  final public void S() throws ParseException {
    ROW();
  }

  final public void ROW() throws ParseException {
    jj_consume_token(TOKEN_ROWS_ABRE);
    LISTA_REGISTRO();
    jj_consume_token(TOKEN_ROWS_CIERRA);

    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case TOKEN_ROWS_ABRE:{
      ROW();
      break;
      }
    default:
      jj_la1[0] = jj_gen;
      ;
    }
  }

  final public void LISTA_REGISTRO() throws ParseException {Token nc,v;
    nc = jj_consume_token(TOKEN_ID_ABRE);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case CADENA:{
      v = jj_consume_token(CADENA);
nombre_campo= nc.image;
                                            nombre_campo= nombre_campo.substring(1, nombre_campo.length()-1);
                                            valor= v.image;
                                            valor= valor.substring(1, valor.length()-1);
                                            at.insertTable(memoria.Insert_db_actual,memoria.Insert_table_actual, nombre_campo,valor);
      break;
      }
    case TOKEN_ID_ABRE:{
      LISTA_OBJETO();
nombre_campo= nc.image;
                                            nombre_campo= nombre_campo.substring(1, nombre_campo.length()-1);
                                            at.insertTableObject(memoria.Insert_db_actual,memoria.Insert_table_actual, nombre_campo, lro);
                                            lro= new ArrayList<registro_objeto>();
      break;
      }
    default:
      jj_la1[1] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(TOKEN_ID_CIERRA);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case TOKEN_ID_ABRE:{
      LISTA_REGISTRO();
      break;
      }
    default:
      jj_la1[2] = jj_gen;
      ;
    }
  }

  final public void LISTA_OBJETO() throws ParseException {Token nc,v;
    nc = jj_consume_token(TOKEN_ID_ABRE);
    v = jj_consume_token(CADENA);
nombre_campo= nc.image;
                                        nombre_campo= nombre_campo.substring(1, nombre_campo.length()-1);
                                        valor= v.image;
                                        valor= valor.substring(1, valor.length()-1);
                                        registro_objeto ro = new registro_objeto(nombre_campo,valor);
                                        lro.add(ro);
    jj_consume_token(TOKEN_ID_CIERRA);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case TOKEN_ID_ABRE:{
      LISTA_OBJETO();
      break;
      }
    default:
      jj_la1[3] = jj_gen;
      ;
    }
  }

  /** Generated Token Manager. */
  public tablaTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[4];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x2,0x28,0x8,0x8,};
   }

  /** Constructor with InputStream. */
  public tabla(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public tabla(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new tablaTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 4; i++) jj_la1[i] = -1;
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
    for (int i = 0; i < 4; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public tabla(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new tablaTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 4; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 4; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public tabla(tablaTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 4; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(tablaTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 4; i++) jj_la1[i] = -1;
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
    boolean[] la1tokens = new boolean[10];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 4; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 10; i++) {
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
