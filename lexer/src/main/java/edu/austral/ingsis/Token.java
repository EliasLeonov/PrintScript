package edu.austral.ingsis;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Token {

  private String value;
  private TokenType type;
  private int line;
  private int index;
}
