package az.rock.flyjob.js.domain.presentation.handler.query.concretes;

import az.rock.flyjob.js.domain.presentation.dto.criteria.EducationCriteria;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.education.AnyEducationResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.education.MyEducationResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.education.simple.SimpleMyEducationResponseModel;
import az.rock.flyjob.js.domain.presentation.handler.query.abstracts.AbstractEducationQueryHandler;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.query.AbstractEducationQueryRepositoryAdapter;
import az.rock.flyjob.js.domain.presentation.security.AbstractSecurityContextHolder;
import az.rock.lib.valueObject.SimplePageableRequest;
import az.rock.lib.valueObject.SimplePageableResponse;

import java.util.UUID;

public class EducationQueryHandler implements AbstractEducationQueryHandler {
    private final AbstractSecurityContextHolder securityContextHolder;
    private final AbstractEducationQueryRepositoryAdapter educationQueryRepositoryAdapter;

    public EducationQueryHandler(AbstractSecurityContextHolder securityContextHolder, AbstractEducationQueryRepositoryAdapter educationQueryRepositoryAdapter) {
        this.securityContextHolder = securityContextHolder;
        this.educationQueryRepositoryAdapter = educationQueryRepositoryAdapter;
    }


    @Override
    public SimplePageableResponse<MyEducationResponseModel> queryAllMyEducations(SimplePageableRequest pageableRequest) {
        educationQueryRepositoryAdapter.findAllMyEducations();
        return null;
    }

    @Override
    public SimplePageableResponse<AnyEducationResponseModel> queryAllAnyEducations(UUID targetResumeId, SimplePageableRequest pageableRequest) {
        educationQueryRepositoryAdapter.findAllAnyEducations(EducationCriteria
                .builder().resumeID().build(), pageableRequest);
        return null;
    }

    @Override
    public SimplePageableResponse<SimpleMyEducationResponseModel> queryAllMySimpleEducations(SimplePageableRequest pageableRequest) {
        educationQueryRepositoryAdapter.findAllMySimpleEducations();
        return null;
    }
}
