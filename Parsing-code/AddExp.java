
/**
 * Expression for addition <term> + <exp>
 * Note that the first argument of this expression is <term> 
 * and the second expression in addtion is <exp>
 * 
 */
public class AddExp extends Exp {
	private Exp term;
	private Exp exp;

	/**
	 * Constructor for an addition expression.
	 * 
	 * @param the term first term in addition expression
	 * @param the exp second term in addition expression
	 */
	public AddExp(Exp term, Exp exp) {
		this.term = term;
		this.exp = exp;
	}

	@Override
	public String show() {
		return "(" + term.show() + " + " + exp.show() + ")";
	}

	/**
	 * Returns a sum of <term> and <exp>
	 * Each of <term> and <exp> can be evaluated by their evaluate function.
	 */
	@Override
	public int evaluate(){
		return term.evaluate() + exp.evaluate();
	}

}
