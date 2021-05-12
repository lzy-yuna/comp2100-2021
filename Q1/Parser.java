/**
 * IMPORTANT: This class is incomplete. Please look for "TODO" comments.
 *
 * Question:
 * Write a parse to recognize the language specified by the following grammar:
 * S := () ; S := )S( ; S := SS ;
 *
 */
public class Parser {

    Tokeniser _tokeniser;
    
    public Parser(Tokeniser tokeniser) {
    	_tokeniser = tokeniser;
    }

	/**
	 * @return True if the given tokens conform with the grammar. False, otherwise.
	 */
	public boolean parseExp() {
		if (!_tokeniser.isNextValid()) return false;
		if (!_tokeniser.hasNext()) {
			return true;
		}

        // TODO: Complete this method
		// START YOUR CODE

		// For the above Grammar, it is ambiguous
		// We can convert it into: S := ()A | )S(A | () | )S( ; A := SA
		// which is equivalent to S := ()A | )S(A ; A := SA | ε
		Token.Type nextType = _tokeniser.takeNext().type;

		if (nextType == Token.Type.LEFT_BRACKET) {
			if (_tokeniser.hasNext()) {
				return _tokeniser.takeNext().type == Token.Type.RIGHT_BRACKET && parseA();
			} else {
				return false;
			}
		}

		if (nextType == Token.Type.RIGHT_BRACKET) {
			if (_tokeniser.hasNext()) {
				return parseExp() && _tokeniser.takeNext().type == Token.Type.LEFT_BRACKET && parseA();
			} else {
				return false;
			}
		}

		// END YOUR CODE
		return false;
    }

	/**
	 * Parser for A
	 * @return whether the text in tokenizer is valid
	 */
	private boolean parseA() {
		if (!_tokeniser.isNextValid()) return false;
		if (!_tokeniser.hasNext()) return true;

		return parseExp() && parseA();
	}

}
