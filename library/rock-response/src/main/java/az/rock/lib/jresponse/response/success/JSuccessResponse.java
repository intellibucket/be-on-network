package az.rock.lib.jresponse.response.success;

import az.rock.lib.jresponse.JHeader;
import az.rock.lib.jresponse.response.JResponseTransfer;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class JSuccessResponse extends JResponseTransfer {
    public JSuccessResponse(String message) {
        super(Boolean.TRUE, message);
    }

    public JSuccessResponse() {
        super(Boolean.TRUE);
    }

    @JsonIgnore
    @Override
    public JHeader getHeader() {
        return super.getHeader();
    }

    public static JSuccessResponse success(String message) {
        return new JSuccessResponse(message);
    }

    public static JSuccessResponse success() {
        return new JSuccessResponse();
    }
}
