package az.rock.lib.jresponse.response.factory;

import az.rock.lib.jresponse.JHeader;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import az.rock.lib.jresponse.response.success.JSuccessResponse;

public interface AbstractJSuccessResponseFactory<D> {
    JSuccessResponse factoryResponse();

    JSuccessResponse factoryResponse(String message);

    <D> JSuccessDataResponse<D> factoryResponse(D data);

    <D> JSuccessDataResponse<D> factoryResponse(JHeader header, D data);

    <D> JSuccessDataResponse<D> factoryResponse(D data, String message);

    <D> JSuccessDataResponse<D> factoryResponse(JHeader header, D data, String message);
}
