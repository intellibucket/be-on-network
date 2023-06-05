package az.rock.lib.jresponse.response;

import az.rock.lib.jresponse.JDataTransfer;
import az.rock.lib.jresponse.JHeader;
import az.rock.lib.jresponse.response.message.Message;


public class JResponseDataTransfer<D> extends JDataTransfer<D> {

    private Boolean success;
    private Message message;

    public JResponseDataTransfer(D data, Boolean success, Message message) {
        super(data);
        this.success = success;
        this.message = message;
    }

    public JResponseDataTransfer(D data, Boolean success, String messageCode) {
        super(data);
        this.success = success;
        this.message = new Message(messageCode,true);
    }

    public JResponseDataTransfer(JHeader header, D data, Boolean success, Message message) {
        super(header, data);
        this.success = success;
        this.message = message;
    }

    public JResponseDataTransfer(JHeader header, D data, Boolean success, String messageCode) {
        super(header, data);
        this.success = success;
        this.message = new Message(messageCode,true);
    }

    public JResponseDataTransfer(D data, Boolean success) {
        super(data);
        this.success = success;
        this.message = null;
    }

    public JResponseDataTransfer(JHeader header, D data, Boolean success) {
        super(header, data);
        this.success = success;
        this.message = null;
    }

    public JResponseDataTransfer() {

    }

    public Boolean getSuccess() {
        return success;
    }

    public Message getMessage() {
        return message;
    }


    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
