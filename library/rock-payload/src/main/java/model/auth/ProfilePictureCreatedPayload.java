package model.auth;

import az.rock.lib.annotation.ValueObject;

import java.util.UUID;

@ValueObject
public class ProfilePictureCreatedPayload {
    private UUID userUUID;
    private UUID pictureUUID;
    private String dfsPath;

    public ProfilePictureCreatedPayload() {}


    public ProfilePictureCreatedPayload(UUID userUUID, UUID pictureUUID, String dfsPath) {
        this.userUUID = userUUID;
        this.pictureUUID = pictureUUID;
        this.dfsPath = dfsPath;
    }

    public static ProfilePictureCreatedPayload of(UUID userUUID, UUID pictureUUID, String dfsPath) {
        return new ProfilePictureCreatedPayload(userUUID, pictureUUID, dfsPath);
    }


    public UUID getUserUUID() {
        return userUUID;
    }

    public void setUserUUID(UUID userUUID) {
        this.userUUID = userUUID;
    }

    public UUID getPictureUUID() {
        return pictureUUID;
    }

    public void setPictureUUID(UUID pictureUUID) {
        this.pictureUUID = pictureUUID;
    }

    public String getDfsPath() {
        return dfsPath;
    }

    public void setDfsPath(String dfsPath) {
        this.dfsPath = dfsPath;
    }

    @Override
    public String toString() {
        return "ProfilePictureCreatedPayload{" +
                "userUUID=" + userUUID +
                ", pictureUUID=" + pictureUUID +
                ", dfsPath='" + dfsPath + '\'' +
                '}';
    }
}
