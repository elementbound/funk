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

WS: [ \t\r\n] -> skip; 

NUMBER: [0-9]+;
STRING: '\'' (~'\'')* '\'' | '\"' (~'\"')* '\"';
ID: [_a-zA-Z][a-zA-Z0-9]*;

id: ID;
literal: STRING | NUMBER;
object: id | literal;
memberCall: object '.' ID '(' args? ')';
assign: ID '=' expr;

expr: id | literal |
	  memberCall |
	  assign |
	  expr '+' expr;

args: expr | args ',' expr;
statement: expr ';';