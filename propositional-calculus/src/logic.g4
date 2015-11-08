grammar logic;

//TOKENS
ATOM: [A-Za-z][A-Za-z1-9_]*;
OP:'>' | '&' |'|';
NEG: '!';
OPEN: '(';
CLOSE: ')';

WS: [ \t\r\n] -> skip; 

expr: ATOM | OPEN expr CLOSE | OPEN expr OP expr CLOSE | OPEN NEG expr CLOSE;

line: expr*;