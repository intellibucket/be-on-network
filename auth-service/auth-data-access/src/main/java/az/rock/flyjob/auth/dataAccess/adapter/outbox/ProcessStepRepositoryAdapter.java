package az.rock.flyjob.auth.dataAccess.adapter.outbox;

import az.rock.auth.domain.presentation.ports.output.repository.outbox.AbstractProcessStepRepositoryAdapter;
import az.rock.flyjob.auth.dataAccess.mapper.outbox.abstracts.AbstractProcessStepDataAccessMapper;
import az.rock.flyjob.auth.dataAccess.repository.outbox.ProcessStepJPARepository;
import az.rock.lib.coordinator.outbox.ProcessStepRoot;
import az.rock.lib.domain.OutboxEntity;
import az.rock.lib.domain.TransactionID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class ProcessStepRepositoryAdapter implements AbstractProcessStepRepositoryAdapter {

    private final ProcessStepJPARepository processStepRepository;
    private final AbstractProcessStepDataAccessMapper processStepDataAccessMapper;

    public ProcessStepRepositoryAdapter(ProcessStepJPARepository processStepRepository,
                                        AbstractProcessStepDataAccessMapper processStepDataAccessMapper) {
        this.processStepRepository = processStepRepository;
        this.processStepDataAccessMapper = processStepDataAccessMapper;
    }

    @Override
    public void persist(ProcessStepRoot root) {
        if (root != null) {
            var optionalEntity = this.processStepDataAccessMapper.toEntity(root);
            optionalEntity.ifPresentOrElse(
                    processStepRepository::save,
                    () -> {
                        log.error("ProcessStepRoot to entity conversion failed");
                        throw new IllegalArgumentException("ProcessStepRoot to entity conversion failed");
                    }
            );
        } else throw new IllegalArgumentException("ProcessStepRoot is null");
    }

    @Override
    public Boolean isExist(TransactionID transactionID, String step) {
        return processStepRepository.existByTransactionIdAndStep(transactionID.getAbsoluteID(), step);
    }

    @Override
    public Boolean isCompleted(TransactionID transactionID, List<String> step) {
        var result = processStepRepository.isCompletedByTransactionIdInAllSteps(transactionID.getAbsoluteID(), step);
        return result.stream().map(OutboxEntity::getStep).allMatch(step::contains);
    }

    @Override
    public List<ProcessStepRoot> findByTransactionId(TransactionID transactionId) {
        return processStepRepository.findByTransactionId(transactionId.getAbsoluteID())
                .stream()
                .map(processStepDataAccessMapper::toRoot)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }
}
