/**
 * Name: Parser.java
 *
 *  The main objective of this class is to implement a simple parser.
 *  It should be able to parser the following grammar rule:
 *  <exp>    ::= <term> | <term> + <exp> | <term> - <exp>
 *  <term>   ::=  <factor> | <factor> * <term> | <factor> / <term>
 *  <factor> ::= <unsigned integer> | ( <exp> )
 *
 * The given code is provided to assist you to complete the required tasks. But the 
 * given code is often incomplete. You have to read and understand the given code 
 * carefully, before you can apply the code properly. You might need to implement 
 * additional procedures, such as error checking and handling, in order to apply the 
 * code properly.
 */

public class Parser {

    MyTokenizer _tokenizer;

    public Parser(MyTokenizer tokenizer) {
        _tokenizer = tokenizer;
    }

    /*
    <exp>    ::= <term> | <term> + <exp> | <term> - <exp>
     */
    public Exp parseExp() {
        // TODO: Implement parse function for <exp>
        // ########## YOUR CODE STARTS HERE ##########
        Exp term = parseTerm();
        if (_tokenizer.hasNext()) {
            if (_tokenizer.current().type().equals(Token.Type.ADD)) {
                _tokenizer.next();
                Exp exp = parseExp();
                return new AddExp(term, exp);
            } else if (_tokenizer.current().type().equals(Token.Type.SUB)) {
                _tokenizer.next();
                Exp exp = parseExp();
                return new SubExp(term, exp);
            } else {
                return term;
            }
        } else {
            return term;
        }
        // ########## YOUR CODE ENDS HERE ##########
    }

    //<term>   ::=  <factor> | <factor> * <term> | <factor> / <term>
    public Exp parseTerm() {
        // TODO: Implement parse function for <term>
        // ########## YOUR CODE STARTS HERE ##########
    	Exp factor = parseFactor();
		if (_tokenizer.hasNext()) {
            if (_tokenizer.current().type().equals(Token.Type.MUL)) {
                _tokenizer.next();
                Exp term = parseTerm();
                return new MultExp(factor, term);
            } else if (_tokenizer.current().type().equals(Token.Type.DIV)) {
                _tokenizer.next();
                Exp term = parseTerm();
                return new DivExp(factor, term);
            } else {
                return factor;
            }
        } else {
		    return factor;
        }
        // ########## YOUR CODE ENDS HERE ##########
    }
    
    //<factor> ::= <unsigned integer> | ( <exp> )
    public Exp parseFactor() {
        // TODO: Implement parse function for <factor>
        // ########## YOUR CODE STARTS HERE ##########
        if (_tokenizer.current().type().equals(Token.Type.LBRA)) {
            _tokenizer.next();
            Exp exp = parseExp();
            _tokenizer.next();
            return exp;
        } else {
            IntExp rtn = new IntExp(Integer.parseInt(_tokenizer.current().token()));
            _tokenizer.next();
            return rtn;
        }

        // ########## YOUR CODE ENDS HERE ##########
    }

    public static void main(String[] args) {
        MyTokenizer mathTokenizer = new MyTokenizer("2+1");
        Exp t1 = new Parser(mathTokenizer).parseExp();
        System.out.println(t1.show());
        System.out.println(t1.evaluate());
    }
}
