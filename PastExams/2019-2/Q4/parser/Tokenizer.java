package parser;
/**
 * IMPORTANT: This class is incomplete. Please look for "TODO" comments.
 * 
 * 
 */
public class Tokenizer {
    private String _buffer;
    private final char COMMAND_SEPARATOR = ';'; 
    private Token current;
    
    public Tokenizer(String buffer) {
        this._buffer = buffer;
        this.next();
    }
    
    /**
     *  Extract the next token from {@code _buffer}
     */
    public void next() {
        _buffer = _buffer.trim();
        if (_buffer.isEmpty()) {
            current = null;
        	return;
        }
        
        if (_buffer.startsWith(Token.Type.LEFT.toString())) 
            current = new Token(Token.Type.LEFT);
        
        if (_buffer.startsWith(Token.Type.RIGHT.toString())) 
            current = new Token(Token.Type.RIGHT);
        
        // TODO: Implement "FORWARD_TO_END" and "BACK_TO_END" tokenization.
        // TODO: Implement "FORWARD" and "BACK" tokenization.
        // TODO: Implement "PENUP" and "PENDOWN" tokenization.        
        // hints:
        // - Do not consider the case where text is syntactically incorrect.        
        // - Careful if you use String.startsWith. FORWARD_TO_END and FORWARD starts with
        //   the same string "FORWARD". Same for the BACK cases.
        // - Character.isDigit() may be useful in extracting the forward or back value from the buffer.
        // - Use new Token(<type>, <original token str>, <value>) to return these tokens
        // - Check the expected outcome in TokenizerTest.java
        if (_buffer.startsWith(Token.Type.PENUP.toString()))
            current = new Token(Token.Type.PENUP);

        else if (_buffer.startsWith(Token.Type.PENDOWN.toString()))
            current = new Token(Token.Type.PENDOWN);

        else if (_buffer.startsWith(Token.Type.FORWARD_TO_END.toString()))
            current = new Token(Token.Type.FORWARD_TO_END);

        else if (_buffer.startsWith(Token.Type.BACK_TO_END.toString()))
            current = new Token(Token.Type.BACK_TO_END);

        else if (_buffer.startsWith(Token.Type.FORWARD.toString())) {
            int start_index = 0;
            while (!Character.isDigit(_buffer.charAt(start_index))) {
                start_index++;
            }
            int end_index = start_index;
            while (Character.isDigit(_buffer.charAt(end_index))) {
                end_index++;
            }
            int value = Integer.parseInt(_buffer.substring(start_index, end_index));
            current = new Token(Token.Type.FORWARD, _buffer.substring(0, end_index + 1), value);
        }

        else if (_buffer.startsWith(Token.Type.BACK.toString())) {
            int start_index = 0;
            while (!Character.isDigit(_buffer.charAt(start_index))) {
                start_index++;
            }
            int end_index = start_index;
            while (Character.isDigit(_buffer.charAt(end_index))) {
                end_index++;
            }
            int value = Integer.parseInt(_buffer.substring(start_index, end_index));
            current = new Token(Token.Type.BACK, _buffer.substring(0, end_index + 1), value);
        }

        _buffer = _buffer.substring(current.originalTokenStr.length() + 1);

    }
    

    /**
     * Return the token in {@code _current}
     * @return the next token
     */
    public Token current() {
        return current;
    }

    /**
     * @return whether there is another token in {@code _current}
     */
    public boolean hasNext() {
        if(current == null){
            return false;
        }
        return true;
    }

}