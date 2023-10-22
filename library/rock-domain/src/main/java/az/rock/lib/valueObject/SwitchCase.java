package az.rock.lib.valueObject;

import az.rock.lib.annotation.ValueObject;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.UUID;
import java.util.function.Consumer;

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

    public void consumeIfAbsent(Runnable runnable){
        if (this.isActive) runnable.run();
    }

    public void consumeIfAbsentOrElse(Runnable runnable,Runnable elseRunnable){
        if (this.isActive) runnable.run();
        else elseRunnable.run();
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

    public Boolean isActive(){
        return isActive;
    }

}
