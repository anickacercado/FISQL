/* usuarioTokenManager.java */
/* Generated By:JavaCC: Do not edit this line. usuarioTokenManager.java */
package xml.usuario;
import java.util.ArrayList;
import archivos.usuario.*;

/** Token Manager. */
@SuppressWarnings("unused")public class usuarioTokenManager implements usuarioConstants {

  /** Debug output. */
  public  java.io.PrintStream debugStream = System.out;
  /** Set debug output. */
  public  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private final int jjStopStringLiteralDfa_0(int pos, long active0){
   switch (pos)
   {
      default :
         return -1;
   }
}
private final int jjStartNfa_0(int pos, long active0){
   return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0), pos + 1);
}
private int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
private int jjMoveStringLiteralDfa0_0(){
   switch(curChar)
   {
      case 60:
         return jjMoveStringLiteralDfa1_0(0x7ffffeL);
      default :
         return jjMoveNfa_0(0, 0);
   }
}
private int jjMoveStringLiteralDfa1_0(long active0){
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(0, active0);
      return 1;
   }
   switch(curChar)
   {
      case 47:
         return jjMoveStringLiteralDfa2_0(active0, 0x555554L);
      case 68:
      case 100:
         return jjMoveStringLiteralDfa2_0(active0, 0x2000L);
      case 69:
      case 101:
         return jjMoveStringLiteralDfa2_0(active0, 0x200L);
      case 70:
      case 102:
         return jjMoveStringLiteralDfa2_0(active0, 0x80000L);
      case 78:
      case 110:
         return jjMoveStringLiteralDfa2_0(active0, 0x8L);
      case 79:
      case 111:
         return jjMoveStringLiteralDfa2_0(active0, 0x20000L);
      case 80:
      case 112:
         return jjMoveStringLiteralDfa2_0(active0, 0x200820L);
      case 84:
      case 116:
         return jjMoveStringLiteralDfa2_0(active0, 0x8080L);
      case 85:
      case 117:
         return jjMoveStringLiteralDfa2_0(active0, 0x2L);
      default :
         break;
   }
   return jjStartNfa_0(0, active0);
}
private int jjMoveStringLiteralDfa2_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(0, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(1, active0);
      return 2;
   }
   switch(curChar)
   {
      case 65:
      case 97:
         return jjMoveStringLiteralDfa3_0(active0, 0x8020L);
      case 66:
      case 98:
         return jjMoveStringLiteralDfa3_0(active0, 0x22000L);
      case 68:
      case 100:
         return jjMoveStringLiteralDfa3_0(active0, 0x4000L);
      case 69:
      case 101:
         return jjMoveStringLiteralDfa3_0(active0, 0xc00L);
      case 70:
      case 102:
         return jjMoveStringLiteralDfa3_0(active0, 0x100000L);
      case 73:
      case 105:
         return jjMoveStringLiteralDfa3_0(active0, 0x80L);
      case 78:
      case 110:
         return jjMoveStringLiteralDfa3_0(active0, 0x10L);
      case 79:
      case 111:
         return jjMoveStringLiteralDfa3_0(active0, 0x40008L);
      case 80:
      case 112:
         return jjMoveStringLiteralDfa3_0(active0, 0x401040L);
      case 82:
      case 114:
         return jjMoveStringLiteralDfa3_0(active0, 0x200000L);
      case 83:
      case 115:
         return jjMoveStringLiteralDfa3_0(active0, 0x202L);
      case 84:
      case 116:
         return jjMoveStringLiteralDfa3_0(active0, 0x10100L);
      case 85:
      case 117:
         return jjMoveStringLiteralDfa3_0(active0, 0x80004L);
      default :
         break;
   }
   return jjStartNfa_0(1, active0);
}
private int jjMoveStringLiteralDfa3_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(1, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(2, active0);
      return 3;
   }
   switch(curChar)
   {
      case 62:
         if ((active0 & 0x2000L) != 0L)
            return jjStopAtPos(3, 13);
         break;
      case 65:
      case 97:
         return jjMoveStringLiteralDfa4_0(active0, 0x10040L);
      case 66:
      case 98:
         return jjMoveStringLiteralDfa4_0(active0, 0x4c000L);
      case 69:
      case 101:
         return jjMoveStringLiteralDfa4_0(active0, 0x1000L);
      case 73:
      case 105:
         return jjMoveStringLiteralDfa4_0(active0, 0x100L);
      case 74:
      case 106:
         return jjMoveStringLiteralDfa4_0(active0, 0x20000L);
      case 77:
      case 109:
         return jjMoveStringLiteralDfa4_0(active0, 0x8L);
      case 78:
      case 110:
         return jjMoveStringLiteralDfa4_0(active0, 0x80000L);
      case 79:
      case 111:
         return jjMoveStringLiteralDfa4_0(active0, 0x200010L);
      case 80:
      case 112:
         return jjMoveStringLiteralDfa4_0(active0, 0x80L);
      case 82:
      case 114:
         return jjMoveStringLiteralDfa4_0(active0, 0x400802L);
      case 83:
      case 115:
         return jjMoveStringLiteralDfa4_0(active0, 0x424L);
      case 84:
      case 116:
         return jjMoveStringLiteralDfa4_0(active0, 0x200L);
      case 85:
      case 117:
         return jjMoveStringLiteralDfa4_0(active0, 0x100000L);
      default :
         break;
   }
   return jjStartNfa_0(2, active0);
}
private int jjMoveStringLiteralDfa4_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(2, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(3, active0);
      return 4;
   }
   switch(curChar)
   {
      case 62:
         if ((active0 & 0x2L) != 0L)
            return jjStopAtPos(4, 1);
         else if ((active0 & 0x4000L) != 0L)
            return jjStopAtPos(4, 14);
         else if ((active0 & 0x20000L) != 0L)
            return jjStopAtPos(4, 17);
         break;
      case 65:
      case 97:
         return jjMoveStringLiteralDfa5_0(active0, 0x200L);
      case 66:
      case 98:
         return jjMoveStringLiteralDfa5_0(active0, 0x10008L);
      case 67:
      case 99:
         return jjMoveStringLiteralDfa5_0(active0, 0x280000L);
      case 74:
      case 106:
         return jjMoveStringLiteralDfa5_0(active0, 0x40000L);
      case 76:
      case 108:
         return jjMoveStringLiteralDfa5_0(active0, 0x8000L);
      case 77:
      case 109:
         return jjMoveStringLiteralDfa5_0(active0, 0x810L);
      case 78:
      case 110:
         return jjMoveStringLiteralDfa5_0(active0, 0x100000L);
      case 79:
      case 111:
         return jjMoveStringLiteralDfa5_0(active0, 0x400080L);
      case 80:
      case 112:
         return jjMoveStringLiteralDfa5_0(active0, 0x100L);
      case 82:
      case 114:
         return jjMoveStringLiteralDfa5_0(active0, 0x1004L);
      case 83:
      case 115:
         return jjMoveStringLiteralDfa5_0(active0, 0x60L);
      case 84:
      case 116:
         return jjMoveStringLiteralDfa5_0(active0, 0x400L);
      default :
         break;
   }
   return jjStartNfa_0(3, active0);
}
private int jjMoveStringLiteralDfa5_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(3, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(4, active0);
      return 5;
   }
   switch(curChar)
   {
      case 62:
         if ((active0 & 0x4L) != 0L)
            return jjStopAtPos(5, 2);
         else if ((active0 & 0x20L) != 0L)
            return jjStopAtPos(5, 5);
         else if ((active0 & 0x80L) != 0L)
            return jjStopAtPos(5, 7);
         else if ((active0 & 0x40000L) != 0L)
            return jjStopAtPos(5, 18);
         else if ((active0 & 0x80000L) != 0L)
            return jjStopAtPos(5, 19);
         else if ((active0 & 0x200000L) != 0L)
            return jjStopAtPos(5, 21);
         break;
      case 65:
      case 97:
         return jjMoveStringLiteralDfa6_0(active0, 0x8400L);
      case 66:
      case 98:
         return jjMoveStringLiteralDfa6_0(active0, 0x10L);
      case 67:
      case 99:
         return jjMoveStringLiteralDfa6_0(active0, 0x500000L);
      case 68:
      case 100:
         return jjMoveStringLiteralDfa6_0(active0, 0x200L);
      case 73:
      case 105:
         return jjMoveStringLiteralDfa6_0(active0, 0x800L);
      case 76:
      case 108:
         return jjMoveStringLiteralDfa6_0(active0, 0x10000L);
      case 77:
      case 109:
         return jjMoveStringLiteralDfa6_0(active0, 0x1000L);
      case 79:
      case 111:
         return jjMoveStringLiteralDfa6_0(active0, 0x100L);
      case 82:
      case 114:
         return jjMoveStringLiteralDfa6_0(active0, 0x8L);
      case 83:
      case 115:
         return jjMoveStringLiteralDfa6_0(active0, 0x40L);
      default :
         break;
   }
   return jjStartNfa_0(4, active0);
}
private int jjMoveStringLiteralDfa6_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(4, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(5, active0);
      return 6;
   }
   switch(curChar)
   {
      case 62:
         if ((active0 & 0x40L) != 0L)
            return jjStopAtPos(6, 6);
         else if ((active0 & 0x100L) != 0L)
            return jjStopAtPos(6, 8);
         else if ((active0 & 0x8000L) != 0L)
            return jjStopAtPos(6, 15);
         else if ((active0 & 0x100000L) != 0L)
            return jjStopAtPos(6, 20);
         else if ((active0 & 0x400000L) != 0L)
            return jjStopAtPos(6, 22);
         break;
      case 65:
      case 97:
         return jjMoveStringLiteralDfa7_0(active0, 0x10000L);
      case 68:
      case 100:
         return jjMoveStringLiteralDfa7_0(active0, 0x400L);
      case 69:
      case 101:
         return jjMoveStringLiteralDfa7_0(active0, 0x8L);
      case 73:
      case 105:
         return jjMoveStringLiteralDfa7_0(active0, 0x1000L);
      case 79:
      case 111:
         return jjMoveStringLiteralDfa7_0(active0, 0x200L);
      case 82:
      case 114:
         return jjMoveStringLiteralDfa7_0(active0, 0x10L);
      case 83:
      case 115:
         return jjMoveStringLiteralDfa7_0(active0, 0x800L);
      default :
         break;
   }
   return jjStartNfa_0(5, active0);
}
private int jjMoveStringLiteralDfa7_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(5, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(6, active0);
      return 7;
   }
   switch(curChar)
   {
      case 62:
         if ((active0 & 0x8L) != 0L)
            return jjStopAtPos(7, 3);
         else if ((active0 & 0x200L) != 0L)
            return jjStopAtPos(7, 9);
         else if ((active0 & 0x10000L) != 0L)
            return jjStopAtPos(7, 16);
         break;
      case 69:
      case 101:
         return jjMoveStringLiteralDfa8_0(active0, 0x10L);
      case 79:
      case 111:
         return jjMoveStringLiteralDfa8_0(active0, 0xc00L);
      case 83:
      case 115:
         return jjMoveStringLiteralDfa8_0(active0, 0x1000L);
      default :
         break;
   }
   return jjStartNfa_0(6, active0);
}
private int jjMoveStringLiteralDfa8_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(6, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(7, active0);
      return 8;
   }
   switch(curChar)
   {
      case 62:
         if ((active0 & 0x10L) != 0L)
            return jjStopAtPos(8, 4);
         else if ((active0 & 0x400L) != 0L)
            return jjStopAtPos(8, 10);
         else if ((active0 & 0x800L) != 0L)
            return jjStopAtPos(8, 11);
         break;
      case 79:
      case 111:
         return jjMoveStringLiteralDfa9_0(active0, 0x1000L);
      default :
         break;
   }
   return jjStartNfa_0(7, active0);
}
private int jjMoveStringLiteralDfa9_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(7, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(8, active0);
      return 9;
   }
   switch(curChar)
   {
      case 62:
         if ((active0 & 0x1000L) != 0L)
            return jjStopAtPos(9, 12);
         break;
      default :
         break;
   }
   return jjStartNfa_0(8, active0);
}
static final long[] jjbitVec0 = {
   0x0L, 0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL
};
private int jjMoveNfa_0(int startState, int curPos)
{
   int startsAt = 0;
   jjnewStateCnt = 3;
   int i = 1;
   jjstateSet[0] = startState;
   int kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         do
         {
            switch(jjstateSet[--i])
            {
               case 0:
                  if (curChar == 34)
                     { jjCheckNAddTwoStates(1, 2); }
                  break;
               case 1:
                  if ((0xfffffffbffffffffL & l) != 0L)
                     { jjCheckNAddTwoStates(1, 2); }
                  break;
               case 2:
                  if (curChar == 34 && kind > 23)
                     kind = 23;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 1:
                  { jjAddStates(0, 1); }
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 1:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     { jjAddStates(0, 1); }
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 3 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
static final int[] jjnextStates = {
   1, 2, 
};

/** Token literal values. */
public static final String[] jjstrLiteralImages = {
"", null, null, null, null, null, null, null, null, null, null, null, null, 
null, null, null, null, null, null, null, null, null, null, null, null, null, null, 
null, };
protected Token jjFillToken()
{
   final Token t;
   final String curTokenImage;
   final int beginLine;
   final int endLine;
   final int beginColumn;
   final int endColumn;
   String im = jjstrLiteralImages[jjmatchedKind];
   curTokenImage = (im == null) ? input_stream.GetImage() : im;
   beginLine = input_stream.getBeginLine();
   beginColumn = input_stream.getBeginColumn();
   endLine = input_stream.getEndLine();
   endColumn = input_stream.getEndColumn();
   t = Token.newToken(jjmatchedKind, curTokenImage);

   t.beginLine = beginLine;
   t.endLine = endLine;
   t.beginColumn = beginColumn;
   t.endColumn = endColumn;

   return t;
}

int curLexState = 0;
int defaultLexState = 0;
int jjnewStateCnt;
int jjround;
int jjmatchedPos;
int jjmatchedKind;

/** Get the next Token. */
public Token getNextToken() 
{
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {
   try
   {
      curChar = input_stream.BeginToken();
   }
   catch(java.io.IOException e)
   {
      jjmatchedKind = 0;
      jjmatchedPos = -1;
      matchedToken = jjFillToken();
      return matchedToken;
   }
   image = jjimage;
   image.setLength(0);
   jjimageLen = 0;

   try { input_stream.backup(0);
      while (curChar <= 32 && (0x100002600L & (1L << curChar)) != 0L)
         curChar = input_stream.BeginToken();
   }
   catch (java.io.IOException e1) { continue EOFLoop; }
   jjmatchedKind = 0x7fffffff;
   jjmatchedPos = 0;
   curPos = jjMoveStringLiteralDfa0_0();
   if (jjmatchedKind != 0x7fffffff)
   {
      if (jjmatchedPos + 1 < curPos)
         input_stream.backup(curPos - jjmatchedPos - 1);
      if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
      {
         matchedToken = jjFillToken();
         TokenLexicalActions(matchedToken);
         return matchedToken;
      }
      else
      {
         continue EOFLoop;
      }
   }
   int error_line = input_stream.getEndLine();
   int error_column = input_stream.getEndColumn();
   String error_after = null;
   boolean EOFSeen = false;
   try { input_stream.readChar(); input_stream.backup(1); }
   catch (java.io.IOException e1) {
      EOFSeen = true;
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
      if (curChar == '\n' || curChar == '\r') {
         error_line++;
         error_column = 0;
      }
      else
         error_column++;
   }
   if (!EOFSeen) {
      input_stream.backup(1);
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
   }
   throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
  }
}

void TokenLexicalActions(Token matchedToken)
{
   switch(jjmatchedKind)
   {
      case 1 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
                               System.out.println(image);
         break;
      case 2 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
                                   System.out.println(image);
         break;
      case 3 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
                                      System.out.println(image);
         break;
      case 4 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
                                         System.out.println(image);
         break;
      case 5 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
                                  System.out.println(image);
         break;
      case 6 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
                                     System.out.println(image);
         break;
      case 7 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
                                  System.out.println(image);
         break;
      case 8 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
                                     System.out.println(image);
         break;
      case 9 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
                                      System.out.println(image);
         break;
      case 10 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
                                         System.out.println(image);
         break;
      case 11 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
                                        System.out.println(image);
         break;
      case 12 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
                                           System.out.println(image);
         break;
      case 13 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
                              System.out.println(image);
         break;
      case 14 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
                                 System.out.println(image);
         break;
      case 15 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
                                    System.out.println(image);
         break;
      case 16 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
                                       System.out.println(image);
         break;
      case 17 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
                                System.out.println(image);
         break;
      case 18 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
                                   System.out.println(image);
         break;
      case 19 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
                                  System.out.println(image);
         break;
      case 20 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
                                     System.out.println(image);
         break;
      case 21 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
                                  System.out.println(image);
         break;
      case 22 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
                                     System.out.println(image);
         break;
      case 23 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
                                 System.out.println(image);
         break;
      default :
         break;
   }
}
private void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
private void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
private void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}

    /** Constructor. */
    public usuarioTokenManager(SimpleCharStream stream){

      if (SimpleCharStream.staticFlag)
            throw new Error("ERROR: Cannot use a static CharStream class with a non-static lexical analyzer.");

    input_stream = stream;
  }

  /** Constructor. */
  public usuarioTokenManager (SimpleCharStream stream, int lexState){
    ReInit(stream);
    SwitchTo(lexState);
  }

  /** Reinitialise parser. */
  public void ReInit(SimpleCharStream stream)
  {
    jjmatchedPos = jjnewStateCnt = 0;
    curLexState = defaultLexState;
    input_stream = stream;
    ReInitRounds();
  }

  private void ReInitRounds()
  {
    int i;
    jjround = 0x80000001;
    for (i = 3; i-- > 0;)
      jjrounds[i] = 0x80000000;
  }

  /** Reinitialise parser. */
  public void ReInit(SimpleCharStream stream, int lexState)
  {
    ReInit(stream);
    SwitchTo(lexState);
  }

  /** Switch to specified lex state. */
  public void SwitchTo(int lexState)
  {
    if (lexState >= 1 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
    else
      curLexState = lexState;
  }

/** Lexer state names. */
public static final String[] lexStateNames = {
   "DEFAULT",
};
static final long[] jjtoToken = {
   0xffffffL, 
};
static final long[] jjtoSkip = {
   0xf000000L, 
};
    protected SimpleCharStream  input_stream;

    private final int[] jjrounds = new int[3];
    private final int[] jjstateSet = new int[2 * 3];

    private final StringBuilder jjimage = new StringBuilder();
    private StringBuilder image = jjimage;
    private int jjimageLen;
    private int lengthOfMatch;
    
    protected char curChar;
}
