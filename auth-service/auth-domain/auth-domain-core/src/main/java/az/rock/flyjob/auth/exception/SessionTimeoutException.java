package az.rock.flyjob.auth.exception;

public class SessionTimeoutException extends AuthDomainException{
    public SessionTimeoutException() {
        super("F0000000002");
    }
}
