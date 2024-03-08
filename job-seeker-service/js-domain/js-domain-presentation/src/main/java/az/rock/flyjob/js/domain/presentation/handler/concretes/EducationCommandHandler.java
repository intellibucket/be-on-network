package az.rock.flyjob.js.domain.presentation.handler.concretes;

import az.rock.flyjob.js.domain.core.root.detail.EducationRoot;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.CreateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.item.EducationCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ReorderCommandModel;
import az.rock.flyjob.js.domain.presentation.handler.abstracts.AbstractEducationCommandHandler;
import az.rock.flyjob.js.domain.presentation.mapper.abstracts.AbstractEducationDomainMapper;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.command.AbstractEducationCommandRepositoryAdapter;
import az.rock.flyjob.js.domain.presentation.security.AbstractSecurityContextHolder;
import az.rock.lib.domain.id.js.EducationID;
import az.rock.lib.domain.id.js.ResumeID;
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
    private final AbstractEducationCommandRepositoryAdapter abstractEducationCommandRepositoryAdapter;
    private final AbstractEducationDomainMapper abstractEducationDomainMapper;

    public EducationCommandHandler(AbstractSecurityContextHolder securityContextHolder, AbstractEducationCommandRepositoryAdapter abstractEducationCommandRepositoryAdapter, AbstractEducationDomainMapper abstractEducationDomainMapper) {
        this.securityContextHolder = securityContextHolder;
        this.abstractEducationCommandRepositoryAdapter = abstractEducationCommandRepositoryAdapter;
        this.abstractEducationDomainMapper = abstractEducationDomainMapper;
    }


    @Override
    public AbstractDomainEvent<EducationPayload> create(CreateRequest<EducationCommandModel> request) {
        var resumeID = ResumeID.of(UUID.fromString("e66d06d5-d2f6-41d0-b7ed-3466f079bdbc"));
        var educationRoot = this.abstractEducationDomainMapper.toNewRoot(resumeID, request.getModel());
        var optionalEducationRoot = this.abstractEducationCommandRepositoryAdapter.create(educationRoot)
                .orElseThrow(NoActiveRowException::new);
        var educationPayload = this.abstractEducationDomainMapper.toPayload(optionalEducationRoot);
        return EducationCreatedEvent.of(educationPayload); //todo failedEvent
    }

    @Override
    public AbstractDomainEvent<EducationPayload> update(UpdateRequest<EducationCommandModel> request) {
        var resumeID = ResumeID.of(UUID.fromString("e66d06d5-d2f6-41d0-b7ed-3466f079bdbc"));
        var educationRoot = this.abstractEducationDomainMapper.toNewRoot(resumeID, request.getModel());
        abstractEducationCommandRepositoryAdapter.update(educationRoot);
        var educationPayload = this.abstractEducationDomainMapper.toPayload(educationRoot);
        return EducationUpdatedEvent.of(educationPayload);
    }

    @Override
    public AbstractDomainEvent<UUID> delete(UUID educationId) {
        var resumeID = ResumeID.of(UUID.fromString("e66d06d5-d2f6-41d0-b7ed-3466f079bdbc"));
        abstractEducationCommandRepositoryAdapter.inActive(EducationRoot.Builder
                .builder()
                .uuid(EducationID.of(educationId))
                .resume(resumeID)
                .build());
        return EducationDeletedEvent.of(educationId);

    }


    @Override
    public AbstractDomainEvent<EducationPayload> reorder(ReorderCommandModel request) {
        return null;
    }
}
