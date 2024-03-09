package az.rock.flyjob.js.domain.presentation.handler.concretes;

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
import com.intellibucket.lib.payload.event.create.EducationCreatedEvent;
import com.intellibucket.lib.payload.event.delete.EducationDeletedEvent;
import com.intellibucket.lib.payload.event.update.EducationUpdatedEvent;
import com.intellibucket.lib.payload.payload.EducationPayload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public class EducationCommandHandler implements AbstractEducationCommandHandler<AbstractDomainEvent<?>> {

    private final AbstractSecurityContextHolder securityContextHolder;
    private final AbstractEducationCommandRepositoryAdapter abstractEducationCommandRepositoryAdapter;
    private final AbstractEducationDomainMapper abstractEducationDomainMapper;
    private final AbstractEducationQueryRepositoryAdapter educationQueryRepositoryAdapter;

    public EducationCommandHandler(AbstractSecurityContextHolder securityContextHolder, AbstractEducationCommandRepositoryAdapter abstractEducationCommandRepositoryAdapter, AbstractEducationDomainMapper abstractEducationDomainMapper, AbstractEducationQueryRepositoryAdapter abstractEducationQueryRepositoryAdapter) {
        this.securityContextHolder = securityContextHolder;
        this.abstractEducationCommandRepositoryAdapter = abstractEducationCommandRepositoryAdapter;
        this.abstractEducationDomainMapper = abstractEducationDomainMapper;
        this.educationQueryRepositoryAdapter = abstractEducationQueryRepositoryAdapter;
    }


    @Override
    public AbstractDomainEvent<EducationPayload> create(CreateRequest<EducationCommandModel> request) {
        var resumeID = this.securityContextHolder.availableResumeID();
        var educationRoot = this.abstractEducationDomainMapper.toNewRoot(resumeID, request.getModel());
        var optionalEducationRoot = this.abstractEducationCommandRepositoryAdapter.create(educationRoot)
                .orElseThrow(NoActiveRowException::new);
        var educationPayload = this.abstractEducationDomainMapper.toPayload(optionalEducationRoot);
        return EducationCreatedEvent.of(educationPayload);

    }

    @Override
    public AbstractDomainEvent<EducationPayload> update(UpdateRequest<EducationCommandModel> request) {
        var resumeID = this.securityContextHolder.availableResumeID();
        var educationRootFromDatabase = this.educationQueryRepositoryAdapter.findByResumeAndUuidAndRowStatusTrue(resumeID, request.getTargetId());
        if (educationRootFromDatabase.isPresent()) {
            var educationRoot = educationRootFromDatabase.get();
            educationRoot
                    .changeEducationDegree(request.getModel().getDegree())
                    .changeEducationDescription(request.getModel().getDescription())
                    .changeEducationState(request.getModel().getState())
                    .changeEstablishmentName(request.getModel().getEstablishmentName())
                    .changeEducationStartDate(request.getModel().getStartDate())
                    .changeEducationEndDate(request.getModel().getEndDate())
                    .changeLink(request.getModel().getLink());
            this.abstractEducationCommandRepositoryAdapter.update(educationRoot);
            var educationPayload = this.abstractEducationDomainMapper.toPayload(educationRoot);
            return EducationUpdatedEvent.of(educationPayload);
        } else
            throw new RuntimeException("Cant update");
    }

    @Override
    public AbstractDomainEvent<UUID> delete(UUID educationId) {
        var resumeID = securityContextHolder.availableResumeID();
        var educationFromDatabase = educationQueryRepositoryAdapter.findByResumeAndUuidAndRowStatusTrue(resumeID, educationId);
        abstractEducationCommandRepositoryAdapter.inActive(educationFromDatabase.orElseThrow(NoActiveRowException::new));
        return EducationDeletedEvent.of(educationId);
    }


    @Override
    public AbstractDomainEvent<EducationPayload> reorder(ReorderCommandModel request) {
        return null;
    }
}
