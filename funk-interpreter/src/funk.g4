grammar funk; 

// Catch errors 
@parser::members 
{
  @Override
  public void notifyErrorListeners(Token offendingToken, String msg, RecognitionException ex)
  {
    throw ex; 
  }
}

WS: [ \t\r\n] -> skip; 

NUMBER: [0-9]+;
STRING: '\'' (~'\'')* '\'' | '\"' (~'\"')* '\"';
BOOLEAN: 'True' | 'False';
ID: [_a-zA-Z][a-zA-Z0-9]*;
BINOP: '+' | '-' | '*' | '/';

id: ID;
literal: STRING | NUMBER | BOOLEAN;
object: id | literal;
memberCall: object '.' ID '(' args? ')';
assign: ID '=' expr;

expr: id | literal |
	  memberCall |
	  assign |
	  expr BINOP expr;

args: expr | args ',' expr;
statement: expr ';';