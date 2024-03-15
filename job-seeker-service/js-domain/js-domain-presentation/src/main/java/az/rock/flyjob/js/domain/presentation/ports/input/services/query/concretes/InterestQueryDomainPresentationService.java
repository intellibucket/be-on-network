package az.rock.flyjob.js.domain.presentation.ports.input.services.query.concretes;

import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.AnyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.MyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.simple.SimpleAnyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.ports.input.services.query.abstracts.AbstractInterestQueryDomainPresentationService;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.query.AbstractInterestQueryRepositoryAdapter;
import az.rock.flyjob.js.domain.presentation.security.AbstractSecurityContextHolder;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.SimplePageableRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;

@Service
public class InterestQueryDomainPresentationService implements AbstractInterestQueryDomainPresentationService {
    private final List<AccessModifier> modifierList = List.of(AccessModifier.values());

    private final AbstractSecurityContextHolder securityContextHolder;
    private final AbstractInterestQueryRepositoryAdapter interestQueryRepositoryAdapter;

    public InterestQueryDomainPresentationService(AbstractSecurityContextHolder securityContextHolder, AbstractInterestQueryRepositoryAdapter interestQueryRepositoryAdapter) {
        this.securityContextHolder = securityContextHolder;
        this.interestQueryRepositoryAdapter = interestQueryRepositoryAdapter;
    }

    @Override
    public MyInterestResponseModel queryMyById(UUID interestUUID) {
        return null;
    }

    @Override
    public List<MyInterestResponseModel> queryMyAll() {
        return null;
    }

    @Override
    public List<MyInterestResponseModel> queryMySimpleAll() {
        return null;
    }


    //-------------------------------------------------------------------------
    @Override
    public Page<AnyInterestResponseModel> queryAllAnyInterests(UUID targetResumeId, SimplePageableRequest pageableRequest) {
        var pageRequest = PageRequest.of(pageableRequest.getPage(), pageableRequest.getSize());
        var allAnyInterests = this.interestQueryRepositoryAdapter.findAllAnyInterests(targetResumeId, pageRequest, modifierList);
        if (!allAnyInterests.isEmpty()) {
            return allAnyInterests;
        } else throw new RuntimeException();


    }

    @Override
    public Page<SimpleAnyInterestResponseModel> queryAllAnySimpleInterests(UUID targetResumeId, SimplePageableRequest pageable) {
        var pageableRequest = PageRequest.of(pageable.getPage(), pageable.getSize());
        var allAnySimpleInterest = this.interestQueryRepositoryAdapter.findAllAnySimpleInterest(targetResumeId, pageableRequest, modifierList);
        if (!allAnySimpleInterest.isEmpty()) {
            return allAnySimpleInterest;
        } else throw new RuntimeException();
    }

    @Override
    public AnyInterestResponseModel findAnyInterestById(UUID id) {
        var resumeID = securityContextHolder.availableResumeID();
        var anyInterest = this.interestQueryRepositoryAdapter.findAntById(resumeID.getAbsoluteID(), id, modifierList);
        if (anyInterest.isPresent()) {
            return anyInterest.get();
        } else {
            throw new RuntimeException();
        }
    }
}
