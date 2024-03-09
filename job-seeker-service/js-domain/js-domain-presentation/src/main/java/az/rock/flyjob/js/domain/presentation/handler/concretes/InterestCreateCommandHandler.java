package az.rock.flyjob.js.domain.presentation.handler.concretes;

import az.rock.flyjob.js.domain.core.exception.InterestNotFound;
import az.rock.flyjob.js.domain.core.root.detail.InterestRoot;
import az.rock.flyjob.js.domain.core.service.abstracts.AbstractInterestDomainService;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.item.InterestCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ReorderCommandModel;
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
import com.intellibucket.lib.payload.event.update.InterestReorderEvent;
import com.intellibucket.lib.payload.event.update.InterestUpdateEvent;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class InterestCreateCommandHandler implements AbstractInterestCreateCommandHandler {

    private final AbstractSecurityContextHolder securityContextHolder;
    private final AbstractInterestDomainService domainService;

    private final AbstractInterestQueryRepositoryAdapter interestQueryRepositoryAdapter;
    private final AbstractInterestCommandRepositoryAdapter interestCommandRepositoryAdapter;
    private final AbstractInterestDomainMapper interestDomainMapper;


    public InterestCreateCommandHandler(AbstractSecurityContextHolder securityContextHolder,
                                        @Qualifier("interestDomainService") AbstractInterestDomainService service,

                                        AbstractInterestQueryRepositoryAdapter interestQueryRepositoryAdapter,
                                        AbstractInterestCommandRepositoryAdapter interestCommandRepositoryAdapter,
                                        AbstractInterestDomainMapper interestDomainMapper) {
        this.securityContextHolder = securityContextHolder;
        this.domainService = service;

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
            var newInterestRoot = oldInterestRoot
                    .changeName(interestCommandModelUpdateRequest.getModel().getName())
                    .changeHobby(interestCommandModelUpdateRequest.getModel().getHobby())
                    .changeDescription(interestCommandModelUpdateRequest.getModel().getDescription());
            var interestRoot = this.domainService.validateInterestName(allInterests, newInterestRoot);
            this.interestCommandRepositoryAdapter.update(interestRoot);
            return InterestUpdateEvent.of(interestRoot);
        } else throw new InterestNotFound("Interest not Found");
    }

    @Override
    public InterestDeleteEvent delete(UUID interestId) throws InterestNotFound {
        var resumeID = this.securityContextHolder.availableResumeID();
        var ownByID = interestQueryRepositoryAdapter.findOwnByID(resumeID, InterestID.of(interestId));
        if (ownByID.isPresent()) {
            var interestRoot = ownByID.get();
            this.interestCommandRepositoryAdapter.delete(interestRoot);
            return InterestDeleteEvent.of(interestRoot.getRootID().getRootID());
        } else throw new InterestNotFound("Interest Not Found");

    }

    @Override
    public InterestReorderEvent reorder(ReorderCommandModel request) throws InterestNotFound {
        var resumeID = this.securityContextHolder.availableResumeID();
        var allInterests = this.interestQueryRepositoryAdapter.findAllByPID(resumeID);
        var targetInterest = allInterests.stream().filter(item -> item.getRootID().getAbsoluteID()
                        .equals(request.getTargetId()))
                .findFirst();
        if (targetInterest.isPresent()) {
            var targetRoot = targetInterest.get();
            var targetRootOrderNumber = targetRoot.getOrderNumber();
            var mainRoot = allInterests.stream().filter(item -> item.getOrderNumber()
                            .equals(request.getOrderNumber()))
                    .findFirst()
                    .orElseThrow(() -> new InterestNotFound("Interest not found"));
            var changedTargetRoot = targetRoot.changeOrderNumber(mainRoot.getOrderNumber());
            var changedMainRoot = mainRoot.changeOrderNumber(targetRootOrderNumber);
            this.interestCommandRepositoryAdapter.update(changedTargetRoot);
            this.interestCommandRepositoryAdapter.update(changedMainRoot);
            return InterestReorderEvent.of(changedMainRoot.getRootID().getAbsoluteID());

        } else throw new InterestNotFound(" Target Interest not found");
    }

}
