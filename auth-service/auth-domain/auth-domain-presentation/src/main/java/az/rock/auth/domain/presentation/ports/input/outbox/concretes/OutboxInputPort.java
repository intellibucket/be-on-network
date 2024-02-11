package az.rock.auth.domain.presentation.ports.input.outbox.concretes;

import az.rock.auth.domain.presentation.ports.output.repository.outbox.AbstractFailOutboxRepositoryAdapter;
import az.rock.auth.domain.presentation.ports.output.repository.outbox.AbstractProcessOutboxRepositoryAdapter;
import az.rock.auth.domain.presentation.ports.output.repository.outbox.AbstractProcessStepRepositoryAdapter;
import az.rock.lib.coordinator.outbox.AbstractOutboxInputPort;
import az.rock.lib.coordinator.outbox.FailOutboxRoot;
import az.rock.lib.coordinator.outbox.ProcessOutboxRoot;
import az.rock.lib.coordinator.outbox.ProcessStepRoot;
import az.rock.lib.domain.OutboxID;
import az.rock.lib.valueObject.Version;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@Slf4j
public class OutboxInputPort implements AbstractOutboxInputPort {
    private final AbstractProcessStepRepositoryAdapter processStepRepositoryAdapter;
    private final AbstractProcessOutboxRepositoryAdapter processOutboxRepositoryAdapter;
    private final AbstractFailOutboxRepositoryAdapter failOutboxRepositoryAdapter;

    public OutboxInputPort(AbstractProcessStepRepositoryAdapter processStepRepositoryAdapter,
                           AbstractProcessOutboxRepositoryAdapter processOutboxRepositoryAdapter,
                           AbstractFailOutboxRepositoryAdapter failOutboxRepositoryAdapter) {
        this.processStepRepositoryAdapter = processStepRepositoryAdapter;
        this.processOutboxRepositoryAdapter = processOutboxRepositoryAdapter;
        this.failOutboxRepositoryAdapter = failOutboxRepositoryAdapter;
    }


    @Override
    public void startOutboxProcess(ProcessOutboxRoot root) {
        log.info("Start outbox saving process");
        this.processOutboxRepositoryAdapter.persist(root);
        var startStep = ProcessStepRoot.Builder
                .builder()
                .uuid(OutboxID.of(UUID.randomUUID()))
                .version(Version.ONE)
                .isActive(true)
                .process(root.getProcess())
                .step(root.getStep())
                .isSuccessful(true)
                .transactionId(root.getTransactionId())
                .build();
        this.processStepRepositoryAdapter.persist(startStep);
    }

    @Override
    public void successOutboxProcess(ProcessStepRoot root, List<String> steps) {
        this.processStepRepositoryAdapter.persist(root);
        var isCompleted = this.processStepRepositoryAdapter.isCompleted(root.getTransactionId(), steps);
        if (isCompleted) {
            this.processOutboxRepositoryAdapter.complete(root.getTransactionId(), root.getStep());
        }
    }

    @Override
    public void failOutboxProcess(FailOutboxRoot root) {
        this.failOutboxRepositoryAdapter.persist(root);
        this.processOutboxRepositoryAdapter.fail(root.getTransactionId(), root.getStep());
    }
}
