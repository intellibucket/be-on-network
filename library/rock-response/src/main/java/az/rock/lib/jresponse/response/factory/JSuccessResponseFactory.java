package az.rock.lib.jresponse.response.factory;

import az.rock.lib.jresponse.JHeader;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import az.rock.lib.jresponse.response.success.JSuccessResponse;

public class JSuccessResponseFactory<D> implements AbstractJSuccessResponseFactory<D> {
    @Override
    public JSuccessResponse factoryResponse() {
        return new JSuccessResponse();
    }

    @Override
    public JSuccessResponse factoryResponse(String message) {
        return new JSuccessResponse(message);
    }

    @Override
    public <D> JSuccessDataResponse<D> factoryResponse(D data) {
        return new JSuccessDataResponse<>(data);
    }

    @Override
    public <D> JSuccessDataResponse<D> factoryResponse(JHeader header, D data) {
        return new JSuccessDataResponse<>(header, data);
    }

    @Override
    public <D> JSuccessDataResponse<D> factoryResponse(D data, String message) {
        return new JSuccessDataResponse<>(data, message);
    }

    @Override
    public <D> JSuccessDataResponse<D> factoryResponse(JHeader header, D data, String message) {
        return new JSuccessDataResponse<>(header, data, message);
    }

}
