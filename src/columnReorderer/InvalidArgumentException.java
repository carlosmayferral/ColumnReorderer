package columnReorderer;

public class InvalidArgumentException extends Exception {
	
	public InvalidArgumentException() {
		super();
	}

	public InvalidArgumentException(String string) {
		super(string);
	}
	
	public InvalidArgumentException(String string, Exception cause) {
		super(string,cause);
	}

}
