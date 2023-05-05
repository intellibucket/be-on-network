package az.rock.lib.valueObject;

import az.rock.lib.annotation.ValueObject;

import java.util.UUID;

@ValueObject
public class Viewer {
    private final UUID viewerUUID;
    private final UserType userType;

    public Viewer(UUID viewerUUID, UserType userType) {
        this.viewerUUID = viewerUUID;
        this.userType = userType;
    }

    public UUID getViewerUUID() {
        return viewerUUID;
    }

    public UserType getUserType() {
        return userType;
    }

    public Boolean isGuest(){
        return this.userType.equals(UserType.GUEST);
    }

    public Boolean isCompany(){
        return this.userType.equals(UserType.COMPANY);
    }

    public Boolean isJobSeeker(){
        return this.userType.equals(UserType.JOB_SEEKER);
    }
}
