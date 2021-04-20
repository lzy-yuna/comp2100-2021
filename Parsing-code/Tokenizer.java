/**
 * Tokenizer - this uses the StreamTokenizer class to make a simpler tokenizer
 * which provides a stream of tokens which are either Integer, Double, or
 * String.
 * 
 * 
 */

public abstract class Tokenizer {

	/**
	 * check whether there is a next token in the remaining text
	 * @return
	 */
	public abstract boolean hasNext();

	/**
	 * return the current token
	 * @return the current token
	 */
	public abstract Object current();

	/**
	 *  extract next token from the current text and save it
	 */
	public abstract void next();

}
