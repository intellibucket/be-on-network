package az.rock.lib.jexception;

public class JDomainException extends JException {
    public JDomainException(String code) {
        super(code);
    }

    public JDomainException() {
        super("F0000000001");
    }
}
