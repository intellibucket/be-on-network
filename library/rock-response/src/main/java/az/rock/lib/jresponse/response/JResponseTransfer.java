package az.rock.lib.jresponse.response;

import az.rock.lib.jresponse.JTransfer;

public class JResponseTransfer extends JTransfer {
    private final Boolean success;
    private final Message message;

    public JResponseTransfer(Boolean success, Message message) {
        super();
        this.success = success;
        this.message = message;
    }

    public JResponseTransfer(Boolean success, String messageCode) {
        super();
        this.success = success;
        this.message = new Message(messageCode, true);
    }

    public JResponseTransfer(Boolean success) {
        super();
        this.success = success;
        this.message = null;
    }

    public Boolean getSuccess() {
        return success;
    }

    public Message getMessage() {
        return message;
    }
}
