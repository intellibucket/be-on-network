package az.rock.lib.jexception;

public class NoActiveRowException extends JRuntimeException {

    public NoActiveRowException() {
        super("Can not find row.");
    }
}
