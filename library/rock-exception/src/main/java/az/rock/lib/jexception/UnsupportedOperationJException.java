package az.rock.lib.jexception;

public class UnsupportedOperationJException extends UnsupportedOperationException {
    public UnsupportedOperationJException() {
        super();
    }

    public UnsupportedOperationJException(String method) {
        super(method + " operation is unsupported");
    }
}
