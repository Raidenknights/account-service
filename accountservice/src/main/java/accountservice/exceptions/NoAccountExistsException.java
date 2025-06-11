package accountservice.exceptions;

public class NoAccountExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoAccountExistsException(String message) {
		super(message);
	}

}
