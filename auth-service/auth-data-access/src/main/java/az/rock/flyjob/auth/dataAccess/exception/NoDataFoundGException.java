package az.rock.flyjob.auth.dataAccess.exception;

public class NoDataFoundGException extends AuthDataAccessException {
    public NoDataFoundGException(String message) {
        super(message);
    }

    public NoDataFoundGException() {
        super("No data found");
    }
}
