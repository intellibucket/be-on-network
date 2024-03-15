package az.rock.flyjob.js.domain.presentation.handler.query.concretes;

import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.AnyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.simple.SimpleAnyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.handler.query.abstracts.AbstractInterestQueryHandler;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.query.AbstractInterestQueryRepositoryAdapter;
import az.rock.flyjob.js.domain.presentation.security.AbstractSecurityContextHolder;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.SimplePageableRequest;
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
    public List<SimpleAnyInterestResponseModel> findAllAnySimpleInterest(UUID targetResumeId, SimplePageableRequest pageableRequest) {
        var allAnySimpleInterest = this.interestQueryRepositoryAdapter.findAllAnySimpleInterest(targetResumeId, pageableRequest, modifierList);
        if (!allAnySimpleInterest.isEmpty()) {
            return allAnySimpleInterest;
        } else throw new RuntimeException("Interest Not found");
    }

    @Override
    public AnyInterestResponseModel findAntById(UUID id) {
        var resumeID = this.contextHolder.availableResumeID();
        var antById = this.interestQueryRepositoryAdapter.findAntById(resumeID.getAbsoluteID(), id, modifierList);
        if (antById.isPresent()) {
            return antById.get();
        } else throw new RuntimeException("Interest Not found");
    }

    //------------------------------------------------------------------------
}
