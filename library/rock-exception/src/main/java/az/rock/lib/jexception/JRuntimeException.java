package az.rock.lib.jexception;

public class JRuntimeException extends RuntimeException {
    public JRuntimeException() {
        super("Unknown Error");
    }

    public JRuntimeException(String message) {
        super(message);
    }

    public JRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
}
