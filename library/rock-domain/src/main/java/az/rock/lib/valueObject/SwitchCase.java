package az.rock.lib.valueObject;

import az.rock.lib.annotation.ValueObject;

import java.util.UUID;

@ValueObject
public class SwitchCase {
    private UUID uuid;
    private Boolean isActive;

    public SwitchCase(UUID uuid, Boolean isActive) {
        this.uuid = uuid;
        this.isActive = isActive;
    }

    public SwitchCase() {
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getUuid() {
        return uuid;
    }

    public Boolean getActive() {
        return isActive;
    }
}
