package az.rock.lib.jresponse.response.factory;

import az.rock.lib.jresponse.JHeader;
import az.rock.lib.jresponse.response.Message;
import az.rock.lib.jresponse.response.fail.JFailDataResponse;
import az.rock.lib.jresponse.response.fail.JFailResponse;


public interface AbstractJFailResponseFactory<D> {
    JFailResponse factoryResponse();

    JFailResponse factoryResponse(Message message);

    JFailDataResponse<D> factoryResponse(D data);

    JFailDataResponse<D> factoryResponse(JHeader header, D data);

    JFailDataResponse<D> factoryResponse(D data, Message message);

    JFailDataResponse<D> factoryResponse(JHeader header, D data, Message message);
}
