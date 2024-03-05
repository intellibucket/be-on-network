package az.rock.flyjob.js.domain.presentation.handler.concretes;

import az.rock.flyjob.js.domain.core.root.detail.EducationRoot;
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
import com.intellibucket.lib.payload.event.create.EducationCreatedEvent;
import com.intellibucket.lib.payload.event.delete.EducationDeletedEvent;
import com.intellibucket.lib.payload.event.update.EducationUpdatedEvent;
import com.intellibucket.lib.payload.payload.EducationPayload;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EducationCommandHandler implements AbstractEducationCommandHandler {

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

    private EducationPayload toPayload(EducationRoot educationRoot) {
        return EducationPayload
                .builder()
                .id(educationRoot.getRootID().getAbsoluteID())
                .accessModifier(educationRoot.getAccessModifier())
                .cityId(educationRoot.getCityId())
                .degree(educationRoot.getDegree())
                .description(educationRoot.getDescription())
//                .link()
//                .establishmentName()
//                .establishmentUUID()
//                .startDate()
//                .endDate(educationRoot.getEndDate())
                .orderNumber(educationRoot.getOrderNumber())
//                .resumeId()
//                .state()
                .build();
    }


    @Override
    public EducationCreatedEvent create(CreateRequest<EducationCommandModel> request) {
        var currentResume = this.securityContextHolder.availableResumeID();
        var educationRoot = this.abstractEducationDomainMapper.toNewRoot(currentResume, request.getModel());
        var validatedEducation = this.abstractEducationDomainService.validateEducation(currentResume, educationRoot);
        var optionalEducationRoot = this.abstractEducationCommandRepositoryAdapter.create(validatedEducation)
                .orElseThrow(NoActiveRowException::new);
        var educationPayload = this.toPayload(optionalEducationRoot);
        return EducationCreatedEvent.of(educationPayload);
    }

    @Override
    public EducationUpdatedEvent update(UpdateRequest<EducationCommandModel> request) {
        return null;
    }

    @Override
    public EducationDeletedEvent delete(UUID educationId) {
        return null;
    }

    @Override
    public EducationUpdatedEvent reorder(ReorderCommandModel request) {
        return null;
    }
}
