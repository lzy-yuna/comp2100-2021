
/**
 * Parser for grammar:
 * 
 * <exp> ::= <term> | <term> + <exp>
 * <term> ::= <factor> | <factor> * <term>
 * <factor> ::= <lit>
 *  
 * 
 *
 */
public class Parser {
	
	/**
	 * Parser for <exp>.
	 * <exp> has two production rules: <term> | <term> + <exp>
	 * If there's + token after parsing term, the parser return an addition expression
	 * otherwise it returns parsed term.
	 * 
	 * @param tok Tokenizer
	 * @return parsed expression for <exp>
	 */
	public static Exp parseExp(Tokenizer tok) {
		Exp term = parseTerm(tok);
		
		if(tok.hasNext() && tok.current().equals("+")) {
			tok.next();
			Exp exp = parseExp(tok);
			return new AddExp(term, exp);
		}else {
			return term;
		}
	}
	
	/**
	 * Parser for <term>.
	 * <term> has two production rules: <factor> | <factor> * <term>
	 * If there's * token after parsing factor, the parser return a multiplication expression
	 * otherwise it returns parsed factor.
	 * 
	 * @param tok Tokenizer
	 * @return parsed expression for <term>
	 */
	public static Exp parseTerm(Tokenizer tok) {
		Exp factor = parseFactor(tok);
		
		if (tok.hasNext() && tok.current().equals("*")) {
			tok.next();
			Exp term = parseTerm(tok);
			return new MultExp(factor, term);
		}else {
			return factor;
		}
	}

	/**
	 * Parser for <factor>
	 * Note that <factor> has a single production rule.
	 * It always return integer literal as a parsed result.
	 * 
	 * @param tok Tokenizer
	 * @return parsed expression for <factor>
	 */
	private static Exp parseFactor(Tokenizer tok) {
		Exp lit = new LitExp((Integer)tok.current());
		tok.next();
		return lit;		
	}

}
