package az.rock.flyjob.js.domain.presentation.exception;

import az.rock.lib.jexception.JRuntimeException;

public class CourseDomainException extends JRuntimeException {
    public CourseDomainException() {
        super("F0000000001");
    }

    public CourseDomainException(String message) {
        super(message);
    }
}
