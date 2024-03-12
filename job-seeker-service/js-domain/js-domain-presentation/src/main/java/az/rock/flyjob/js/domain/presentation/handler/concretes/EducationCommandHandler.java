package az.rock.flyjob.js.domain.presentation.handler.concretes;

import az.rock.flyjob.js.domain.core.root.detail.EducationRoot;
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

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static az.rock.lib.valueObject.OrderNumber.ORDER_NUMBER;


@Component
@Slf4j
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
        List<EducationRoot> educations = educationQueryRepositoryAdapter.findAllByPID(resumeId);
        List<Integer> orderNumber = educations.stream().map(EducationRoot::getOrderNumber).toList();
        int max = orderNumber.stream().mapToInt(v -> v).max().orElseThrow();
        int min = orderNumber.stream().mapToInt(v -> v).min().orElseThrow();
        if (!orderNumber.contains(request.getOrderNumber()))
            throw new RuntimeException("orderNumber must be between: " + min + " and " + max);
        Integer tempOrderNumber = educations.stream().filter(educationRoot -> educationRoot.getRootID().getAbsoluteID().equals(request.getTargetId())
        ).findAny().orElseThrow().getOrderNumber();
        educations.forEach(
                educationRoot -> {
                    if (educationRoot.getRootID().getAbsoluteID().equals(request.getTargetId())) {
                        if (!Objects.equals(educationRoot.getOrderNumber(), request.getOrderNumber())) {
                            educationRoot.setOrderNumber(request.getOrderNumber());
                        } else {
                            throw new RuntimeException("Education Already Ordered");
                        }
                    }
                }
        );
        List<Integer> orderNumbersList = educations.stream().map(EducationRoot::getOrderNumber).toList();
        var lastOrderNumber = ORDER_NUMBER.duplicateOrderNumber(orderNumbersList);
        educations.forEach(
                educationRoot -> {
                    if (!educationRoot.getRootID().getAbsoluteID()
                            .equals(request.getTargetId())
                        && educationRoot.getOrderNumber().equals(lastOrderNumber)) {
                        educationRoot.setOrderNumber(tempOrderNumber);
                    }
                }
        );
        educationCommandRepositoryAdapter.updateAll(educations);
        return EducationUpdatedEvent.of(
                EducationPayload
                .builder()
                .id(request.getTargetId())
                .build());
    }


}
