/**
 * SubExp: it is extended from the abstract class Exp,
 * 		    This class is used to represent the expression of subtraction
 *
 * Please do not change anything else.
 */

public class SubExp extends Exp {
	
	private Exp term;
	private Exp exp;
	
	public SubExp(Exp term, Exp exp) {
		this.term = term;
		this.exp = exp;
	}

	@Override
	public String show() {
		return "(" + term.show() + " - " + exp.show() + ")";
	}

	@Override
	public int evaluate() {
		return (term.evaluate() - exp.evaluate());
	}
}
