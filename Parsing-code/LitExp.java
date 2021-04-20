
/**
 * Expression for integer literal
 * 
 * 
 *
 */
public class LitExp extends Exp {
	private Integer value;

	/**
	 * Constructor for LitExp
	 * @param value integer value of literal expression
	 */
	public LitExp(Integer value) {
		this.value = value;
	}

	@Override
	public String show() {
		return value.toString();
	}

	/**
	 * Evaluated value of the LitExp is the value itself
	 */
	@Override
	public int evaluate(){
		return value;
	}

}
