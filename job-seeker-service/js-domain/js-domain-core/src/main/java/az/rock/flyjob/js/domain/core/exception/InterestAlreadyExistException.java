package az.rock.flyjob.js.domain.core.exception;

public class InterestAlreadyExistException extends InterestDomainException {
    public InterestAlreadyExistException() {
        super("An interest with this name has already been registered.");
    }
}
