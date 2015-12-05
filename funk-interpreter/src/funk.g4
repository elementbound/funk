grammar funk; 

// Catch errors 
@parser::members 
{
	@Override
	public void notifyErrorListeners(Token offendingToken, String msg, RecognitionException ex)
	{
		if(ex != null)
			throw ex; 
		else 
			throw new RecognitionException(msg, null, _input, _ctx);
	}
}

WS: [ \t\r\n] -> skip; 

NUMBER: [0-9]+;
STRING: '\'' (~'\'')* '\'' | '\"' (~'\"')* '\"';
BOOLEAN: 'True' | 'False';
ID: [_a-zA-Z][a-zA-Z0-9]*;
OP: '+' | '-' | '*' | '/' | '==' | '!=' | '<' | '>';
COMMENT: '/*' .*? '*/'; // Non-greedy matching

expr: '(' expr ')' 					# EnclosedExpr 
	 | ID 							# ID
	 | BOOLEAN 						# BooleanLiteral
	 | NUMBER 						# NumberLiteral
	 | STRING 						# StringLiteral
	 | '!' '.' ID '(' args ')'		# Constructor
	 | expr '.' ID '(' args ')' 	# MemberCall
	 | OP expr 						# UnaryOp
	 | expr OP expr 				# BinaryOp
	 | ID '=' expr 					# Assign
	 ;

args: ((expr ',')* expr)?;
statement: expr ';' 			# SingleStatement
	| ifThenElse 				# IfStatement
	| forLoop 					# ForStatement
	| block 					# BlockStatement
	| aggregateDecl				# AggregateDeclaration
	| COMMENT					# Comment
	;

ifThenElse: 'if' '(' expr ')' statement ('else' statement)?; 
forLoop: 'for' '(' expr ';' expr ';' expr ')' statement; 
block: '{' statement+ '}';
aggregateDecl: 'aggregate' ID '{' ((ID ',')* ID) '}'; 
