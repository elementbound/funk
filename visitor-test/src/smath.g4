grammar smath;

NUMBER: [0-9]+( '.' [0-9]+)?; 
ID: [a-zA-Z_$][a-zA-Z_$0-9]*;
OP: '+' | '-' | '*' | '/';

WS: [ \t\r\n] -> skip; 

expr: NUMBER # Literal
	| ID # ID
	| ID '=' expr # Assign
	| expr OP expr # BinaryOp
	| '(' expr ')' # EnclosedOp
	;