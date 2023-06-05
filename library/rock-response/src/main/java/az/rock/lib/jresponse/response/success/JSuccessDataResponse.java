package az.rock.lib.jresponse.response.success;

import az.rock.lib.jresponse.JHeader;
import az.rock.lib.jresponse.response.JResponseDataTransfer;
import az.rock.lib.jresponse.response.Message;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class JSuccessDataResponse<D> extends JResponseDataTransfer<D> {
    public JSuccessDataResponse() {
        super();
    }

    public JSuccessDataResponse(D data) {
        super(data, Boolean.TRUE, "S0000000001");
    }

    public JSuccessDataResponse(JHeader header, D data) {
        super(header, data, Boolean.TRUE);
    }

    public JSuccessDataResponse(D data, Message message) {
        super(data, Boolean.TRUE, message);
    }


    public JSuccessDataResponse(D data, String messageCode) {
        super(data, Boolean.TRUE, messageCode);
    }

    public JSuccessDataResponse(JHeader header, D data, Message messageCode) {
        super(header, data, Boolean.TRUE, messageCode);
    }


    public JSuccessDataResponse(JHeader header, D data, String messageCode) {
        super(header, data, Boolean.TRUE, messageCode);
    }

    @JsonIgnore
    @Override
    public JHeader getHeader() {
        return super.getHeader();
    }

    @JsonIgnore
    @Override
    public boolean isPresent() {
        return super.isPresent();
    }


}