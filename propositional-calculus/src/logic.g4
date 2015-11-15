grammar logic;

@parser::members 
{
  @Override
  public void notifyErrorListeners(Token offendingToken, String msg, RecognitionException ex)
  {
    throw new RuntimeException(msg); 
  }
}

//TOKENS
ATOM: [A-Za-z][A-Za-z1-9_]*;
OP:'>' | '&' |'|';
NEG: '!';
OPEN: '(';
CLOSE: ')';

WS: [ \t\r\n] -> skip; 

expr: ATOM | OPEN expr OP expr CLOSE | OPEN NEG expr CLOSE;

s: expr '#';