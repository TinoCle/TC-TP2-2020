grammar al;

@header {
    package app;
}

fragment LETRA : [A-Za-z] ;
fragment DIGITO : [0-9] ;

// MAYUSCULAS: tokens
// Minusculas: reglas gramaticales

PA : '(' ;
PC : ')' ; 

CA : '[' ;
CC : ']' ; 

LA : '{' ;
LC : '}' ; 
 
PYC 	: ';' 	   ;
COMA    : ','	   ;
INT 	: 'int'    ;
DOUBLE 	: 'double' ;
CHAR 	: 'char'   ;
VOID    : 'void'   ;

EQ		: '='	   ;
DO      : 'do'	   ;
WHILE   : 'while'  ;
FOR     : 'for'    ;
IF      : 'if'     ;
ELIF    : 'else if'; 
ELSE    : 'else'   ;

MENOR 	: '<'      ;
MAYOR 	: '>'  	   ;
MENORIG : '<=' 	   ;
MAYORIG : '>=' 	   ;
IGUAL	: '==' 	   ;
AND 	: '&&' 	   ;
OR 		: '||' 	   ;
DIFF 	: '!='     ;
NOT 	: '!'	   ;

RETURN : 'return' ;
ID		: (LETRA | '_') (LETRA | DIGITO |'_')*;
NUMERO	: DIGITO+;
FLOTANTE: NUMERO'.'NUMERO ;
LITERAL : '\'' (LETRA | DIGITO | OTRO) '\'' ;
WS : [ \n\t] -> skip ; 
OTRO: .; 

prog : instrucciones EOF ;

instrucciones : instruccion instrucciones
              | 
              ;

bloque : LA instrucciones LC
	   ;
 
balance : PA balance PC balance
		| LA balance LC balance
		| CA balance CC balance
		|
		;

instruccion : declaracion PYC
            | asignacion PYC
			| declaracion_funcion PYC
			| definicion_funcion
			| funcion PYC
			| condicional
			| iteracion
			| bloque
			| retornar PYC
            ;

// int sum (int ,int);
// int sum (int x, int y);
declaracion_funcion : tipodato ID PA param_declaracion? PC
					;

retornar : RETURN (operacion | );

param_declaracion : tipodato (ID | )
		   		  | tipodato (ID | ) COMA param_declaracion
		   		  ;

definicion_funcion: tipodato ID PA param_definicion? PC bloque
				  ;

param_definicion : tipodato ID
			     | tipodato ID COMA param_definicion
				 ;

funcion : ID PA parametros PC
		;

parametros : operacion
		   | operacion COMA parametros
		   |
		   ;

tipodato : INT
		 | CHAR
		 | DOUBLE
		 | VOID
		 ;

declaracion : tipodato ID
			| tipodato asignacion
			;
 
asign : EQ operacion
	  ;

asignacion : ID asign
		   ;

// if (i > 10); if (){} else if {} else{}; if (){} else {}
condicional : IF PA operacion PC instruccion (ELIF PA operacion PC instruccion)* (ELSE instruccion)?
            ;

iteracion : FOR PA (asignacion | declaracion | ) PYC (operacion | ) PYC (asignacion | operacion | ) PC instruccion
		  | WHILE PA operacion PC instruccion
		  | DO instruccion WHILE PA (operacion | ) PC PYC
		  ;

operacion : opal 
		  ;
  
// E -> T E'
expresion : termino exp ;

// E' -> + T E' | - T E' |
exp : '+' termino exp
    | '-' termino exp
    |
    ;

// T -> F T'
termino : factor term ;

// T' -> * F T' | / F T' |
term : '*' factor term
     | '/' factor term
	 | '%' factor term
     |
     ;



// F -> ( E ) | id
factor : prefix PA opal PC
       | prefix NUMERO
       | prefix ID
	   | prefix FLOTANTE
	   | prefix funcion
	   | prefix LITERAL
       ;

// NOT es el unico que le sigue prefix porque se pueden poner varios ! seguidos
prefix : '++'
	   | '--'
	   | '+'
	   | '-'
	   | NOT prefix
	   |
	   ; 

igualdad : expresion
		 | igualdad comparaciones expresion
		 ;

comparaciones : IGUAL
			  | DIFF
			  | MENOR
			  | MAYOR
			  | MENORIG
			  | MAYORIG
			  ;

// &&
conjuncion : igualdad
		   | conjuncion AND igualdad
		   ;

// ||			
disyuncion : conjuncion
		   | disyuncion OR conjuncion
		   ;

opal : disyuncion
	 |
	 ;
