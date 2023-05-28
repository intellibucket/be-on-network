package az.rock.lib.valueObject;

import az.rock.lib.annotation.ValueObject;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

@ValueObject
public class TrackingModel {
    @NotNull
    private final UUID trackingId;
    @NotNull
    private final ProcessStatus processStatus;
    private final List<String> failureMessages;

    public TrackingModel(UUID trackingId,
                         ProcessStatus processStatus,
                         List<String> failureMessages) {
        this.trackingId = trackingId;
        this.processStatus = processStatus;
        this.failureMessages = failureMessages;
    }

    public UUID getTrackingId() {
        return trackingId;
    }

    public ProcessStatus getProcessStatus() {
        return processStatus;
    }

    public List<String> getFailureMessages() {
        return failureMessages;
    }
}
