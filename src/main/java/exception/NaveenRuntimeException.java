package exception;

public class NaveenRuntimeException extends RuntimeException {

	public NaveenRuntimeException(Throwable cause) {
		super(cause);
	}

	public NaveenRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}
}
