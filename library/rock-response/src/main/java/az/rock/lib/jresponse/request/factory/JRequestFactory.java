package az.rock.lib.jresponse.request.factory;

import az.rock.lib.jresponse.JHeader;
import az.rock.lib.jresponse.request.JRequest;

public class JRequestFactory<D> implements AbstractJRequestFactory<D> {
    @Override
    public JRequest<D> factory(D data) {
        return new JRequest<>(data);
    }

    @Override
    public JRequest<D> factory(JHeader header, D data) {
        return new JRequest<>(header, data);
    }
}
