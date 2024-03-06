package az.rock.lib.valueObject;

import az.rock.lib.annotation.ValueObject;
import com.fasterxml.jackson.annotation.JsonIgnore;

@ValueObject
public enum Switch {
    ON{
        @Override
        public Boolean isOn() {
            return true;
        }
    },OFF{
        @Override
        public Boolean isOn() {
            return false;
        }
    };

    @JsonIgnore
    public abstract Boolean isOn();
}
