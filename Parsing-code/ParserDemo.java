
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
public class ParserDemo {

	final static String exp = "3+4*7+5+6*2";
	
	public static void main(String[] args) {
		Tokenizer tok = new MySimpleTokenizer(exp);
		
		Exp parsedExp = Parser.parseExp(tok);
		
		System.out.println(parsedExp.show());
		System.out.println(parsedExp.evaluate());
	}
}
