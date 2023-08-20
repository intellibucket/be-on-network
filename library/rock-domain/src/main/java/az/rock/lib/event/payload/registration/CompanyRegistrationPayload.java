package az.rock.lib.event.payload.registration;

import az.rock.lib.event.payload.Payload;
import az.rock.lib.valueObject.UserType;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;


public class CompanyRegistrationPayload extends Payload {
    private UUID userId;
    private UserType type;

    public CompanyRegistrationPayload(UUID userId, UserType type) {
        this.userId = userId;
        this.type = type;
    }

    public CompanyRegistrationPayload(){}

    public UserType getType() {
        return type;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public void setType(UserType type) {
        this.type = type;
    }
}
