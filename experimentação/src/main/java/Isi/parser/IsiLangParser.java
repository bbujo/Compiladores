// Generated from IsiLang.g4 by ANTLR 4.7.1
 
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

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class IsiLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, OP_rel=23, AP=24, FP=25, 
		AC=26, FC=27, END=28, OP=29, ID=30, NUMBER=31, TEXTO=32, WS=33;
	public static final int
		RULE_prog = 0, RULE_declara = 1, RULE_declaraVar = 2, RULE_tipo = 3, RULE_bloco = 4, 
		RULE_cmd = 5, RULE_cmdLeitura = 6, RULE_cmdEscrita = 7, RULE_cmdIf = 8, 
		RULE_cmdSwitch = 9, RULE_cmdWhile = 10, RULE_cmdExpr = 11, RULE_expr = 12, 
		RULE_termo = 13, RULE_fator = 14;
	public static final String[] ruleNames = {
		"prog", "declara", "declaraVar", "tipo", "bloco", "cmd", "cmdLeitura", 
		"cmdEscrita", "cmdIf", "cmdSwitch", "cmdWhile", "cmdExpr", "expr", "termo", 
		"fator"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'programa'", "'fimprog.'", "'declare'", "','", "'numero'", "'texto'", 
		"'leia'", "'escreva'", "'se'", "'entao'", "'senao'", "'escolha'", "'caso'", 
		"':'", "'fim.'", "'padrao:'", "'enquanto'", "':='", "'+'", "'-'", "'*'", 
		"'/'", null, "'('", "')'", "'{'", "'}'", "'.'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, "OP_rel", 
		"AP", "FP", "AC", "FC", "END", "OP", "ID", "NUMBER", "TEXTO", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "IsiLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


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

	public IsiLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public DeclaraContext declara() {
			return getRuleContext(DeclaraContext.class,0);
		}
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			match(T__0);
			setState(31);
			declara();
			setState(32);
			bloco();
			setState(33);
			match(T__1);
				program.setVarTable(symbolTable);
							program.setComandos(stack.pop());				
						
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaraContext extends ParserRuleContext {
		public List<DeclaraVarContext> declaraVar() {
			return getRuleContexts(DeclaraVarContext.class);
		}
		public DeclaraVarContext declaraVar(int i) {
			return getRuleContext(DeclaraVarContext.class,i);
		}
		public DeclaraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declara; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterDeclara(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitDeclara(this);
		}
	}

	public final DeclaraContext declara() throws RecognitionException {
		DeclaraContext _localctx = new DeclaraContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declara);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(36);
				declaraVar();
				}
				}
				setState(39); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__2 );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaraVarContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(IsiLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(IsiLangParser.ID, i);
		}
		public DeclaraVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaraVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterDeclaraVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitDeclaraVar(this);
		}
	}

	public final DeclaraVarContext declaraVar() throws RecognitionException {
		DeclaraVarContext _localctx = new DeclaraVarContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaraVar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			match(T__2);
			setState(42);
			tipo();
			setState(43);
			match(ID);

							                  _varName = _input.LT(-1).getText();
							                  _varValue = null;
							                  symbol = new IsiVariable(_varName, _tipo, _varValue);
							                  if (!symbolTable.exists(_varName)){
							                     symbolTable.add(symbol);	
							                  }
							                  else{
							                  	 throw new IsiSemanticException("Symbol "+_varName+" already declared");
							                  }
			                    			
			setState(50);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(45);
				match(T__3);
				setState(46);
				match(ID);

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
				}
				setState(52);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(53);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TipoContext extends ParserRuleContext {
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterTipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitTipo(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_tipo);
		try {
			setState(59);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(55);
				match(T__4);
				 _tipo = IsiVariable.NUMBER;
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(57);
				match(T__5);
				 _tipo = IsiVariable.TEXT;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlocoContext extends ParserRuleContext {
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public BlocoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloco; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterBloco(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitBloco(this);
		}
	}

	public final BlocoContext bloco() throws RecognitionException {
		BlocoContext _localctx = new BlocoContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_bloco);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 curThread = new ArrayList<AbstractCommand>();
						stack.push(curThread);
					  
			setState(63); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(62);
				cmd();
				}
				}
				setState(65); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__11) | (1L << T__16) | (1L << ID))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdContext extends ParserRuleContext {
		public CmdLeituraContext cmdLeitura() {
			return getRuleContext(CmdLeituraContext.class,0);
		}
		public CmdEscritaContext cmdEscrita() {
			return getRuleContext(CmdEscritaContext.class,0);
		}
		public CmdIfContext cmdIf() {
			return getRuleContext(CmdIfContext.class,0);
		}
		public CmdSwitchContext cmdSwitch() {
			return getRuleContext(CmdSwitchContext.class,0);
		}
		public CmdWhileContext cmdWhile() {
			return getRuleContext(CmdWhileContext.class,0);
		}
		public CmdExprContext cmdExpr() {
			return getRuleContext(CmdExprContext.class,0);
		}
		public CmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmd(this);
		}
	}

	public final CmdContext cmd() throws RecognitionException {
		CmdContext _localctx = new CmdContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_cmd);
		try {
			setState(85);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
				enterOuterAlt(_localctx, 1);
				{
				setState(67);
				cmdLeitura();
				 System.out.println("Comando de leitura computado");
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				setState(70);
				cmdEscrita();
				 System.out.println("Comando de escrita computado");
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 3);
				{
				setState(73);
				cmdIf();
				 System.out.println("Comando de decisão computado");
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 4);
				{
				setState(76);
				cmdSwitch();
				 System.out.println("Comando de desisão: Switch computado");
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 5);
				{
				setState(79);
				cmdWhile();
				 System.out.println("Comando de repetição computado");
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 6);
				{
				setState(82);
				cmdExpr();
				 System.out.println("Comando de atribuição computado");
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdLeituraContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public TerminalNode END() { return getToken(IsiLangParser.END, 0); }
		public CmdLeituraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdLeitura; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdLeitura(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdLeitura(this);
		}
	}

	public final CmdLeituraContext cmdLeitura() throws RecognitionException {
		CmdLeituraContext _localctx = new CmdLeituraContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cmdLeitura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(T__6);
			setState(88);
			match(AP);
			setState(89);
			match(ID);
			 verificaID(_input.LT(-1).getText());
								 	  _readID = _input.LT(-1).getText();
								 	
			setState(91);
			match(FP);
			setState(92);
			match(END);

								 	IsiVariable var = (IsiVariable)symbolTable.get(_readID);
								 	CommandLeitura cmd = new CommandLeitura(_readID, var);
									stack.peek().add(cmd);
								 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdEscritaContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public TerminalNode END() { return getToken(IsiLangParser.END, 0); }
		public TerminalNode TEXTO() { return getToken(IsiLangParser.TEXTO, 0); }
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public CmdEscritaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdEscrita; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdEscrita(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdEscrita(this);
		}
	}

	public final CmdEscritaContext cmdEscrita() throws RecognitionException {
		CmdEscritaContext _localctx = new CmdEscritaContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_cmdEscrita);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(T__7);
			setState(96);
			match(AP);
			setState(101);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TEXTO:
				{
				setState(97);
				match(TEXTO);
				 _writeID = _input.LT(-1).getText();
				}
				break;
			case ID:
				{
				setState(99);
				match(ID);
				 verificaID(_input.LT(-1).getText());
									 		   _writeID = _input.LT(-1).getText();
									 		 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(103);
			match(FP);
			setState(104);
			match(END);

						  				CommandEscrita cmd = new CommandEscrita(_writeID);
						  				stack.peek().add(cmd);
						  			
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdIfContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public List<TerminalNode> AC() { return getTokens(IsiLangParser.AC); }
		public TerminalNode AC(int i) {
			return getToken(IsiLangParser.AC, i);
		}
		public List<TerminalNode> FC() { return getTokens(IsiLangParser.FC); }
		public TerminalNode FC(int i) {
			return getToken(IsiLangParser.FC, i);
		}
		public List<TerminalNode> OP_rel() { return getTokens(IsiLangParser.OP_rel); }
		public TerminalNode OP_rel(int i) {
			return getToken(IsiLangParser.OP_rel, i);
		}
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdIf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdIf(this);
		}
	}

	public final CmdIfContext cmdIf() throws RecognitionException {
		CmdIfContext _localctx = new CmdIfContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cmdIf);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(T__8);
			setState(108);
			match(AP);
			listaFalse = null;
			setState(110);
			expr();
			 _exprDecision = _input.LT(-1).getText(); 
			setState(117); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(112);
				match(OP_rel);
				 _exprDecision += _input.LT(-1).getText(); 
				setState(114);
				expr();
				 _exprDecision += _input.LT(-1).getText(); 
				}
				}
				setState(119); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==OP_rel );
			setState(121);
			match(FP);
			setState(122);
			match(T__9);
			setState(123);
			match(AC);
			 curThread = new ArrayList<AbstractCommand>();
						  		  	stack.push(curThread);
						  		  
			setState(126); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(125);
				cmd();
				}
				}
				setState(128); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__11) | (1L << T__16) | (1L << ID))) != 0) );
			setState(130);
			match(FC);

						  		  	listaTrue = stack.pop();
						  		  
			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(132);
				match(T__10);
				setState(133);
				match(AC);
				 curThread = new ArrayList<AbstractCommand>();
							  	  stack.push(curThread);
							    
				setState(136); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(135);
					cmd();
					}
					}
					setState(138); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__11) | (1L << T__16) | (1L << ID))) != 0) );
				setState(140);
				match(FC);

							  		listaFalse = stack.pop();
							  	
				}
			}


						  	CommandDecisao cmd = new CommandDecisao(_exprDecision, listaTrue, listaFalse);
						  	stack.peek().add(cmd);
						  
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdSwitchContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public TerminalNode AC() { return getToken(IsiLangParser.AC, 0); }
		public TerminalNode FC() { return getToken(IsiLangParser.FC, 0); }
		public List<TerminalNode> NUMBER() { return getTokens(IsiLangParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(IsiLangParser.NUMBER, i);
		}
		public List<TerminalNode> TEXTO() { return getTokens(IsiLangParser.TEXTO); }
		public TerminalNode TEXTO(int i) {
			return getToken(IsiLangParser.TEXTO, i);
		}
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdSwitchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdSwitch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdSwitch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdSwitch(this);
		}
	}

	public final CmdSwitchContext cmdSwitch() throws RecognitionException {
		CmdSwitchContext _localctx = new CmdSwitchContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_cmdSwitch);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			match(T__11);
			setState(148);
			match(AP);
			setState(149);
			match(ID);
			 verificaID(_input.LT(-1).getText());
										 _varName = _input.LT(-1).getText();
								 	  	 _readID = _input.LT(-1).getText();
								 	  	 _tipo = symbolTable.get(_varName).getType();
								 	  	 CommandSwitch cmd = new CommandSwitch(_readID);
								 	   
			setState(151);
			match(FP);
			setState(152);
			match(AC);
			setState(171); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(153);
				match(T__12);
				setState(158);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case NUMBER:
					{
					setState(154);
					match(NUMBER);
					 if(_tipo != 0)
														 	throw new RuntimeException("Variable "+_varName+" type is TEXTO, but found NUMBER");
									 				   	  else
									 				   		cases = _input.LT(-1).getText();
									 				   	
					}
					break;
				case TEXTO:
					{
					setState(156);
					match(TEXTO);
					 if(_tipo != 1)
															throw new RuntimeException("Variable "+_varName+" type is NUMBER, but found TEXTO");
														  else
														  	cases = _input.LT(-1).getText();
									 					
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(160);
				match(T__13);
				 cases += _input.LT(-1).getText();
				 curThread = new ArrayList<AbstractCommand>();
							  		  	  	  stack.push(curThread);
							  		  	  	
				setState(164); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(163);
					cmd();
					}
					}
					setState(166); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__11) | (1L << T__16) | (1L << ID))) != 0) );

							  				  choice = stack.pop();
							  				  cmd.addCase(cases, choice);
							  				
				setState(169);
				match(T__14);
				}
				}
				setState(173); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__12 );
			 defaultChoice = null;
			setState(185);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__15) {
				{
				setState(176);
				match(T__15);
				 curThread = new ArrayList<AbstractCommand>();
							  	  			  stack.push(curThread);
							    			
				setState(179); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(178);
					cmd();
					}
					}
					setState(181); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__11) | (1L << T__16) | (1L << ID))) != 0) );

							  				  defaultChoice = stack.pop();
							  				
				}
			}

			 cmd.addDefault(defaultChoice);
						  			  stack.peek().add(cmd);
						  			
			setState(188);
			match(FC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdWhileContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public TerminalNode AC() { return getToken(IsiLangParser.AC, 0); }
		public TerminalNode FC() { return getToken(IsiLangParser.FC, 0); }
		public List<TerminalNode> OP_rel() { return getTokens(IsiLangParser.OP_rel); }
		public TerminalNode OP_rel(int i) {
			return getToken(IsiLangParser.OP_rel, i);
		}
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdWhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdWhile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdWhile(this);
		}
	}

	public final CmdWhileContext cmdWhile() throws RecognitionException {
		CmdWhileContext _localctx = new CmdWhileContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_cmdWhile);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			match(T__16);
			setState(191);
			match(AP);
			setState(192);
			expr();
			 _exprDecision = _input.LT(-1).getText(); 
			setState(199); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(194);
				match(OP_rel);
				 _exprDecision += _input.LT(-1).getText(); 
				setState(196);
				expr();
				 _exprDecision += _input.LT(-1).getText(); 
				}
				}
				setState(201); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==OP_rel );
			setState(203);
			match(FP);
			setState(204);
			match(AC);
			 curThread = new ArrayList<AbstractCommand>();
						  		  	   stack.push(curThread);
						  		  	 
			setState(207); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(206);
				cmd();
				}
				}
				setState(209); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__11) | (1L << T__16) | (1L << ID))) != 0) );
			setState(211);
			match(FC);

						  			   loop = stack.pop();
						  			   CommandRepeticao cmd = new CommandRepeticao(_exprDecision, loop);
						  		       stack.peek().add(cmd);
						  			 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdExprContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public TerminalNode END() { return getToken(IsiLangParser.END, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> TEXTO() { return getTokens(IsiLangParser.TEXTO); }
		public TerminalNode TEXTO(int i) {
			return getToken(IsiLangParser.TEXTO, i);
		}
		public CmdExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdExpr(this);
		}
	}

	public final CmdExprContext cmdExpr() throws RecognitionException {
		CmdExprContext _localctx = new CmdExprContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_cmdExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			match(ID);
			 verificaID(_input.LT(-1).getText());
							   _varName = _input.LT(-1).getText();
							   _exprID = _input.LT(-1).getText();
							   _tipo = symbolTable.get(_varName).getType();
							 
			setState(216);
			match(T__17);
			 _exprContent = "";
			setState(223); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(223);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ID:
				case NUMBER:
					{
					setState(218);
					expr();
					 if(_tipo != 0)
										throw new RuntimeException("Variable "+_varName+" type is TEXTO, but found NUMBER");
									 
					}
					break;
				case TEXTO:
					{
					setState(221);
					match(TEXTO);
					 if(_tipo != 1)
											throw new RuntimeException("Variable "+_varName+" type is NUMBER, but found TEXTO");
											else { _exprContent += _input.LT(-1).getText();}
									 	
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(225); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << NUMBER) | (1L << TEXTO))) != 0) );
			setState(227);
			match(END);

							CommandAtribuicao cmd = new CommandAtribuicao(_exprID, _exprContent);
						  	stack.peek().add(cmd);
						
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public List<TermoContext> termo() {
			return getRuleContexts(TermoContext.class);
		}
		public TermoContext termo(int i) {
			return getRuleContext(TermoContext.class,i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_expr);
		try {
			setState(241);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(230);
				termo();
				setState(231);
				match(T__18);
				 _exprContent += _input.LT(-1).getText();
				setState(233);
				termo();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(235);
				termo();
				setState(236);
				match(T__19);
				 _exprContent += _input.LT(-1).getText();
				setState(238);
				termo();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(240);
				termo();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermoContext extends ParserRuleContext {
		public List<FatorContext> fator() {
			return getRuleContexts(FatorContext.class);
		}
		public FatorContext fator(int i) {
			return getRuleContext(FatorContext.class,i);
		}
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterTermo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitTermo(this);
		}
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_termo);
		try {
			setState(254);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(243);
				fator();
				setState(244);
				match(T__20);
				 _exprContent += _input.LT(-1).getText();
				setState(246);
				fator();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(248);
				fator();
				setState(249);
				match(T__21);
				 _exprContent += _input.LT(-1).getText();
				setState(251);
				fator();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(253);
				fator();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FatorContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(IsiLangParser.NUMBER, 0); }
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public FatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterFator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitFator(this);
		}
	}

	public final FatorContext fator() throws RecognitionException {
		FatorContext _localctx = new FatorContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_fator);
		try {
			setState(260);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(256);
				match(NUMBER);
				 _exprContent += _input.LT(-1).getText();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(258);
				match(ID);
				 verificaID(_input.LT(-1).getText());
								   _exprContent += _input.LT(-1).getText();
								 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3#\u0109\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\3\6\3(\n\3\r\3\16\3)\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4\63\n\4\f\4"+
		"\16\4\66\13\4\3\4\3\4\3\5\3\5\3\5\3\5\5\5>\n\5\3\6\3\6\6\6B\n\6\r\6\16"+
		"\6C\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\5\7X\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\5\th\n\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\6"+
		"\nx\n\n\r\n\16\ny\3\n\3\n\3\n\3\n\3\n\6\n\u0081\n\n\r\n\16\n\u0082\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\6\n\u008b\n\n\r\n\16\n\u008c\3\n\3\n\3\n\5\n\u0092"+
		"\n\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5"+
		"\13\u00a1\n\13\3\13\3\13\3\13\3\13\6\13\u00a7\n\13\r\13\16\13\u00a8\3"+
		"\13\3\13\3\13\6\13\u00ae\n\13\r\13\16\13\u00af\3\13\3\13\3\13\3\13\6\13"+
		"\u00b6\n\13\r\13\16\13\u00b7\3\13\3\13\5\13\u00bc\n\13\3\13\3\13\3\13"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\6\f\u00ca\n\f\r\f\16\f\u00cb\3\f"+
		"\3\f\3\f\3\f\6\f\u00d2\n\f\r\f\16\f\u00d3\3\f\3\f\3\f\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\6\r\u00e2\n\r\r\r\16\r\u00e3\3\r\3\r\3\r\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00f4\n\16\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u0101\n\17\3\20\3\20"+
		"\3\20\3\20\5\20\u0107\n\20\3\20\2\2\21\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36\2\2\2\u0115\2 \3\2\2\2\4\'\3\2\2\2\6+\3\2\2\2\b=\3\2\2\2\n?\3\2"+
		"\2\2\fW\3\2\2\2\16Y\3\2\2\2\20a\3\2\2\2\22m\3\2\2\2\24\u0095\3\2\2\2\26"+
		"\u00c0\3\2\2\2\30\u00d8\3\2\2\2\32\u00f3\3\2\2\2\34\u0100\3\2\2\2\36\u0106"+
		"\3\2\2\2 !\7\3\2\2!\"\5\4\3\2\"#\5\n\6\2#$\7\4\2\2$%\b\2\1\2%\3\3\2\2"+
		"\2&(\5\6\4\2\'&\3\2\2\2()\3\2\2\2)\'\3\2\2\2)*\3\2\2\2*\5\3\2\2\2+,\7"+
		"\5\2\2,-\5\b\5\2-.\7 \2\2.\64\b\4\1\2/\60\7\6\2\2\60\61\7 \2\2\61\63\b"+
		"\4\1\2\62/\3\2\2\2\63\66\3\2\2\2\64\62\3\2\2\2\64\65\3\2\2\2\65\67\3\2"+
		"\2\2\66\64\3\2\2\2\678\7\36\2\28\7\3\2\2\29:\7\7\2\2:>\b\5\1\2;<\7\b\2"+
		"\2<>\b\5\1\2=9\3\2\2\2=;\3\2\2\2>\t\3\2\2\2?A\b\6\1\2@B\5\f\7\2A@\3\2"+
		"\2\2BC\3\2\2\2CA\3\2\2\2CD\3\2\2\2D\13\3\2\2\2EF\5\16\b\2FG\b\7\1\2GX"+
		"\3\2\2\2HI\5\20\t\2IJ\b\7\1\2JX\3\2\2\2KL\5\22\n\2LM\b\7\1\2MX\3\2\2\2"+
		"NO\5\24\13\2OP\b\7\1\2PX\3\2\2\2QR\5\26\f\2RS\b\7\1\2SX\3\2\2\2TU\5\30"+
		"\r\2UV\b\7\1\2VX\3\2\2\2WE\3\2\2\2WH\3\2\2\2WK\3\2\2\2WN\3\2\2\2WQ\3\2"+
		"\2\2WT\3\2\2\2X\r\3\2\2\2YZ\7\t\2\2Z[\7\32\2\2[\\\7 \2\2\\]\b\b\1\2]^"+
		"\7\33\2\2^_\7\36\2\2_`\b\b\1\2`\17\3\2\2\2ab\7\n\2\2bg\7\32\2\2cd\7\""+
		"\2\2dh\b\t\1\2ef\7 \2\2fh\b\t\1\2gc\3\2\2\2ge\3\2\2\2hi\3\2\2\2ij\7\33"+
		"\2\2jk\7\36\2\2kl\b\t\1\2l\21\3\2\2\2mn\7\13\2\2no\7\32\2\2op\b\n\1\2"+
		"pq\5\32\16\2qw\b\n\1\2rs\7\31\2\2st\b\n\1\2tu\5\32\16\2uv\b\n\1\2vx\3"+
		"\2\2\2wr\3\2\2\2xy\3\2\2\2yw\3\2\2\2yz\3\2\2\2z{\3\2\2\2{|\7\33\2\2|}"+
		"\7\f\2\2}~\7\34\2\2~\u0080\b\n\1\2\177\u0081\5\f\7\2\u0080\177\3\2\2\2"+
		"\u0081\u0082\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0084"+
		"\3\2\2\2\u0084\u0085\7\35\2\2\u0085\u0091\b\n\1\2\u0086\u0087\7\r\2\2"+
		"\u0087\u0088\7\34\2\2\u0088\u008a\b\n\1\2\u0089\u008b\5\f\7\2\u008a\u0089"+
		"\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d"+
		"\u008e\3\2\2\2\u008e\u008f\7\35\2\2\u008f\u0090\b\n\1\2\u0090\u0092\3"+
		"\2\2\2\u0091\u0086\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0093\3\2\2\2\u0093"+
		"\u0094\b\n\1\2\u0094\23\3\2\2\2\u0095\u0096\7\16\2\2\u0096\u0097\7\32"+
		"\2\2\u0097\u0098\7 \2\2\u0098\u0099\b\13\1\2\u0099\u009a\7\33\2\2\u009a"+
		"\u00ad\7\34\2\2\u009b\u00a0\7\17\2\2\u009c\u009d\7!\2\2\u009d\u00a1\b"+
		"\13\1\2\u009e\u009f\7\"\2\2\u009f\u00a1\b\13\1\2\u00a0\u009c\3\2\2\2\u00a0"+
		"\u009e\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a3\7\20\2\2\u00a3\u00a4\b"+
		"\13\1\2\u00a4\u00a6\b\13\1\2\u00a5\u00a7\5\f\7\2\u00a6\u00a5\3\2\2\2\u00a7"+
		"\u00a8\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00aa\3\2"+
		"\2\2\u00aa\u00ab\b\13\1\2\u00ab\u00ac\7\21\2\2\u00ac\u00ae\3\2\2\2\u00ad"+
		"\u009b\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0\3\2"+
		"\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00bb\b\13\1\2\u00b2\u00b3\7\22\2\2\u00b3"+
		"\u00b5\b\13\1\2\u00b4\u00b6\5\f\7\2\u00b5\u00b4\3\2\2\2\u00b6\u00b7\3"+
		"\2\2\2\u00b7\u00b5\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9"+
		"\u00ba\b\13\1\2\u00ba\u00bc\3\2\2\2\u00bb\u00b2\3\2\2\2\u00bb\u00bc\3"+
		"\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00be\b\13\1\2\u00be\u00bf\7\35\2\2\u00bf"+
		"\25\3\2\2\2\u00c0\u00c1\7\23\2\2\u00c1\u00c2\7\32\2\2\u00c2\u00c3\5\32"+
		"\16\2\u00c3\u00c9\b\f\1\2\u00c4\u00c5\7\31\2\2\u00c5\u00c6\b\f\1\2\u00c6"+
		"\u00c7\5\32\16\2\u00c7\u00c8\b\f\1\2\u00c8\u00ca\3\2\2\2\u00c9\u00c4\3"+
		"\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc"+
		"\u00cd\3\2\2\2\u00cd\u00ce\7\33\2\2\u00ce\u00cf\7\34\2\2\u00cf\u00d1\b"+
		"\f\1\2\u00d0\u00d2\5\f\7\2\u00d1\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3"+
		"\u00d1\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d6\7\35"+
		"\2\2\u00d6\u00d7\b\f\1\2\u00d7\27\3\2\2\2\u00d8\u00d9\7 \2\2\u00d9\u00da"+
		"\b\r\1\2\u00da\u00db\7\24\2\2\u00db\u00e1\b\r\1\2\u00dc\u00dd\5\32\16"+
		"\2\u00dd\u00de\b\r\1\2\u00de\u00e2\3\2\2\2\u00df\u00e0\7\"\2\2\u00e0\u00e2"+
		"\b\r\1\2\u00e1\u00dc\3\2\2\2\u00e1\u00df\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3"+
		"\u00e1\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e6\7\36"+
		"\2\2\u00e6\u00e7\b\r\1\2\u00e7\31\3\2\2\2\u00e8\u00e9\5\34\17\2\u00e9"+
		"\u00ea\7\25\2\2\u00ea\u00eb\b\16\1\2\u00eb\u00ec\5\34\17\2\u00ec\u00f4"+
		"\3\2\2\2\u00ed\u00ee\5\34\17\2\u00ee\u00ef\7\26\2\2\u00ef\u00f0\b\16\1"+
		"\2\u00f0\u00f1\5\34\17\2\u00f1\u00f4\3\2\2\2\u00f2\u00f4\5\34\17\2\u00f3"+
		"\u00e8\3\2\2\2\u00f3\u00ed\3\2\2\2\u00f3\u00f2\3\2\2\2\u00f4\33\3\2\2"+
		"\2\u00f5\u00f6\5\36\20\2\u00f6\u00f7\7\27\2\2\u00f7\u00f8\b\17\1\2\u00f8"+
		"\u00f9\5\36\20\2\u00f9\u0101\3\2\2\2\u00fa\u00fb\5\36\20\2\u00fb\u00fc"+
		"\7\30\2\2\u00fc\u00fd\b\17\1\2\u00fd\u00fe\5\36\20\2\u00fe\u0101\3\2\2"+
		"\2\u00ff\u0101\5\36\20\2\u0100\u00f5\3\2\2\2\u0100\u00fa\3\2\2\2\u0100"+
		"\u00ff\3\2\2\2\u0101\35\3\2\2\2\u0102\u0103\7!\2\2\u0103\u0107\b\20\1"+
		"\2\u0104\u0105\7 \2\2\u0105\u0107\b\20\1\2\u0106\u0102\3\2\2\2\u0106\u0104"+
		"\3\2\2\2\u0107\37\3\2\2\2\30)\64=CWgy\u0082\u008c\u0091\u00a0\u00a8\u00af"+
		"\u00b7\u00bb\u00cb\u00d3\u00e1\u00e3\u00f3\u0100\u0106";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}