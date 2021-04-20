/**
 * MySimpleTokenizer - this tokenizer uses some simple check to break up the
 * tokens the text with predefined symbols. 
 * The Integer and Double parsers are used to parse numbers.
 * 
 */

public class MySimpleTokenizer extends Tokenizer {
	private String text;
	private int pos;
	private Object current;

	static final char whitespace[] = { ' ', '\n', '\t' };
	static final char symbol[] = { '*', '+', '(', ')', ';'};

	public MySimpleTokenizer(String text) {
		this.text = text;
		this.pos = 0;
		next();
	}

	public boolean hasNext() {
		return current != null;
	}

	public Object current() {
		return current;
	}

	/**
	 * Extract next token starting from the current position {@code pos}.
	 * The extracted token is saved in {@code self.current}.
	 */
	public void next() {
		consumewhite();
		if (pos == text.length()) {
			current = null;

		} else if (isin(text.charAt(pos), symbol)) {
			current = "" + text.charAt(pos);
			pos++;

		} else if (Character.isDigit(text.charAt(pos))) {
			int start = pos;
			while (pos < text.length() && Character.isDigit(text.charAt(pos)) )
				pos++;
			
			// check period in a sequence. Note that valid double has only single period in a seq
			if (pos+1 < text.length() && text.charAt(pos) == '.' &&
					Character.isDigit(text.charAt(pos+1))) {
				pos++;
				while (pos < text.length() && Character.isDigit(text.charAt(pos)))
					pos++;
				current = Double.parseDouble(text.substring(start, pos));
			} else {
			    current = Integer.parseInt(text.substring(start, pos));
			}

		} else {
			// parse string
			int start = pos;
			while (pos < text.length() && !isin(text.charAt(pos), symbol)
					&& !isin(text.charAt(pos), whitespace))
				pos++;
			current = text.substring(start, pos);
		}
	}

	/**
	 * Remove white space in a sequence until there's no whitespace in the current position
	 */
	private void consumewhite() {
		while (pos < text.length() && isin(text.charAt(pos), whitespace))
			pos++;
	}

	private boolean isin(char c, char charlist[]) {
		for (char w : charlist) {
			if (w == c)
				return true;
		}
		return false;
	}
}
