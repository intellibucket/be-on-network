package az.rock.flyjob.js.domain.presentation.handler.concretes;

import az.rock.flyjob.js.domain.core.root.detail.InterestRoot;
import az.rock.flyjob.js.domain.presentation.dto.request.item.InterestCommandModel;
import az.rock.flyjob.js.domain.presentation.handler.abstracts.AbstractInterestCreateCommandHandler;
import az.rock.flyjob.js.domain.presentation.mapper.abstracts.AbstractInterestDomainMapper;
import az.rock.flyjob.js.domain.presentation.ports.input.services.command.abstracts.AbstractInterestCommandDomainPresentationService;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.command.AbstractInterestCommandRepositoryAdapter;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.query.AbstractInterestQueryRepositoryAdapter;
import az.rock.flyjob.js.domain.presentation.security.AbstractSecurityContextHolder;
import com.intellibucket.lib.payload.event.create.InterestCreateEvent;
import com.intellibucket.lib.payload.payload.InterestCreatePayload;
import org.springframework.stereotype.Component;

@Component
public class InterestCreateCommandHandler implements AbstractInterestCreateCommandHandler {

    private final AbstractSecurityContextHolder securityContextHolder;
    private final AbstractInterestCommandDomainPresentationService interestCommandDomainPresentationService;
    private final AbstractInterestQueryRepositoryAdapter interestQueryRepositoryAdapter;
    private final AbstractInterestCommandRepositoryAdapter interestCommandRepositoryAdapter;
    private final AbstractInterestDomainMapper interestDomainMapper;

    public InterestCreateCommandHandler(AbstractSecurityContextHolder securityContextHolder, AbstractInterestCommandDomainPresentationService interestCommandDomainPresentationService, AbstractInterestQueryRepositoryAdapter interestQueryRepositoryAdapter, AbstractInterestCommandRepositoryAdapter interestCommandRepositoryAdapter, AbstractInterestDomainMapper interestDomainMapper) {
        this.securityContextHolder = securityContextHolder;
        this.interestCommandDomainPresentationService = interestCommandDomainPresentationService;
        this.interestQueryRepositoryAdapter = interestQueryRepositoryAdapter;
        this.interestCommandRepositoryAdapter = interestCommandRepositoryAdapter;
        this.interestDomainMapper = interestDomainMapper;
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

    @Override
    public InterestCreateEvent add(InterestCommandModel interestCommandModel) {
        var currentResume=this.securityContextHolder.availableResumeID();
        var savedInterest=this.interestQueryRepositoryAdapter.findAllByPID(currentResume);

        return null;
    }
}
