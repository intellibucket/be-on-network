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
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EducationCommandHandler implements AbstractEducationCommandHandler<AbstractDomainEvent<?>> {

    private final AbstractSecurityContextHolder securityContextHolder;
    private final AbstractEducationCommandRepositoryAdapter educationCommandRepositoryAdapter;
    private final AbstractEducationDomainMapper educationDomainMapper;
    private final AbstractEducationQueryRepositoryAdapter educationQueryRepositoryAdapter;

    public EducationCommandHandler(AbstractSecurityContextHolder securityContextHolder,
                                   AbstractEducationCommandRepositoryAdapter educationCommandRepositoryAdapter,
                                   AbstractEducationDomainMapper educationDomainMapper,
                                   AbstractEducationQueryRepositoryAdapter abstractEducationQueryRepositoryAdapter) {
        this.securityContextHolder = securityContextHolder;
        this.educationCommandRepositoryAdapter = educationCommandRepositoryAdapter;
        this.educationDomainMapper = educationDomainMapper;
        this.educationQueryRepositoryAdapter = abstractEducationQueryRepositoryAdapter;
    }


    @Override
    public AbstractDomainEvent<EducationPayload> create(CreateRequest<EducationCommandModel> request) {
        var resumeID = this.securityContextHolder.availableResumeID();
        var educationRoot = this.educationDomainMapper.toNewRoot(resumeID, request.getModel());
        var optionalEducationRoot = this.educationCommandRepositoryAdapter.create(educationRoot)
                .orElseThrow(NoActiveRowException::new);
        var educationPayload = this.educationDomainMapper.toPayload(optionalEducationRoot);
        return EducationCreatedEvent.of(educationPayload);
    }

    @Override
    public AbstractDomainEvent<EducationPayload> update(UpdateRequest<EducationCommandModel> request) {
        var resumeId = securityContextHolder.availableResumeID();
        var educationRootFromDatabase = this.educationQueryRepositoryAdapter.findByResumeAndUuidAndRowStatusTrue(resumeId, request.getTargetId());
        if (educationRootFromDatabase.isEmpty()) throw new NoActiveRowException();
        var educationRoot = educationRootFromDatabase.get();
        educationDomainMapper.toExistRoot(educationRoot, request.getModel());
        this.educationCommandRepositoryAdapter.update(educationRoot);
        var educationPayload = this.educationDomainMapper.toPayload(educationRoot);
        return EducationUpdatedEvent.of(educationPayload);
    }

    @Override
    public AbstractDomainEvent<UUID> delete(UUID educationId) {
        var resumeID = securityContextHolder.availableResumeID();
        var educationFromDatabase = educationQueryRepositoryAdapter.findByResumeAndUuidAndRowStatusTrue(resumeID, educationId);
        educationCommandRepositoryAdapter.inActive(educationFromDatabase.orElseThrow(NoActiveRowException::new));
        return EducationDeletedEvent.of(educationId);
    }


    @Override
    public AbstractDomainEvent<EducationPayload> reorder(ReorderCommandModel request) {
        var resumeId = securityContextHolder.availableResumeID();
        educationQueryRepositoryAdapter.findAllByPID(resumeId);
        var educationFromDatabase = educationQueryRepositoryAdapter
                .findByResumeAndUuidAndRowStatusTrue(resumeId, request.getTargetId())
                .orElseThrow(NoActiveRowException::new);
        educationFromDatabase.setOrderNumber(request.getOrderNumber());
        this.educationCommandRepositoryAdapter.update(educationFromDatabase);
        var educationPayload = this.educationDomainMapper.toPayload(educationFromDatabase);
        return EducationUpdatedEvent.of(educationPayload);
    }
}
