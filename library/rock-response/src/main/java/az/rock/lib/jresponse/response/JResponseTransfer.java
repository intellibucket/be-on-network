package az.rock.lib.jresponse.response;

import az.rock.lib.jresponse.JTransfer;

public class JResponseTransfer extends JTransfer {
    private final Boolean success;
    private final String message;

    public JResponseTransfer(Boolean success, String message) {
        super();
        this.success = success;
        this.message = message;
    }

    public JResponseTransfer(Boolean success) {
        super();
        this.success = success;
        this.message = null;
    }

    public Boolean getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
