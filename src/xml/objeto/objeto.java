/* objeto.java */
/* Generated By:JavaCC: Do not edit this line. objeto.java */
package xml.objeto;
import java.util.ArrayList;
import archivos.*;
import archivos.objeto.*;

public class objeto implements objetoConstants {

  private ArrayList<parametro> lp= new ArrayList<parametro>();
  private ArrayList<object> lo = new ArrayList<object>();
  private String nombre_obj, nombre_param;

  public static void main(String args[]) throws ParseException {
    objeto parser = new objeto(System.in);
    parser.S();
    System.out.println("Exito!!");
  }

  final public ArrayList<object> S() throws ParseException {
    OBJ();
{if ("" != null) return lo;}
    throw new Error("Missing return statement in function");
  }

  final public void OBJ() throws ParseException {Token t;
    jj_consume_token(TOKEN_OBJ_ABRE);
    jj_consume_token(TOKEN_NOMBRE_ABRE);
    t = jj_consume_token(CADENA);
    jj_consume_token(TOKEN_NOMBRE_CIERRA);
    jj_consume_token(TOKEN_ATTR_ABRE);
    LISTA_ATTR();
    jj_consume_token(TOKEN_ATTR_CIERRA);
    jj_consume_token(TOKEN_OBJ_CIERRA);
nombre_obj= t.image;
             nombre_obj= nombre_obj.substring(1, nombre_obj.length()-1);
             object o= new object(nombre_obj,lp);
             lo.add(o);
             lp= new ArrayList<parametro>();
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case TOKEN_OBJ_ABRE:{
      OBJ();
      break;
      }
    default:
      jj_la1[0] = jj_gen;
      ;
    }
  }

  final public void LISTA_ATTR() throws ParseException {
    ATTR();
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case TOKEN_TEXT_ABRE:
    case TOKEN_INTEGER_ABRE:
    case TOKEN_DOUBLE_ABRE:
    case TOKEN_BOOL_ABRE:
    case TOKEN_DATE_ABRE:
    case TOKEN_DATETIME_ABRE:{
      LISTA_ATTR();
      break;
      }
    default:
      jj_la1[1] = jj_gen;
      ;
    }
  }

  final public void ATTR() throws ParseException {Token t;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case TOKEN_INTEGER_ABRE:{
      jj_consume_token(TOKEN_INTEGER_ABRE);
      t = jj_consume_token(CADENA);
      jj_consume_token(TOKEN_INTEGER_CIERRA);
nombre_param= t.image;
                                                                nombre_param= nombre_param.substring(1, nombre_param.length()-1);
                                                                parametro p=new parametro(nombre_param,"INTEGER");
                                                                lp.add(p);
      break;
      }
    case TOKEN_TEXT_ABRE:{
      jj_consume_token(TOKEN_TEXT_ABRE);
      t = jj_consume_token(CADENA);
      jj_consume_token(TOKEN_TEXT_CIERRA);
nombre_param= t.image;
                                                                nombre_param= nombre_param.substring(1, nombre_param.length()-1);
                                                                parametro p=new parametro(nombre_param,"TEXT");
                                                                lp.add(p);
      break;
      }
    case TOKEN_DOUBLE_ABRE:{
      jj_consume_token(TOKEN_DOUBLE_ABRE);
      t = jj_consume_token(CADENA);
      jj_consume_token(TOKEN_DOUBLE_CIERRA);
nombre_param= t.image;
                                                                nombre_param= nombre_param.substring(1, nombre_param.length()-1);
                                                                parametro p=new parametro(nombre_param,"DOUBLE");
                                                                lp.add(p);
      break;
      }
    case TOKEN_BOOL_ABRE:{
      jj_consume_token(TOKEN_BOOL_ABRE);
      t = jj_consume_token(CADENA);
      jj_consume_token(TOKEN_BOOL_CIERRA);
nombre_param= t.image;
                                                                nombre_param= nombre_param.substring(1, nombre_param.length()-1);
                                                                parametro p=new parametro(nombre_param,"BOOL");
                                                                lp.add(p);
      break;
      }
    case TOKEN_DATE_ABRE:{
      jj_consume_token(TOKEN_DATE_ABRE);
      t = jj_consume_token(CADENA);
      jj_consume_token(TOKEN_DATE_CIERRA);
nombre_param= t.image;
                                                                nombre_param= nombre_param.substring(1, nombre_param.length()-1);
                                                                parametro p=new parametro(nombre_param,"DATE");
                                                                lp.add(p);
      break;
      }
    case TOKEN_DATETIME_ABRE:{
      jj_consume_token(TOKEN_DATETIME_ABRE);
      t = jj_consume_token(CADENA);
      jj_consume_token(TOKEN_DATETIME_CIERRA);
nombre_param= t.image;
                                                                nombre_param= nombre_param.substring(1, nombre_param.length()-1);
                                                                parametro p=new parametro(nombre_param,"DATETIME");
                                                                lp.add(p);
      break;
      }
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  /** Generated Token Manager. */
  public objetoTokenManager token_source;
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
      jj_la1_0 = new int[] {0x2,0x2aa80,0x2aa80,};
   }

  /** Constructor with InputStream. */
  public objeto(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public objeto(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new objetoTokenManager(jj_input_stream);
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
  public objeto(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new objetoTokenManager(jj_input_stream);
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
  public objeto(objetoTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(objetoTokenManager tm) {
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
    boolean[] la1tokens = new boolean[26];
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
    for (int i = 0; i < 26; i++) {
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
