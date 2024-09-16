grammar IsiLang;

@header { 
	package Isi.parser;
	import Isi.datastructures.IsiSymbol;
	import Isi.datastructures.IsiVariable;
	import Isi.datastructures.IsiSymbolTable;
	import exceptions.IsiSemanticException;
	import ast.IsiProgram;
	import ast.AbstractCommand;
	import ast.CommandLeitura;
	import ast.CommandEscrita;
	import ast.CommandAtribuicao;
	import ast.CommandRepeticao;
	import ast.CommandDecisao;
	import ast.CommandSwitch;
	import java.util.ArrayList;
	import java.util.Stack;
}

@members{
	private int _tipo;
	private String _varName;
	private String _varValue;
	private IsiSymbolTable symbolTable = new IsiSymbolTable();
	private IsiSymbol symbol;
	private IsiProgram program = new IsiProgram();
	private ArrayList<AbstractCommand> curThread;
	private Stack<ArrayList<AbstractCommand>> stack = new Stack<ArrayList<AbstractCommand>>();
	private String _readID;
	private String _writeID;
	private String _exprID;
	private String _exprContent;
	private String _exprDecision;
	private String cases = "";
	private ArrayList<AbstractCommand> listaTrue;
	private ArrayList<AbstractCommand> listaFalse;
	private ArrayList<AbstractCommand> loop;
	private ArrayList<AbstractCommand> choice;
	private ArrayList<AbstractCommand> defaultChoice;
	
	public void verificaID(String id){
		if (!symbolTable.exists(id)){
			throw new IsiSemanticException("Symbol "+id+" not declared");
		}
	}
	
	public void exibeComandos(){
		for (AbstractCommand c: program.getComandos()){
			System.out.println(c);
		}
	}
	
	public void generateCode(){
		program.generateTarget();
	}
}

prog	: 'programa' declara bloco 'fimprog.'
			{	program.setVarTable(symbolTable);
				program.setComandos(stack.pop());				
			}
		;
		
declara	: (declaraVar)+ 
		;

declaraVar	: 'declare' tipo ID {
				                  _varName = _input.LT(-1).getText();
				                  _varValue = null;
				                  symbol = new IsiVariable(_varName, _tipo, _varValue);
				                  if (!symbolTable.exists(_varName)){
				                     symbolTable.add(symbol);	
				                  }
				                  else{
				                  	 throw new IsiSemanticException("Symbol "+_varName+" already declared");
				                  }
                    			} 
							 (',' 
							 	ID {
					                  _varName = _input.LT(-1).getText();
					                  _varValue = null;
					                  symbol = new IsiVariable(_varName, _tipo, _varValue);
					                  if (!symbolTable.exists(_varName)){
					                     symbolTable.add(symbol);	
					                  }
					                  else{
					                  	 throw new IsiSemanticException("Symbol "+_varName+" already declared");
					                  }
				                   } 
							 )* '.'
			;
			
tipo	: 'numero' { _tipo = IsiVariable.NUMBER;}
		| 'texto'  { _tipo = IsiVariable.TEXT;}
		;
	
bloco	: { curThread = new ArrayList<AbstractCommand>();
			stack.push(curThread);
		  }
		(cmd)+
		;
		
cmd		: cmdLeitura { System.out.println("Comando de leitura computado");}
		| cmdEscrita { System.out.println("Comando de escrita computado");}
		| cmdIf		 { System.out.println("Comando de decisão computado");}
		| cmdSwitch	 { System.out.println("Comando de desisão: Switch computado");}
		| cmdWhile	 { System.out.println("Comando de repetição computado");}
		| cmdExpr	 { System.out.println("Comando de atribuição computado");}
		;
		
cmdLeitura	: 'leia' AP  
					 ID { verificaID(_input.LT(-1).getText());
					 	  _readID = _input.LT(-1).getText();
					 	}
					 FP 
					 END
					 {
					 	IsiVariable var = (IsiVariable)symbolTable.get(_readID);
					 	CommandLeitura cmd = new CommandLeitura(_readID, var);
						stack.peek().add(cmd);
					 }
			;
			
cmdEscrita	: 'escreva' AP 
						(
						TEXTO { _writeID = _input.LT(-1).getText();}
						| ID { verificaID(_input.LT(-1).getText());
					 		   _writeID = _input.LT(-1).getText();
					 		 }
						) 
						FP 
						END
			  			{
			  				CommandEscrita cmd = new CommandEscrita(_writeID);
			  				stack.peek().add(cmd);
			  			}
			;
			
