package edu.austral.ingsis;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import org.junit.jupiter.api.Test;

class LexerTest {

  static Lexer lexer = Lexer.builder().build();

  @Test
  public void simpleStatementTest() {
    List<String> str = new ArrayList<>();
    str.add("let x : number = 5 ;");
    List<Token> tokens = lexer.tokenize(str);
    List<Token> expectedToken =
        Arrays.asList(
            Token.builder().type(TokenType.LET).value("let").index(0).line(0).build(),
            Token.builder().type(TokenType.IDENTIFIER).value("x").index(1).line(0).build(),
            Token.builder().type(TokenType.COLON).value(":").index(2).line(0).build(),
            Token.builder().type(TokenType.TYPE).value("number").index(3).line(0).build(),
            Token.builder().type(TokenType.EQUALS).value("=").index(4).line(0).build(),
            Token.builder().type(TokenType.LITERAL).value("5").index(5).line(0).build(),
            Token.builder().type(TokenType.SEMICOLON).value(";").index(6).line(0).build());
 
    assertEquals(expectedToken, tokens);
  }

//  @Test
//  public void twoLinesStatementTest() {
//    List<String> str = new ArrayList<>();
//    str.add("let x : number = 5 ;");
//    str.add("let a : string = \"hola\" ;");
//    List<Token> tokens = lexer.tokenize(str);
//    List<Token> expectedToken =
//        Arrays.asList(
//            Token.builder().type(TokenType.LET).value("let").index(0).line(0).build(),
//            Token.builder().type(TokenType.IDENTIFIER).value("x").index(1).line(0).build(),
//            Token.builder().type(TokenType.COLON).value(":").index(2).line(0).build(),
//            Token.builder().type(TokenType.TYPE).value("number").index(3).line(0).build(),
//            Token.builder().type(TokenType.EQUALS).value("=").index(4).line(0).build(),
//            Token.builder().type(TokenType.LITERAL).value("5").index(5).line(0).build(),
//            Token.builder().type(TokenType.SEMICOLON).value(";").index(6).line(0).build(),
//            Token.builder().type(TokenType.LET).value("let").index(0).line(1).build(),
//            Token.builder().type(TokenType.IDENTIFIER).value("a").index(1).line(1).build(),
//            Token.builder().type(TokenType.COLON).value(":").index(2).line(1).build(),
//            Token.builder().type(TokenType.TYPE).value("string").index(3).line(1).build(),
//            Token.builder().type(TokenType.EQUALS).value("=").index(4).line(1).build(),
//            Token.builder().type(TokenType.LITERAL).value("\""+"hola"+"\"").index(5).line(1).build(),
//            Token.builder().type(TokenType.SEMICOLON).value(";").index(6).line(1).build());
//    assertEquals(expectedToken, tokens);
//  }

  @Test
  public void twoLinesStatementTestWithMathOperator() {
    List<String> str = new ArrayList<>();
    str.add("let x : number = 5 ;");
    str.add("a + 6 ;");

    List<Token> tokens = lexer.tokenize(str);

    List<Token> expectedToken =
        Arrays.asList(
            Token.builder().type(TokenType.LET).value("let").index(0).line(0).build(),
            Token.builder().type(TokenType.IDENTIFIER).value("x").index(1).line(0).build(),
            Token.builder().type(TokenType.COLON).value(":").index(2).line(0).build(),
            Token.builder().type(TokenType.TYPE).value("number").index(3).line(0).build(),
            Token.builder().type(TokenType.EQUALS).value("=").index(4).line(0).build(),
            Token.builder().type(TokenType.LITERAL).value("5").index(5).line(0).build(),
            Token.builder().type(TokenType.SEMICOLON).value(";").index(6).line(0).build(),
            Token.builder().type(TokenType.IDENTIFIER).value("a").index(0).line(1).build(),
            Token.builder().type(TokenType.PLUS_SYMBOL).value("+").index(1).line(1).build(),
            Token.builder().type(TokenType.LITERAL).value("6").index(2).line(1).build(),
            Token.builder().type(TokenType.SEMICOLON).value(";").index(3).line(1).build());

    assertEquals(expectedToken, tokens);
  }

  @Test
  public void linesStatementTestWithPrintln() {
    List<String> str = new ArrayList<>();
    str.add("println ( a ) ;");

    List<Token> tokens = lexer.tokenize(str);

    List<Token> expectedToken =
        Arrays.asList(
            Token.builder().type(TokenType.PRINTLN).value("println").index(0).line(0).build(),
            Token.builder().type(TokenType.L_PARENTHESES).value("(").index(1).line(0).build(),
            Token.builder().type(TokenType.IDENTIFIER).value("a").index(2).line(0).build(),
            Token.builder().type(TokenType.R_PARENTHESES).value(")").index(3).line(0).build(),
            Token.builder().type(TokenType.SEMICOLON).value(";").index(4).line(0).build());

    assertEquals(expectedToken, tokens);
  }
}
