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
BINOP: '+' | '-' | '*' | '/' | '==' | '!=' | '<' | '>';
COMMENT: '/*' .*? '*/'; // Non-greedy matching

comment: COMMENT;
id: ID;
literal: STRING | NUMBER | BOOLEAN;
object: id | literal;
memberCall: object '.' ID '(' args? ')';
assign: ID '=' expr;
closedExpr: '(' expr ')';

expr: closedExpr | 
	  id | literal |
	  expr BINOP expr |
	  memberCall |
	  assign;

args: expr | args ',' expr;
statement: expr ';' | ifThenElse | forLoop | comment;

ifThenElse: 'if' '(' expr ')' scope ('else' scope)?; 
forLoop: 'for' '(' expr ';' expr ';' expr ')' scope; 
block: '{' statement+ '}';

scope: statement | block;