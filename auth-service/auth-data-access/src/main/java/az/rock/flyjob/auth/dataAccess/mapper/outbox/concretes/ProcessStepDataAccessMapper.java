package az.rock.flyjob.auth.dataAccess.mapper.outbox.concretes;

import az.rock.flyjob.auth.dataAccess.mapper.outbox.abstracts.AbstractProcessStepDataAccessMapper;
import az.rock.flyjob.auth.dataAccess.model.entity.outbox.ProcessStepEntity;
import az.rock.lib.domain.OutboxID;
import az.rock.lib.domain.TransactionID;
import az.rock.lib.domain.outbox.ProcessStepRoot;
import az.rock.lib.util.GDateTime;
import az.rock.lib.valueObject.Version;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProcessStepDataAccessMapper implements AbstractProcessStepDataAccessMapper {
    @Override
    public Optional<ProcessStepRoot> toRoot(ProcessStepEntity entity) {
        var optionalEntity = Optional.ofNullable(entity);
        if (optionalEntity.isPresent()) {
            return Optional.of(
                    ProcessStepRoot.Builder.builder()
                            .uuid(OutboxID.of(entity.getUuid()))
                            .isActive(entity.getIsActive())
                            .transactionId(TransactionID.of(entity.getTransactionId()))
                            .version(Version.of(entity.getVersion()))
                            .createdDate(GDateTime.toZonedDateTime(entity.getCreatedDate()))
                            .lastModifiedDate(GDateTime.toZonedDateTime(entity.getLastModifiedDate()))
                            .process(entity.getProcess())
                            .step(entity.getStep())
                            .isSuccessful(entity.getIsSuccessful())
                            .build()
            );
        } else return Optional.empty();
    }

    @Override
    public Optional<ProcessStepEntity> toEntity(ProcessStepRoot root) {
        var optionalRoot = Optional.ofNullable(root);
        if (optionalRoot.isPresent()) {
            return Optional.of(
                    ProcessStepEntity.builder()
                            .uuid(root.getRootID().getAbsoluteID())
                            .isActive(root.getIsActive())
                            .createdDate(GDateTime.toTimestamp(root.getCreatedDate()))
                            .lastModifiedDate(GDateTime.toTimestamp(root.getLastModifiedDate()))
                            .version(root.getVersion().toShort())
                            .transactionId(root.getTransactionId().getAbsoluteID())
                            .process(root.getProcess())
                            .step(root.getStep())
                            .isSuccessful(root.getIsSuccessful())
                            .build()
            );
        } else return Optional.empty();
    }
}
