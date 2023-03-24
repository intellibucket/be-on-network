package az.rock.lib.jresponse.request.factory;

import az.rock.lib.jresponse.JHeader;
import az.rock.lib.jresponse.request.JRequest;

public interface AbstractJRequestFactory<D> {
    JRequest<D> factory(D data);

    JRequest<D> factory(JHeader header, D data);
}
