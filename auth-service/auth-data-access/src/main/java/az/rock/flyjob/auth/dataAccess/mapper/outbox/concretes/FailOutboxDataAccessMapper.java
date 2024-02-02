package az.rock.flyjob.auth.dataAccess.mapper.outbox.concretes;

import az.rock.flyjob.auth.dataAccess.mapper.outbox.abstracts.AbstractFailOutboxDataAccessMapper;
import az.rock.flyjob.auth.dataAccess.model.entity.outbox.FailOutboxEntity;
import az.rock.lib.domain.OutboxID;
import az.rock.lib.domain.TransactionID;
import az.rock.lib.domain.outbox.FailOutboxRoot;
import az.rock.lib.util.GDateTime;
import az.rock.lib.valueObject.Version;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FailOutboxDataAccessMapper implements AbstractFailOutboxDataAccessMapper {
    @Override
    public Optional<FailOutboxRoot> toRoot(FailOutboxEntity entity) {
        var optionalEntity = Optional.ofNullable(entity);
        if (optionalEntity.isPresent()) {
            return Optional.of(FailOutboxRoot
                    .Builder
                    .builder()
                    .uuid(OutboxID.of(entity.getUuid()))
                    .isActive(entity.getIsActive())
                    .transactionId(TransactionID.of(entity.getTransactionId()))
                    .version(Version.of(entity.getVersion()))
                    .createdDate(GDateTime.toZonedDateTime(entity.getCreatedDate()))
                    .lastModifiedDate(GDateTime.toZonedDateTime(entity.getLastModifiedDate()))
                    .process(entity.getProcess())
                    .step(entity.getStep())
                    .message(entity.getMessage())
                    .stackTrace(entity.getStackTrace())
                    .build()
            );
        } else return Optional.empty();
    }

    @Override
    public Optional<FailOutboxEntity> toEntity(FailOutboxRoot root) {
        var optionalRoot = Optional.ofNullable(root);
        if (optionalRoot.isPresent()) {
            return Optional.of(FailOutboxEntity
                    .builder()
                    .uuid(root.getRootID().getAbsoluteID())
                    .isActive(root.getIsActive())
                    .transactionId(root.getTransactionId().getAbsoluteID())
                    .version(root.getVersion().toShort())
                    .createdDate(GDateTime.toTimestamp(root.getCreatedDate()))
                    .lastModifiedDate(GDateTime.toTimestamp(root.getLastModifiedDate()))
                    .process(root.getProcess())
                    .step(root.getStep())
                    .message(root.getMessage())
                    .stackTrace(root.getStackTrace())
                    .build()
            );
        } else return Optional.empty();
    }
}
