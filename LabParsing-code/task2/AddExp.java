/**
 * AddExp: it is extended from the abstract class Exp.
 *         This class is used to represent the expression of addition
 *
 * You are not required to implement any function inside this class.
 * Please do not change anything inside this class as well.
 */

public class AddExp extends Exp {
	
	private Exp term;
	private Exp exp;
	
	public AddExp(Exp term, Exp exp) {
		this.term = term;
		this.exp = exp;
	}

	@Override
	public String show() {
		return "(" + term.show() + " + " + exp.show() + ")";
	}

	@Override
	public int evaluate() {
		return (term.evaluate() + exp.evaluate());
	}
}