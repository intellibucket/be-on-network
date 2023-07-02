package model.auth;

import az.rock.lib.annotation.ValueObject;

import java.util.UUID;

@ValueObject
public record ProfilePictureCreatedPayload(UUID userUUID, UUID pictureUUID, String dfsPath) {
    public static ProfilePictureCreatedPayload of(UUID userUUID, UUID pictureUUID, String dfsPath) {
        return new ProfilePictureCreatedPayload(userUUID, pictureUUID, dfsPath);
    }
}
