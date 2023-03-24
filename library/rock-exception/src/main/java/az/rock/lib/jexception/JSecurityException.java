package az.rock.lib.jexception;


public class JSecurityException extends RuntimeException {
    public JSecurityException() {
        super("Unauthorized");
    }

    public JSecurityException(Exception exception) {
        super(exception.getMessage());
    }

    public JSecurityException(String message) {
        super(message);
    }

    public JSecurityException(String message, Throwable cause) {
        super(message);
    }
}
