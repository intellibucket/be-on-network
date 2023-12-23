package az.rock.lib.jresponse.response.fail;

import az.rock.lib.jresponse.JHeader;
import az.rock.lib.jresponse.response.JResponseTransfer;
import az.rock.lib.jresponse.response.message.Message;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class JFailResponse extends JResponseTransfer<D> {
    public JFailResponse(Message message) {
        super(Boolean.FALSE, message);
    }

    public JFailResponse(String messageCode) {
        super(Boolean.FALSE, messageCode);
    }

    public JFailResponse() {
        super(Boolean.FALSE);
    }

    @JsonIgnore
    @Override
    public JHeader getHeader() {
        return super.getHeader();
    }


}
