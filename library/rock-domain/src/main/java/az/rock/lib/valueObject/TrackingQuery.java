package az.rock.lib.valueObject;

import az.rock.lib.annotation.ValueObject;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

@ValueObject
public class TrackingQuery {
    @NotNull
    private final UUID trackingId;

    public TrackingQuery(UUID trackingId) {
        this.trackingId = trackingId;
    }

    public UUID getTrackingId() {
        return trackingId;
    }
}
