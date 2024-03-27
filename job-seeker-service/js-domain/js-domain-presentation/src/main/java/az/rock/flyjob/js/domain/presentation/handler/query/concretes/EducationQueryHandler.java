package az.rock.flyjob.js.domain.presentation.handler.query.concretes;

import az.rock.flyjob.js.domain.core.exception.education.EducationDomainException;
import az.rock.flyjob.js.domain.core.exception.education.EducationNotFoundException;
import az.rock.flyjob.js.domain.presentation.dto.criteria.EducationCriteria;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.education.AnyEducationResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.education.MyEducationResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.education.simple.SimpleAnyEducationResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.education.simple.SimpleMyEducationResponseModel;
import az.rock.flyjob.js.domain.presentation.handler.query.abstracts.AbstractEducationQueryHandler;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.query.AbstractEducationQueryRepositoryAdapter;
import az.rock.flyjob.js.domain.presentation.security.AbstractSecurityContextHolder;
import az.rock.lib.valueObject.SimplePageableRequest;
import az.rock.lib.valueObject.SimplePageableResponse;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EducationQueryHandler implements AbstractEducationQueryHandler {
    private final AbstractSecurityContextHolder securityContextHolder;
    private final AbstractEducationQueryRepositoryAdapter educationQueryRepositoryAdapter;

    public EducationQueryHandler(AbstractSecurityContextHolder securityContextHolder, AbstractEducationQueryRepositoryAdapter educationQueryRepositoryAdapter) {
        this.securityContextHolder = securityContextHolder;
        this.educationQueryRepositoryAdapter = educationQueryRepositoryAdapter;
    }


    @Override
    public SimplePageableResponse<MyEducationResponseModel> queryAllMyEducations(SimplePageableRequest pageableRequest) throws EducationDomainException {
        var currentResumeId = securityContextHolder.availableResumeID();
        var educationCriteria = EducationCriteria.builder().resumeID(currentResumeId.getRootID()).build();
        var myEducationsRootList = educationQueryRepositoryAdapter.fetchAllEducations(educationCriteria, pageableRequest);
        if (myEducationsRootList.isEmpty()) throw new EducationNotFoundException();
        var myEducationsResponseList = myEducationsRootList.stream().map(MyEducationResponseModel::of).toList();
        return SimplePageableResponse.ofHasMore(pageableRequest.getSize(), pageableRequest.getPage(), myEducationsResponseList);
    }

    @Override
    public SimplePageableResponse<AnyEducationResponseModel> queryAllAnyEducations(UUID targetResumeId, SimplePageableRequest pageableRequest) throws EducationDomainException {
        var educationCriteria = EducationCriteria.builder().resumeID(targetResumeId).build();
        var anyEducationRootList = educationQueryRepositoryAdapter.fetchAllEducations(educationCriteria, pageableRequest);
        if (anyEducationRootList.isEmpty()) throw new EducationNotFoundException();
        var anyEducationResponseList = anyEducationRootList.stream().map(AnyEducationResponseModel::of).toList();
        return SimplePageableResponse.ofHasMore(pageableRequest.getSize(), pageableRequest.getPage(), anyEducationResponseList);
    }

    @Override
    public SimplePageableResponse<SimpleMyEducationResponseModel> queryAllMySimpleEducations(SimplePageableRequest pageableRequest) throws EducationDomainException {
        var currentResumeId = securityContextHolder.availableResumeID();
        var educationCriteria = EducationCriteria.builder().resumeID(currentResumeId.getRootID()).build();
        var simpleEducationRoots = educationQueryRepositoryAdapter.fetchAllEducations(educationCriteria, pageableRequest);
        if (simpleEducationRoots.isEmpty()) throw new EducationNotFoundException();
        var simpleEducationResponseList = simpleEducationRoots.stream().map(SimpleMyEducationResponseModel::of).toList();
        return SimplePageableResponse.ofHasMore(pageableRequest.getSize(), pageableRequest.getPage(), simpleEducationResponseList);
    }

    @Override
    public SimplePageableResponse<SimpleAnyEducationResponseModel> queryAllAnySimpleEducations(UUID targetResumeId, SimplePageableRequest pageableRequest) throws EducationDomainException {
        var educationCriteria = EducationCriteria.builder().resumeID(targetResumeId).build();
        var anySimpleEducationRoots = educationQueryRepositoryAdapter.fetchAllEducations(educationCriteria, pageableRequest);
        if (anySimpleEducationRoots.isEmpty()) throw new EducationNotFoundException();
        var anySimpleEducationResponseList = anySimpleEducationRoots.stream().map(AnyEducationResponseModel::of).toList();
        return SimplePageableResponse.ofHasMore(pageableRequest.getSize(), pageableRequest.getPage(), anySimpleEducationResponseList);
    }

    @Override
    public MyEducationResponseModel findMyEducationById(UUID id) throws EducationDomainException {
        var currentResumeId = securityContextHolder.availableResumeID();

        return null;
    }

    @Override
    public AnyEducationResponseModel findAnyEducationById(UUID id) throws EducationDomainException {
        return null;
    }
}
