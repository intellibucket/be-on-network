package az.rock.flyjob.js.domain.presentation.handler.concretes;

import az.rock.flyjob.js.domain.core.service.abstracts.AbstractEducationDomainService;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.CreateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.item.EducationCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ReorderCommandModel;
import az.rock.flyjob.js.domain.presentation.handler.abstracts.AbstractEducationCommandHandler;
import az.rock.flyjob.js.domain.presentation.mapper.abstracts.AbstractEducationDomainMapper;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.command.AbstractEducationCommandRepositoryAdapter;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.query.AbstractEducationQueryRepositoryAdapter;
import az.rock.flyjob.js.domain.presentation.security.AbstractSecurityContextHolder;
import az.rock.lib.jexception.NoActiveRowException;
import com.intellibucket.lib.payload.event.abstracts.AbstractDomainEvent;
import com.intellibucket.lib.payload.event.delete.EducationDeletedEvent;
import com.intellibucket.lib.payload.event.update.EducationUpdatedEvent;
import com.intellibucket.lib.payload.payload.EducationPayload;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EducationCommandHandler implements AbstractEducationCommandHandler<AbstractDomainEvent<EducationPayload>> {

    private final AbstractSecurityContextHolder securityContextHolder;
    private final AbstractEducationDomainService abstractEducationDomainService;
    private final AbstractEducationQueryRepositoryAdapter abstractEducationQueryRepositoryAdapter;
    private final AbstractEducationCommandRepositoryAdapter abstractEducationCommandRepositoryAdapter;
    private final AbstractEducationDomainMapper abstractEducationDomainMapper;

    public EducationCommandHandler(AbstractSecurityContextHolder securityContextHolder, AbstractEducationDomainService abstractEducationDomainService, AbstractEducationQueryRepositoryAdapter abstractEducationQueryRepositoryAdapter, AbstractEducationCommandRepositoryAdapter abstractEducationCommandRepositoryAdapter, AbstractEducationDomainMapper abstractEducationDomainMapper) {
        this.securityContextHolder = securityContextHolder;
        this.abstractEducationDomainService = abstractEducationDomainService;
        this.abstractEducationQueryRepositoryAdapter = abstractEducationQueryRepositoryAdapter;
        this.abstractEducationCommandRepositoryAdapter = abstractEducationCommandRepositoryAdapter;
        this.abstractEducationDomainMapper = abstractEducationDomainMapper;
    }


    @Override
    public AbstractDomainEvent<EducationPayload> create(CreateRequest<EducationCommandModel> request) {
        var resumeID = this.securityContextHolder.availableResumeID();
        var educationRoot = this.abstractEducationDomainMapper.toNewRoot(resumeID, request.getModel());
        var validatedEducation = this.abstractEducationDomainService.validateEducation(resumeID, educationRoot);
        var optionalEducationRoot = this.abstractEducationCommandRepositoryAdapter.create(validatedEducation)
                .orElseThrow(NoActiveRowException::new);
        var educationPayload = this.abstractEducationDomainMapper.toPayload(optionalEducationRoot);
        return AbstractSuccessDomainEventEducationCreatedEvent.of(educationPayload);
    }

    @Override
    public AbstractDomainEvent<EducationPayload> update(UpdateRequest<EducationCommandModel> request) {
        return null;
    }

    @Override
    public AbstractDomainEvent delete(UUID educationId) {
        return null;
    }

    @Override
    public EducationUpdatedEvent reorder(ReorderCommandModel request) {
        return null;
    }
}
