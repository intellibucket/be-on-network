package model.auth;

import az.rock.lib.annotation.ValueObject;
import az.rock.lib.valueObject.UserType;

import java.util.UUID;

@ValueObject
public record UserCreatedEventPayload(UUID userId, UserType type) {
    public static UserCreatedEventPayload of(UUID userId, UserType type) {
        return new UserCreatedEventPayload(userId, type);
    }
}
