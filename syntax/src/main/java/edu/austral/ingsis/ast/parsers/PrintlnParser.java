package edu.austral.ingsis.ast.parsers;

import edu.austral.ingsis.ast.TokenPattern;
import edu.austral.ingsis.ast.exceptions.SyntaxException;
import edu.austral.ingsis.ast.nodes.ExpressionNode;
import edu.austral.ingsis.ast.nodes.PrintNode;
import edu.austral.ingsis.tokens.Token;
import edu.austral.ingsis.tokens.TokenType;
import java.util.List;

public class PrintlnParser implements NodeParser<PrintNode> {

  private final ExpressionParser expressionParser = new ExpressionParser();

  @Override
  public boolean predicate(List<Token> tokens) {
    return TokenPattern.Builder.of(TokenType.PRINTLN).build().startWith(tokens);
  }

  @Override
  public PrintNode parse(List<Token> tokens) {
    int leftParenthesesIndex = getIndexOfToken(tokens, TokenType.L_PARENTHESES);
    int rightParenthesesIndex = getIndexOfToken(tokens, TokenType.R_PARENTHESES);
    if (leftParenthesesIndex == -1 || rightParenthesesIndex == -1) {
      throw new SyntaxException();
    }

    final PrintNode printNode = new PrintNode(tokens.get(0));
    final ExpressionNode expressionNode =
        expressionParser.parse(tokens.subList(leftParenthesesIndex + 1, rightParenthesesIndex));
    printNode.setArgs(expressionNode);

    return printNode;
  }
}
