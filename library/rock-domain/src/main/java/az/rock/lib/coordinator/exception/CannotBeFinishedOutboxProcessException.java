package az.rock.lib.coordinator.exception;

public class CannotBeFinishedOutboxProcessException extends RuntimeException {
    public CannotBeFinishedOutboxProcessException(String message) {
        super(message);
    }

    public CannotBeFinishedOutboxProcessException() {
        super("Cannot be finished outbox process");
    }

    public CannotBeFinishedOutboxProcessException(String message, Throwable cause) {
        super(message, cause);
    }

    public CannotBeFinishedOutboxProcessException(Throwable cause) {
        super(cause);
    }

    public CannotBeFinishedOutboxProcessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
