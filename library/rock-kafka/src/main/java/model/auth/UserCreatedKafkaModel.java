package model.auth;

import az.rock.lib.annotation.ValueObject;
import az.rock.lib.valueObject.UserType;

import java.util.UUID;

@ValueObject
public record UserCreatedKafkaModel(UUID userId, UserType type) {
    public static UserCreatedKafkaModel of(UUID userId, UserType type) {
        return new UserCreatedKafkaModel(userId, type);
    }
}
