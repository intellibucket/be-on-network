package az.rock.lib.coordinator.outbox;

import java.util.List;

public interface AbstractOutboxInputPort {
    void startOutboxProcess(ProcessOutboxRoot root);

    void successOutboxProcess(ProcessStepRoot root, List<String> strings);

    void failOutboxProcess(FailOutboxRoot root);
}