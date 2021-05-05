package parser;
/**
 * IMPORTANT: This class is incomplete. Please look for "TODO" comments.
 * 
 * 
 */
public class Parser {
	private Tokenizer _tokenizer;
	private Screen _screen;

	public Parser(Tokenizer tokenizer, Screen screen) {
		_tokenizer = tokenizer;
		_screen = screen;
	}

    /**
     * This should parse all the tokens, turn the pointer and mark its visited positions for
     * every move.
     *
     * If there is no more token, this should return the current screen
     *
     * @return a screen object containing pointer's trace information.
     * @throws Exception
     */
    public Screen parse() throws OutOfScreenException {
		// TODO: Add your implementation here.
		// Hints: Check {@link Screen} and {@link Pointer} classes to see 
    	//        there is any methods/functions you can take advantage of.
    	//        Check the expected outcome in ParserTest.java
    	//        You can make additional methods if needed
		if (_tokenizer.hasNext()) {
			Token next_Command = _tokenizer.current();

			if (next_Command.type == Token.Type.RIGHT) {
				_screen.pointer.turnRight();
			}

			if (next_Command.type == Token.Type.LEFT) {
				_screen.pointer.turnLeft();
			}

			if (next_Command.type == Token.Type.PENDOWN) {
				_screen.pointer.isPenDown = true;
				_screen.markVisistedPos(_screen.pointer.position);
			}

			if (next_Command.type == Token.Type.PENUP) {
				_screen.pointer.isPenDown = false;
			}

			if (next_Command.type == Token.Type.FORWARD) {
				if (_screen.pointer.isPenDown) {
					for (int i = 0; i < next_Command.value; i++) {
						if (shouldContinue(true)) {
							switch (_screen.pointer.direction) {
								case NORTH -> _screen.pointer.position.x--;
								case EAST -> _screen.pointer.position.y++;
								case SOUTH -> _screen.pointer.position.x++;
								case WEST -> _screen.pointer.position.y--;
							}
							_screen.markVisistedPos(_screen.pointer.position);
						}
					}
				} else {
					for (int i = 0; i < next_Command.value; i++) {
						if (shouldContinue(true)) {
							switch (_screen.pointer.direction) {
								case NORTH -> _screen.pointer.position.x--;
								case EAST -> _screen.pointer.position.y++;
								case SOUTH -> _screen.pointer.position.x++;
								case WEST -> _screen.pointer.position.y--;
							}
						}
					}
				}
			}

			if (next_Command.type == Token.Type.BACK) {
				if (_screen.pointer.isPenDown) {
					for (int i = 0; i < next_Command.value; i++) {
						if (shouldContinue(false)) {
							switch (_screen.pointer.direction) {
								case NORTH -> _screen.pointer.position.x++;
								case EAST -> _screen.pointer.position.y--;
								case SOUTH -> _screen.pointer.position.x--;
								case WEST -> _screen.pointer.position.y++;
							}
							_screen.markVisistedPos(_screen.pointer.position);
						}
					}
				} else {
					for (int i = 0; i < next_Command.value; i++) {
						if (shouldContinue(false)) {
							switch (_screen.pointer.direction) {
								case NORTH -> _screen.pointer.position.x++;
								case EAST -> _screen.pointer.position.y--;
								case SOUTH -> _screen.pointer.position.x--;
								case WEST -> _screen.pointer.position.y++;
							}
						}
					}
				}
			}

			if (next_Command.type == Token.Type.FORWARD_TO_END) {
				int step = 0;
				switch (_screen.pointer.direction) {
					case NORTH -> step = _screen.pointer.position.x;
					case EAST -> step = _screen.noOfColumns - _screen.pointer.position.y;
					case SOUTH -> step = _screen.noOfRows - _screen.pointer.position.x;
					case WEST ->  step = _screen.pointer.position.y;
				}
				for (int i = 0 ; i < step; i++) {
					if (shouldContinue(true)) {
						switch (_screen.pointer.direction) {
							case NORTH -> _screen.pointer.position.x--;
							case EAST -> _screen.pointer.position.y++;
							case SOUTH -> _screen.pointer.position.x++;
							case WEST -> _screen.pointer.position.y--;
						}
						if (_screen.pointer.isPenDown) {
							_screen.markVisistedPos(_screen.pointer.position);
						}
					}
				}
			}

			if (next_Command.type == Token.Type.BACK_TO_END) {
				int step = 0;
				switch (_screen.pointer.direction) {
					case NORTH -> step = _screen.noOfRows - _screen.pointer.position.x;
					case EAST -> step = _screen.pointer.position.y;
					case SOUTH -> step = _screen.pointer.position.x;
					case WEST ->  step = _screen.noOfColumns - _screen.pointer.position.y;
				}
				for (int i = 0 ; i < step; i++) {
					if (shouldContinue(false)) {
						switch (_screen.pointer.direction) {
							case NORTH -> _screen.pointer.position.x++;
							case EAST -> _screen.pointer.position.y--;
							case SOUTH -> _screen.pointer.position.x--;
							case WEST -> _screen.pointer.position.y++;
						}
						if (_screen.pointer.isPenDown) {
							_screen.markVisistedPos(_screen.pointer.position);
						}
					}
				}
			}

			_tokenizer.next();
			parse();

			return _screen;
		} else {
			return null;
		}
	}

	private boolean shouldContinue(boolean isForward) {
    	int currentX = _screen.pointer.position.x;
    	int currentY = _screen.pointer.position.y;
		if (isForward) {
			switch (_screen.pointer.direction) {
				case NORTH -> currentX--;
				case EAST -> currentY++;
				case SOUTH -> currentX++;
				case WEST -> currentY--;
			}
		} else {
			switch (_screen.pointer.direction) {
				case NORTH -> currentX++;
				case EAST -> currentY--;
				case SOUTH -> currentX--;
				case WEST -> currentY++;
			}
		}
    	return currentX >= 0 && currentY >= 0 &&
				currentX < _screen.noOfRows && currentY < _screen.noOfColumns;
	}
}
