package az.rock.flyjob.js.domain.presentation.handler.concretes;

import az.rock.flyjob.js.domain.core.exception.InterestNameIsExist;
import az.rock.flyjob.js.domain.core.exception.InterestNotFound;
import az.rock.flyjob.js.domain.core.exception.InterestOverLimit;
import az.rock.flyjob.js.domain.core.root.detail.InterestRoot;
import az.rock.flyjob.js.domain.core.service.abstracts.AbstractInterestDomainService;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.item.InterestCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ReorderCommandModel;
import az.rock.flyjob.js.domain.presentation.handler.abstracts.AbstractInterestCreateCommandHandler;
import az.rock.flyjob.js.domain.presentation.mapper.abstracts.AbstractInterestDomainMapper;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.command.AbstractInterestCommandRepositoryAdapter;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.query.AbstractInterestQueryRepositoryAdapter;
import az.rock.flyjob.js.domain.presentation.security.AbstractSecurityContextHolder;
import az.rock.lib.domain.id.js.InterestID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.AccessModifier;
import com.intellibucket.lib.payload.event.create.InterestCreateEvent;
import com.intellibucket.lib.payload.event.update.InterestDeleteEvent;
import com.intellibucket.lib.payload.event.update.InterestReorderEvent;
import com.intellibucket.lib.payload.event.update.InterestUpdateEvent;
import com.intellibucket.lib.payload.payload.InterestCreatePayload;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class InterestCreateCommandHandler implements AbstractInterestCreateCommandHandler {

    private final AbstractSecurityContextHolder securityContextHolder;
    private final AbstractInterestDomainService domainService;

    private final AbstractInterestQueryRepositoryAdapter interestQueryRepositoryAdapter;
    private final AbstractInterestCommandRepositoryAdapter interestCommandRepositoryAdapter;
    private final AbstractInterestDomainMapper interestDomainMapper;
    private final List<AccessModifier> modifierList= List.of(AccessModifier.values());


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
    public InterestCreateEvent add(InterestCommandModel interestCommandModel) throws InterestNameIsExist, InterestOverLimit {
        var currentResume = this.securityContextHolder.availableResumeID();
        var savedInterest = this.interestQueryRepositoryAdapter.findAllByPID(currentResume,modifierList);
        var interestRoot = this.interestDomainMapper.toNewRoot(currentResume, interestCommandModel);
        var validatedInterest = this.domainService.validateInterestName(savedInterest, interestRoot);
        this.limitOver(currentResume);
        var optionalInterest = this.interestCommandRepositoryAdapter.create(validatedInterest);
        var interestPayload = this.toPayload(optionalInterest.get());
        return InterestCreateEvent.of(interestPayload);
    }


    @Override
    public InterestUpdateEvent update(UpdateRequest<InterestCommandModel> interestCommandModelUpdateRequest) throws Exception {
        var resumeID = this.securityContextHolder.availableResumeID();
        var allInterests = interestQueryRepositoryAdapter.findAllByPID(resumeID,modifierList);
        var ownByID = interestQueryRepositoryAdapter.findOwnByID(resumeID,
                InterestID.of(interestCommandModelUpdateRequest.getTargetId()),modifierList);
        if (ownByID.isPresent()) {
            var oldInterestRoot = ownByID.get();
            final InterestRoot newRoot = this.interestDomainMapper.toNewRoot(resumeID, interestCommandModelUpdateRequest.getModel());

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
        var ownByID = interestQueryRepositoryAdapter.findOwnByID(resumeID, InterestID.of(interestId),modifierList);
        if (ownByID.isPresent()) {
            var interestRoot = ownByID.get();
            this.interestCommandRepositoryAdapter.delete(interestRoot);
            return InterestDeleteEvent.of(interestRoot.getRootID().getRootID());
        } else throw new InterestNotFound("Interest Not Found");

    }

    @Override
    public InterestReorderEvent reorder(ReorderCommandModel request) throws InterestNotFound {
        var resumeID = this.securityContextHolder.availableResumeID();
        var allInterests = this.interestQueryRepositoryAdapter.findAllByPID(resumeID,modifierList);
        var targetInterest = allInterests.stream()
                .filter(item -> item.getRootID().getAbsoluteID()
                        .equals(request.getTargetId()))
                .findFirst();
        if (targetInterest.isPresent()) {
            var targetRoot = targetInterest.get();
            var targetNewOrderNumber = request.getOrderNumber();
            var targetOldOrderNumber = targetRoot.getOrderNumber();

            targetRoot.changeOrderNumber(targetNewOrderNumber);
            this.interestCommandRepositoryAdapter.update(targetRoot);


            allInterests.stream()
                    .filter(interest -> !interest.getRootID().getAbsoluteID().equals(request.getTargetId()))
                    .forEach(interest -> {
                        var currentOrderNumber = interest.getOrderNumber();

                        if (targetOldOrderNumber < targetNewOrderNumber && currentOrderNumber >= targetOldOrderNumber && currentOrderNumber <= targetNewOrderNumber) {
                            interest.changeOrderNumber(currentOrderNumber - 1);
                            this.interestCommandRepositoryAdapter.update(interest);
                        } else if (targetOldOrderNumber > targetNewOrderNumber && currentOrderNumber >= targetNewOrderNumber && currentOrderNumber <= targetOldOrderNumber) {
                            interest.changeOrderNumber(currentOrderNumber + 1);
                            this.interestCommandRepositoryAdapter.update(interest);
                        }
                    });
            return InterestReorderEvent.of(targetRoot.getRootID().getAbsoluteID());
        } else throw new InterestNotFound(" Target Interest not found");

    }


    private InterestCreatePayload toPayload(InterestRoot interestRoot) {
        return InterestCreatePayload.Builder
                .builder()
                .resumeId(interestRoot.getResume().getAbsoluteID())
                .interestId(interestRoot.getRootID().getAbsoluteID())
                .isHobby(interestRoot.getHobby())
                .name(interestRoot.getName())
                .description(interestRoot.getDescription())
                .orderNumber(interestRoot.getOrderNumber())
                .accessModifier(interestRoot.getAccessModifier())
                .build();
    }
    private void limitOver(ResumeID  resumeID) throws InterestOverLimit {
       var limit = interestQueryRepositoryAdapter.getLimit(resumeID);
       if(limit.isPresent() && limit.get()<10){
           return;
       }else throw new InterestOverLimit("you cant add anymore interest");
    }

}


