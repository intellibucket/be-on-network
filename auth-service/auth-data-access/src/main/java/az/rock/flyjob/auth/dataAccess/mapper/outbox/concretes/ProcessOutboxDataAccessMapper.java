package az.rock.flyjob.auth.dataAccess.mapper.outbox.concretes;

import az.rock.flyjob.auth.dataAccess.mapper.outbox.abstracts.AbstractProcessOutboxDataAccessMapper;
import az.rock.flyjob.auth.dataAccess.model.entity.outbox.ProcessOutboxEntity;
import az.rock.lib.coordinator.outbox.ProcessOutboxRoot;
import az.rock.lib.domain.OutboxID;
import az.rock.lib.domain.TransactionID;
import az.rock.lib.util.GDateTime;
import az.rock.lib.valueObject.Version;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProcessOutboxDataAccessMapper implements AbstractProcessOutboxDataAccessMapper {

    @Override
    public Optional<ProcessOutboxRoot> toRoot(ProcessOutboxEntity entity) {
        var optionalEntity = Optional.ofNullable(entity);
        if (optionalEntity.isPresent()) {
            var outboxEntity = optionalEntity.get();
            return Optional.of(
                    ProcessOutboxRoot.Builder.builder()
                            .uuid(OutboxID.of(outboxEntity.getUuid()))
                            .isActive(outboxEntity.getIsActive())
                            .version(Version.of(outboxEntity.getVersion()))
                            .createdDate(GDateTime.toZonedDateTime(outboxEntity.getCreatedDate()))
                            .lastModifiedDate(GDateTime.toZonedDateTime(outboxEntity.getLastModifiedDate()))
                            .topic(outboxEntity.getTopic())
                            .transactionId(TransactionID.of(entity.getTransactionId()))
                            .trxStatus(outboxEntity.getTrxStatus())
                            .process(outboxEntity.getProcess())
                            .step(outboxEntity.getStep())
                            .event(outboxEntity.getEvent())
                            .mustBeRetryableStep(outboxEntity.getMustBeRetryableStep())
                            .build()
            );
        }
        return Optional.empty();
    }

    @Override
    public Optional<ProcessOutboxEntity> toEntity(ProcessOutboxRoot root) {
        var optionalRoot = Optional.ofNullable(root);
        if (optionalRoot.isPresent()) {
            var outboxRoot = optionalRoot.get();
            return Optional.ofNullable(
                    ProcessOutboxEntity.builder()
                            .uuid(outboxRoot.getRootID().getAbsoluteID())
                            .isActive(outboxRoot.getIsActive())
                            .version(outboxRoot.getVersion().toShort())
                            .createdDate(GDateTime.toTimestamp(outboxRoot.getCreatedDate()))
                            .lastModifiedDate(GDateTime.toTimestamp(outboxRoot.getLastModifiedDate()))
                            .topic(outboxRoot.getTopic())
                            .transactionId(outboxRoot.getTransactionId().getRootID())
                            .trxStatus(outboxRoot.getTrxStatus())
                            .process(outboxRoot.getProcess())
                            .step(outboxRoot.getStep())
                            .event(outboxRoot.getEvent())
                            .mustBeRetryableStep(outboxRoot.getMustBeRetryableStep())
                            .build()
            );
        }
        return Optional.empty();
    }

}
