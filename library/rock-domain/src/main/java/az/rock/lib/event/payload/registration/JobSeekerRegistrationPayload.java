package az.rock.lib.event.payload.registration;

import az.rock.lib.event.payload.Payload;
import az.rock.lib.valueObject.UserType;

import java.util.UUID;


public class JobSeekerRegistrationPayload implements Payload {
    private UUID userId;
    private UserType type;

    public JobSeekerRegistrationPayload(UUID userId, UserType type) {
        this.userId = userId;
        this.type = type;
    }

    public JobSeekerRegistrationPayload(){}

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
