grammar funk; 

// Catch errors 
@parser::members 
{
  @Override
  public void notifyErrorListeners(Token offendingToken, String msg, RecognitionException ex)
  {
    throw new RuntimeException(msg); 
  }
}

NUMBER: [0-9]+;
STRING: '\'' (~'\'')* '\'';
ID: [_a-zA-Z][a-zA-Z0-9]*;

expr: ID | 
	  STRING | NUMBER |
	  expr '+' expr | 
	  ID '=' expr | 
	  ID '.' ID '(' args ')';

args: expr | args ',' expr;
statement: expr ';';