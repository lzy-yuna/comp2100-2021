/**
 * MultExp: it is extended from the abstract class Exp,
 * 		    This class is used to represent the expression of multiplication
 *
 * You are not required to implement any function inside this class.
 * Please do not change anything inside this class as well.
 */

public class MultExp extends Exp {
	
	private Exp factor;
	private Exp term;
	
	public MultExp(Exp factor, Exp term) {
		this.factor = factor;
		this.term = term;
	}

	@Override
	public String show() {
		return "(" + factor.show() + " * " + term.show() + ")";
	}

	@Override
	public int evaluate() {
		return (factor.evaluate() * term.evaluate());
	}
}