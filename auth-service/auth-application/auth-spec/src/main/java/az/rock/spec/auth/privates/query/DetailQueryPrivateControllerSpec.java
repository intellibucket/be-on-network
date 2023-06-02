package az.rock.spec.auth.privates.query;

import az.rock.auth.domain.presentation.dto.response.DetailPrivateModelResponse;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import org.springframework.http.ResponseEntity;

public interface DetailQueryPrivateControllerSpec {
    ResponseEntity<JSuccessDataResponse<DetailPrivateModelResponse>> queryDetail();
}
