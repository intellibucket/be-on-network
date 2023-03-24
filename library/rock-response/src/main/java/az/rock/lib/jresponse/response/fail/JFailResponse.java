package az.rock.lib.jresponse.response.fail;

import az.rock.lib.jresponse.JHeader;
import az.rock.lib.jresponse.response.JResponseTransfer;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class JFailResponse extends JResponseTransfer {
    public JFailResponse(String message) {
        super(Boolean.FALSE, message);
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
