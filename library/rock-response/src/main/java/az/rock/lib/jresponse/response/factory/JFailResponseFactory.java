package az.rock.lib.jresponse.response.factory;

import az.rock.lib.jresponse.JHeader;
import az.rock.lib.jresponse.response.fail.JFailDataResponse;
import az.rock.lib.jresponse.response.fail.JFailResponse;

public class JFailResponseFactory<D> implements AbstractJFailResponseFactory<D> {
    @Override
    public JFailResponse factoryResponse() {
        return new JFailResponse();
    }

    @Override
    public JFailResponse factoryResponse(String message) {
        return new JFailResponse(message);
    }

    @Override
    public JFailDataResponse<D> factoryResponse(D data) {
        return new JFailDataResponse<>(data);
    }

    @Override
    public JFailDataResponse<D> factoryResponse(JHeader header, D data) {
        return new JFailDataResponse<>(header, data);
    }

    @Override
    public JFailDataResponse<D> factoryResponse(D data, String message) {
        return new JFailDataResponse<>(data, message);
    }

    @Override
    public JFailDataResponse<D> factoryResponse(JHeader header, D data, String message) {
        return new JFailDataResponse<>(header, data, message);
    }


}
