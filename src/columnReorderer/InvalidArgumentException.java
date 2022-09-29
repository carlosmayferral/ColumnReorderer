package columnReorderer;

public class InvalidArgumentException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4655103141261889262L;

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
