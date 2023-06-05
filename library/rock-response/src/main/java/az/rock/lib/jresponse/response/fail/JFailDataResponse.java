package az.rock.lib.jresponse.response.fail;

import az.rock.lib.jresponse.JHeader;
import az.rock.lib.jresponse.response.JResponseDataTransfer;
import az.rock.lib.jresponse.response.Message;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class JFailDataResponse<D> extends JResponseDataTransfer<D> {
    public JFailDataResponse(D data) {
        super(data, Boolean.FALSE);
    }

    public JFailDataResponse(JHeader header, D data) {
        super(header, data, Boolean.FALSE);
    }

    public JFailDataResponse(D data, Message message) {
        super(data, Boolean.FALSE, message);
    }

    public JFailDataResponse(JHeader header, D data, Message message) {
        super(header, data, Boolean.FALSE, message);
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
