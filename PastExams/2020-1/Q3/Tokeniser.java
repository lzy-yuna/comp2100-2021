/**
 * IMPORTANT: This class is incomplete. Please look for "TODO" comments.
 * 
 * Implement next() method in Tokeniser.java to extract the SQL commands as Tokens as follows:
 * 
 * Token 1:
 * originalTokenStr: INSERT INTO table_name (column1, column2, column3, ...)
 * type: INSERT_INTO
 * value: table_name (column1, column2, column3, ...)
 * 
 * Token 2:
 * originalTokenStr: VALUES (value1, value2, value3, ...)
 * type: VALUES
 * value: (value1, value2, value3, ...)
 * 
 * Some brackets in the SQL commands may be missing. Please return null if some brackets are missing
 *
 * Please see test cases in TokeniserTest.java.
 */
public class Tokeniser {
	private String _buffer;

	public Tokeniser(String buffer) {
		this._buffer = buffer;
		int idx = this._buffer.indexOf(";");
		if (idx > 0) {
			this._buffer = this._buffer.substring(0, idx);
		}
	}

	/**
	 * Return the next token without changing the buffer
	 * 
	 * @return the next token OR null when there is no more token or the next token
	 *         is invalid.
	 */
	public Token next() {
		if (_buffer.isEmpty())
			return null;

		// TODO: Complete this method
		// START YOUR CODE
		int charStart = 0;
		boolean bracketL = false;
		boolean bracketR = false;

		if (_buffer.startsWith("INSERT INTO")) {
			while (charStart < _buffer.length() && !bracketR) {
				if (_buffer.charAt(charStart) == ')') {
					bracketR = true;
				}

				if (_buffer.charAt(charStart) == '(') {
					bracketL = true;
				}
				charStart++;
			}
			if (charStart == _buffer.length() - 1 || !bracketL || !bracketR)
				return null;
			else {
				String originalString = _buffer.substring(0, charStart);
				String insertToValues = _buffer.substring(Token.Type.INSERT_INTO.toString().length() + 1, charStart);
				return new Token(Token.Type.INSERT_INTO, insertToValues, originalString);
			}
		}

		else if (_buffer.startsWith("VALUES")) {
			while (charStart < _buffer.length() && !bracketR) {
				if (_buffer.charAt(charStart) == ')') {
					bracketR = true;
				}

				if (_buffer.charAt(charStart) == '(') {
					bracketL = true;
				}
				charStart++;
			}
			if (charStart == _buffer.length() - 1 || !bracketL || !bracketR)
				return null;
			else {
				String originalString = _buffer.substring(0, charStart);
				String insertToValues = _buffer.substring(Token.Type.VALUES.toString().length() + 1, charStart);
				return new Token(Token.Type.VALUES, insertToValues, originalString);
			}
		}
	

		// You are allowed to remove the following 'return null' if necessary
		return null;
		
		// END YOUR CODE
	}

	/**
	 * Return the next token and remove it from the buffer
	 * 
	 * @return the next token OR null when there is no more token or the next token
	 *         is invalid.
	 */
	public Token takeNext() {
		Token nextToken = next();
		if (nextToken == null)
			return null;

		if (nextToken.originalTokenStr.length() < _buffer.length()) {
			_buffer = _buffer.substring(nextToken.originalTokenStr.length()).trim();
		} else {
			_buffer = "";
		}

		return nextToken;
	}

	/**
	 * @return whether there is another token to parse in the buffer
	 */
	public boolean hasNext() {
		return next() != null;
	}
}