cmdIf		: 'se' AP {listaFalse = null;}
				   expr { _exprDecision = _input.LT(-1).getText(); }
				   (OP_rel { _exprDecision += _input.LT(-1).getText(); }
				   	expr { _exprDecision += _input.LT(-1).getText(); }
				   )+ 
				   FP
			  'entao' AC 
			  		  { curThread = new ArrayList<AbstractCommand>();
			  		  	stack.push(curThread);
			  		  }
			  		  (cmd)+ 
			  		  FC 
			  		  {
			  		  	listaTrue = stack.pop();
			  		  }
			  ('senao' 
			  	AC 
			  	{ curThread = new ArrayList<AbstractCommand>();
			  	  stack.push(curThread);
			    }
			  	(cmd)+ 
			  	FC
			  	{
			  		listaFalse = stack.pop();
			  	}
			  )?
			  {
			  	CommandDecisao cmd = new CommandDecisao(_exprDecision, listaTrue, listaFalse);
			  	stack.peek().add(cmd);
			  }
			;
			
cmdSwitch	: 'escolha' AP 
						ID { verificaID(_input.LT(-1).getText());
							 _varName = _input.LT(-1).getText();
					 	  	 _readID = _input.LT(-1).getText();
					 	  	 _tipo = symbolTable.get(_varName).getType();
					 	  	 CommandSwitch cmd = new CommandSwitch(_readID);
					 	   }
						FP 
						AC
						('caso'	
							(NUMBER { if(_tipo != 0)
									 	throw new RuntimeException("Variable "+_varName+" type is TEXTO, but found NUMBER");
				 				   	  else
				 				   		cases = _input.LT(-1).getText();
				 				   	}
							| TEXTO { if(_tipo != 1)
										throw new RuntimeException("Variable "+_varName+" type is NUMBER, but found TEXTO");
									  else
									  	cases = _input.LT(-1).getText();
				 					}
				 			)
							':' { cases += _input.LT(-1).getText();}
							{ curThread = new ArrayList<AbstractCommand>();
			  		  	  	  stack.push(curThread);
			  		  	  	}
							(cmd)+ 
							{
			  				  choice = stack.pop();
			  				  cmd.addCase(cases, choice);
			  				}
							'fim.'
						)+
						{ defaultChoice = null;}
						('padrao:' 
							{ curThread = new ArrayList<AbstractCommand>();
			  	  			  stack.push(curThread);
			    			}
							(cmd)+
							{
			  				  defaultChoice = stack.pop();
			  				}
						)?
						{ cmd.addDefault(defaultChoice);
			  			  stack.peek().add(cmd);
			  			}
						FC
			;

cmdWhile	: 'enquanto' AP 
						 expr { _exprDecision = _input.LT(-1).getText(); }
						 (OP_rel { _exprDecision += _input.LT(-1).getText(); }
						 expr { _exprDecision += _input.LT(-1).getText(); }
						 )+ 
						 FP
			  			 AC
			  			 { curThread = new ArrayList<AbstractCommand>();
			  		  	   stack.push(curThread);
			  		  	 }
			  			 (cmd)+ 
			  			 FC
			  			 {
			  			   loop = stack.pop();
			  			   CommandRepeticao cmd = new CommandRepeticao(_exprDecision, loop);
			  		       stack.peek().add(cmd);
			  			 }
			;

cmdExpr		: ID { verificaID(_input.LT(-1).getText());
				   _varName = _input.LT(-1).getText();
				   _exprID = _input.LT(-1).getText();
				   _tipo = symbolTable.get(_varName).getType();
				 }
			':=' { _exprContent = "";}
			(expr { if(_tipo != 0)
					throw new RuntimeException("Variable "+_varName+" type is TEXTO, but found NUMBER");
				 }
			| TEXTO { if(_tipo != 1)
						throw new RuntimeException("Variable "+_varName+" type is NUMBER, but found TEXTO");
						else { _exprContent += _input.LT(-1).getText();}
				 	}
			)+
			END 
			{
				CommandAtribuicao cmd = new CommandAtribuicao(_exprID, _exprContent);
			  	stack.peek().add(cmd);
			}
			;
			
OP_rel		: '<' | '>' | '<=' | '>=' | '!=' | '=='
			;
			
expr		: termo 
			  '+' { _exprContent += _input.LT(-1).getText();}
			  termo 
			| termo 
			  '-' { _exprContent += _input.LT(-1).getText();}
			  termo 
			| termo
			;
			
termo		: fator 
			  '*' { _exprContent += _input.LT(-1).getText();}
			  fator 
			| fator 
			  '/' { _exprContent += _input.LT(-1).getText();}
			  fator 
			| fator
			;
			
fator		: NUMBER { _exprContent += _input.LT(-1).getText();}
			| ID { verificaID(_input.LT(-1).getText());
				   _exprContent += _input.LT(-1).getText();
				 }
			;
			
AP	: '('
	;
	
FP	: ')'
	;
	
AC	: '{'
	;

FC	: '}'
	;
	
END : '.'
	;
	
OP	: '+' | '-' | '*' | '/'
	;
		
ID	: ([a-z] | [A-Z]) ([a-z] | [A-Z] | [0-9])*
	;
	
NUMBER	: [0-9]+ ('.' [0-9]+)?
		;
		
TEXTO	: '"' ([a-z] | [A-Z] | [0-9] | ' ')+ '"'
		;
		
WS	: (' ' | '\t' | '\n' | '\r') -> skip;