package az.rock.lib.event.payload;

import az.rock.lib.annotation.ValueObject;
import az.rock.lib.valueObject.UserType;

import java.util.UUID;

@ValueObject
public class UserCreatedEventPayload {
    private UUID userId;
    private UserType type;
    public UserCreatedEventPayload(UUID userId, UserType type){
        this.userId = userId;
        this.type = type;
    }
    public static UserCreatedEventPayload of(UUID userId, UserType type) {
        return new UserCreatedEventPayload(userId, type);
    }

    public UUID getUserId() {
        return userId;
    }

    public UserType getType() {
        return type;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public void setType(UserType type) {
        this.type = type;
    }
}
