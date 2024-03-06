package az.rock.auth.domain.presentation.dto.response.user;

import az.rock.flyjob.auth.model.root.user.UserRoot;
import az.rock.lib.valueObject.TimeZoneID;

import java.util.UUID;

public record UserAnyAccountResponse(UUID uuid,
                                     String firstName,
                                     String lastName,
                                     String username,
                                     TimeZoneID timezone,
                                     byte[] profileImage) {

    private UserAnyAccountResponse(UserRoot root){
        this(root.getRootID().getRootID(),
                root.getFirstName(),
                root.getLastName(),
                root.getUsername(),
                root.getTimezone(),
                null);
    }

    private UserAnyAccountResponse(UserRoot root, byte[] profileImage){
        this(root.getRootID().getRootID(),
                root.getFirstName(),
                root.getLastName(),
                root.getUsername(),
                root.getTimezone(),
                profileImage);
    }

    public static UserAnyAccountResponse of(UserRoot root){
        return new UserAnyAccountResponse(root);
    }

    public static UserAnyAccountResponse of(UserRoot root, byte[] profileImage){
        return new UserAnyAccountResponse(root, profileImage);
    }
}
