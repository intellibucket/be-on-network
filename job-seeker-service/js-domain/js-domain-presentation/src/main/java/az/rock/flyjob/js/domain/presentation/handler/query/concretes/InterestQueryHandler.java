package az.rock.flyjob.js.domain.presentation.handler.query.concretes;

import az.rock.flyjob.js.domain.core.exception.interest.InterestNotFound;
import az.rock.flyjob.js.domain.presentation.dto.criteria.InterestCriteria;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.AnyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.MyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.simple.SimpleAnyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.simple.SimpleMyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.handler.query.abstracts.AbstractInterestQueryHandler;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.query.AbstractInterestQueryRepositoryAdapter;
import az.rock.flyjob.js.domain.presentation.security.AbstractSecurityContextHolder;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.SimplePageableRequest;
import az.rock.lib.valueObject.SimplePageableResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class InterestQueryHandler implements AbstractInterestQueryHandler {
    private final List<AccessModifier> modifierList = List.of(AccessModifier.values());

    private final AbstractSecurityContextHolder contextHolder;
    private final AbstractInterestQueryRepositoryAdapter interestQueryRepositoryAdapter;

    public InterestQueryHandler(AbstractSecurityContextHolder contextHolder,
                                AbstractInterestQueryRepositoryAdapter interestQueryRepositoryAdapter) {
        this.contextHolder = contextHolder;
        this.interestQueryRepositoryAdapter = interestQueryRepositoryAdapter;
    }

    @Override
    public List<AnyInterestResponseModel> findAllAnyInterests(UUID targetResumeId, SimplePageableRequest pageableRequest) {

        var allAnyInterests = this.interestQueryRepositoryAdapter.findAllAnyInterests(targetResumeId, pageableRequest, modifierList);
        if (!allAnyInterests.isEmpty()) {
            return allAnyInterests;
        } else throw new RuntimeException("Interest Not found");
    }


    @Override
    public SimplePageableResponse<SimpleAnyInterestResponseModel> findAllAnySimpleInterest(UUID targetResumeId, SimplePageableRequest pageableRequest) throws InterestNotFound {
        final InterestCriteria criteria = toCriteria(ResumeID.of(targetResumeId), null, modifierList);
        var allAnySimpleInterest = this.interestQueryRepositoryAdapter.fetchAllAnySimpleInterest(criteria,pageableRequest);
        if (!allAnySimpleInterest.isEmpty()) {
           return  SimplePageableResponse.ofNoMore(pageableRequest.getSize(),pageableRequest.getPage(),allAnySimpleInterest);
        } else throw new InterestNotFound();
    }

    @Override
    public AnyInterestResponseModel findAnyById(UUID id) throws InterestNotFound {
        var resumeID = this.contextHolder.availableResumeID();
        var interestCriteria = toCriteria(resumeID, id, modifierList);
        var anyById = this.interestQueryRepositoryAdapter.fetchAnyById(interestCriteria);
        if (anyById.isPresent()) {
            return anyById.get();
        }else throw new InterestNotFound();
    }

    @Override
    public MyInterestResponseModel findMyInterestById(UUID id) {
        var myInterest = this.interestQueryRepositoryAdapter.findMyInterestById(id);
        if (myInterest.isPresent()) {
            return null;
        } else throw new RuntimeException();
    }

    @Override
    public List<MyInterestResponseModel> queryAllMyInterests(SimplePageableRequest pageableRequest) {
        var allMyInterests = this.interestQueryRepositoryAdapter.queryAllMyInterests(pageableRequest);
        if (!allMyInterests.isEmpty()) {
            return null;
        } else throw new RuntimeException();
    }

    @Override
    public List<SimpleMyInterestResponseModel> queryAllMySimpleInterests(SimplePageableRequest pageableRequest) {
        var allMySimpleInterests = this.interestQueryRepositoryAdapter.queryAllMySimpleInterests(pageableRequest);
        if (!allMySimpleInterests.isEmpty()) {
            return null;
        } else throw new RuntimeException();
    }


    //------------------------------------------------------------------------


    public InterestCriteria toCriteria(ResumeID resumeId, UUID id,List<AccessModifier> modifier) {
        return InterestCriteria.Builder.builder().
                resume(resumeId)
                .id(id)
                .accessModifier(modifier)
                .build();


    }
}
