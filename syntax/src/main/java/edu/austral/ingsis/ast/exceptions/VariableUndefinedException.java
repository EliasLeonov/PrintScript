package edu.austral.ingsis.ast.exceptions;

import edu.austral.ingsis.tokens.Token;

public class VariableUndefinedException extends RuntimeException {

  public VariableUndefinedException(String identifier) {
    super("Identifier " + identifier + " is undefined.");
  }

  public VariableUndefinedException(Token identifier) {
    super("Identifier " + identifier.toString() + " is undefined.");
  }
}
