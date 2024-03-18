package az.rock.flyjob.js.domain.presentation.handler.query.abstracts;

import az.rock.flyjob.js.domain.presentation.dto.response.resume.education.AnyEducationResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.education.MyEducationResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.education.simple.SimpleMyEducationResponseModel;
import az.rock.lib.valueObject.SimplePageableRequest;
import az.rock.lib.valueObject.SimplePageableResponse;

import java.util.UUID;

public interface AbstractEducationQueryHandler {

    SimplePageableResponse<MyEducationResponseModel> queryAllMyEducations(SimplePageableRequest pageableRequest);

    SimplePageableResponse<AnyEducationResponseModel> queryAllAnyEducations(UUID targetResumeId, SimplePageableRequest pageableRequest);

    SimplePageableResponse<SimpleMyEducationResponseModel> queryAllMySimpleEducations(SimplePageableRequest pageableRequest);
}
