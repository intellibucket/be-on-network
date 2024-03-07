package az.rock.flyjob.js.domain.presentation.handler.concretes;

import az.rock.flyjob.js.domain.core.exception.InterestNotFound;
import az.rock.flyjob.js.domain.core.service.abstracts.AbstractInterestDomainService;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.item.InterestCommandModel;
import az.rock.flyjob.js.domain.presentation.handler.abstracts.AbstractInterestCreateCommandHandler;
import az.rock.flyjob.js.domain.presentation.mapper.abstracts.AbstractInterestDomainMapper;
import az.rock.flyjob.js.domain.presentation.ports.input.services.command.abstracts.AbstractInterestCommandDomainPresentationService;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.command.AbstractInterestCommandRepositoryAdapter;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.query.AbstractInterestQueryRepositoryAdapter;
import az.rock.flyjob.js.domain.presentation.security.AbstractSecurityContextHolder;
import az.rock.lib.domain.id.js.InterestID;
import az.rock.lib.domain.id.js.ResumeID;
import com.intellibucket.lib.payload.event.create.InterestCreateEvent;
import com.intellibucket.lib.payload.event.update.InterestDeleteEvent;
import com.intellibucket.lib.payload.event.update.InterestUpdateEvent;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class InterestCreateCommandHandler implements AbstractInterestCreateCommandHandler {

    private final AbstractSecurityContextHolder securityContextHolder;
    private final AbstractInterestDomainService domainService;
    private final AbstractInterestCommandDomainPresentationService interestCommandDomainPresentationService;
    private final AbstractInterestQueryRepositoryAdapter interestQueryRepositoryAdapter;
    private final AbstractInterestCommandRepositoryAdapter interestCommandRepositoryAdapter;
    private final AbstractInterestDomainMapper interestDomainMapper;


    public InterestCreateCommandHandler(AbstractSecurityContextHolder securityContextHolder,
                                        AbstractInterestDomainService service,
                                        AbstractInterestCommandDomainPresentationService interestCommandDomainPresentationService,
                                        AbstractInterestQueryRepositoryAdapter interestQueryRepositoryAdapter,
                                        AbstractInterestCommandRepositoryAdapter interestCommandRepositoryAdapter,
                                        AbstractInterestDomainMapper interestDomainMapper) {
        this.securityContextHolder = securityContextHolder;
        this.domainService = service;
        this.interestCommandDomainPresentationService = interestCommandDomainPresentationService;
        this.interestQueryRepositoryAdapter = interestQueryRepositoryAdapter;
        this.interestCommandRepositoryAdapter = interestCommandRepositoryAdapter;
        this.interestDomainMapper = interestDomainMapper;
    }

    @Override
    public InterestCreateEvent add(InterestCommandModel interestCommandModel) {
        var currentResume = this.securityContextHolder.availableResumeID();
        var savedInterest = this.interestQueryRepositoryAdapter.findAllByPID(currentResume);

        return null;
    }

    @Override
    public InterestUpdateEvent update(UpdateRequest<InterestCommandModel> interestCommandModelUpdateRequest) throws Exception {
        var resumeID = this.securityContextHolder.availableResumeID();
        var allInterests = interestQueryRepositoryAdapter.findAllByPID(resumeID);
        var ownByID = interestQueryRepositoryAdapter.findOwnByID(resumeID,
                InterestID.of(interestCommandModelUpdateRequest.getTargetId()));
        if (ownByID.isPresent()) {
            var oldInterestRoot = ownByID.get();
            var newInterestRoot = oldInterestRoot.changeName(interestCommandModelUpdateRequest.getModel().getName())
                    .changeHobby(interestCommandModelUpdateRequest.getModel().getHobby())
                    .changeDescription(interestCommandModelUpdateRequest.getModel().getDescription());
            this.domainService.validateInterestName(allInterests, newInterestRoot);
            this.interestCommandRepositoryAdapter.update(newInterestRoot);
            return InterestUpdateEvent.of(newInterestRoot);
        } else throw new InterestNotFound("Interest not Found");
    }

    @Override
    public InterestDeleteEvent delete(UUID interestId) {
        return null;
    }


}
