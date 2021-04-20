/**
 * Class for a multiplication expression <factor> * <term>.
 * Note that the first argument of this expression is <factor>,
 * and the second argument is <term> 
 * 
 * 
 *
 */
public class MultExp extends Exp {
	private Exp factor;
	private Exp term;

	/**
	 * Constructor for multiplication expression
	 * 
	 * @param factor the first argument
	 * @param term the second argument
	 */
	public MultExp(Exp factor, Exp term) {
		this.factor = factor;
		this.term = term;
	}

	@Override
	public String show() {
		return "(" + factor.show() + " * " + term.show() + ")";
	}

	/**
	 * Returns a multiplication result of <factor> and <term>
	 * Each of <factor> and <term> can be evaluated by their evaluate function.
	 */
	@Override
	public int evaluate(){
		return factor.evaluate() * term.evaluate();
	}

}
