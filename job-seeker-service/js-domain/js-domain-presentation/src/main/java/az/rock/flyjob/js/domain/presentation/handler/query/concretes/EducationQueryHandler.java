package az.rock.flyjob.js.domain.presentation.handler.query.concretes;

import az.rock.flyjob.js.domain.presentation.dto.response.resume.education.AnyEducationResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.education.MyEducationResponseModel;
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
    public SimplePageableResponse<MyEducationResponseModel> queryAllMyEducations(SimplePageableRequest pageableRequest) {
        var currentResumeId = securityContextHolder.availableResumeID();
        var myEducationsRootList = educationQueryRepositoryAdapter.fetchAllMyEducations(currentResumeId, pageableRequest);
        var myEducationsResponseList = myEducationsRootList.stream().map(MyEducationResponseModel::of).toList();
        return SimplePageableResponse.ofHasMore(pageableRequest.getSize(), pageableRequest.getPage(), myEducationsResponseList);
    }

    @Override
    public SimplePageableResponse<AnyEducationResponseModel> queryAllAnyEducations(UUID targetResumeId, SimplePageableRequest pageableRequest) {
        var anyEducationRootList = educationQueryRepositoryAdapter.fetchAllAnyEducations(targetResumeId, pageableRequest);
        var anyEducationResponseList = anyEducationRootList.stream().map(AnyEducationResponseModel::of).toList();
        return SimplePageableResponse.ofHasMore(pageableRequest.getSize(), pageableRequest.getPage(), anyEducationResponseList);
    }

    @Override
    public SimplePageableResponse<SimpleMyEducationResponseModel> queryAllMySimpleEducations(SimplePageableRequest pageableRequest) {
        var currentResumeId = securityContextHolder.availableResumeID();
        var simpleEducationRoots = educationQueryRepositoryAdapter.fetchAllMyEducations(currentResumeId, pageableRequest);
        var simpleEducationResponseList = simpleEducationRoots.stream().map(SimpleMyEducationResponseModel::of).toList();
        return SimplePageableResponse.ofHasMore(pageableRequest.getSize(), pageableRequest.getPage(), simpleEducationResponseList);
    }
}
