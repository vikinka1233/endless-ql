grammar Grammar;


/**
 * Parser rules
 */
forms           : form+ EOF ;
form            : FORM label BRACKET_L elem+ BRACKET_R ;

label           : WORD ;
elem            : (line_elem | block_elem) ;
line_elem       : label COLON question type_expr;
block_elem      : if_block ;
if_block        : IF PARENTH_L stmt PARENTH_R BRACKET_L elem+ BRACKET_R ;
stmt            : label ;
question        : STRING ;
expr            : unop expr | (constant binop expr) | (label binop expr) | constant | label ;
constant        : NUMBER ;
binop           : (MINUS | PLUS | MULTIPLY | DIVIDE | EQ | NEQ | GTE | GT | LTE | LT) ;
unop            : (MINUS | PLUS | NOT) ;
type_expr       : type
                | type PARENTH_L expr PARENTH_R ;
type            : (BOOLEAN_TYPE | MONEY_TYPE | INTEGER_TYPE | STRING_TYPE) ;


/**
 * Lexer rules
 */

FORM            : 'form' ;
IF              : 'if' ;
BOOLEAN_TYPE    : 'boolean' ;
STRING_TYPE     : 'string' ;
INTEGER_TYPE    : 'integer' ;
MONEY_TYPE      : 'money' ;
BRACKET_L       : '{' ;
BRACKET_R       : '}' ;
PARENTH_L       : '(' ;
PARENTH_R       : ')' ;
MINUS           : '-' ;
PLUS            : '+' ;
MULTIPLY        : '*' ;
DIVIDE          : '/' ;
COLON           : ':' ;
EQ              : '==' ;
NEQ             : '!=' ;
GTE             : '>=' ;
GT              : '>' ;
LTE             : '<=' ;
LT              : '<' ;
NOT             : '!' ;


NEWLINE         : ('\r'? '\n' | '\r')+ -> skip ;
WHITESPACE      : (' ' | '\t') -> skip ;

NUMBER          : [0-9]+ ;
WORD            : [a-zA-Z]+[a-zA-Z0-9]*;
STRING          : '"'(.*?)'"';