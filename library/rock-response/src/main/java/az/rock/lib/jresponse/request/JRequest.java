package az.rock.lib.jresponse.request;

import az.rock.lib.jexception.JSecurityException;
import az.rock.lib.jexception.JUnknownException;
import az.rock.lib.jresponse.JDataTransfer;
import az.rock.lib.jresponse.JHeader;

public class JRequest<D> extends JDataTransfer<D> {
    public JRequest() {
        super();
    }

    public JRequest(D data) {
        super(data);
    }

    public JRequest(JHeader header, D data) {
        super(header, data);
    }


    public static class Builder<D> {
        private JHeader builderHeader;
        private D builderData;

        public Builder() {
        }

        public JRequest.Builder<D> of(D builderData) {
            if (builderData == null) throw new JUnknownException();
            this.builderData = builderData;
            return this;
        }

        public JRequest.Builder<D> ofNullable(D builderData) {
            this.builderData = builderData;
            return this;
        }

        public JRequest.Builder<D> authorized() {
            if (builderHeader == null || builderHeader.getUserUUID() == null)
                throw new JSecurityException("Unauthorized");
            return this;
        }

    }


}
