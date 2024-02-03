package az.rock.flyjob.auth.dataAccess.exception;

public class NoDataFoundDataAccessException extends AuthDataAccessException {
    public NoDataFoundDataAccessException(String message) {
        super(message);
    }

    public NoDataFoundDataAccessException() {
        super("No data found");
    }
}
