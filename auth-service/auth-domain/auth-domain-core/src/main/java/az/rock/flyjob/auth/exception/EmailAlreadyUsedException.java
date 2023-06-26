package az.rock.flyjob.auth.exception;

public class EmailAlreadyUsedException extends AuthDomainException {
    public EmailAlreadyUsedException() {
        super("F0000000012");
    }
}
