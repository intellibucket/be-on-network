package az.rock.lib.jexception;


public class AccessDeniedSecurityException extends JSecurityException {
    public AccessDeniedSecurityException() {
        super("Access denied :(");
    }

    public AccessDeniedSecurityException(String message) {
        super(message);
    }

    public AccessDeniedSecurityException(String message, Throwable cause) {
        super(message, cause);
    }
}
