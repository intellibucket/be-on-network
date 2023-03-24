package az.rock.lib.jresponse.response.success;

import az.rock.lib.jresponse.JHeader;
import az.rock.lib.jresponse.response.JResponseDataTransfer;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class JSuccessDataResponse<D> extends JResponseDataTransfer<D> {
    public JSuccessDataResponse() {
        super();
    }

    public JSuccessDataResponse(D data) {
        super(data, Boolean.TRUE, "Əməliyyat tamamlandı");
    }

    public JSuccessDataResponse(JHeader header, D data) {
        super(header, data, Boolean.TRUE);
    }

    public JSuccessDataResponse(D data, String message) {
        super(data, Boolean.TRUE, message);
    }

    public JSuccessDataResponse(JHeader header, D data, String message) {
        super(header, data, Boolean.TRUE, message);
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