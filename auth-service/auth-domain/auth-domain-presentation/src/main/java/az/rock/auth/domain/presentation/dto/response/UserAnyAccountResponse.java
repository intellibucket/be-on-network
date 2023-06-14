package az.rock.auth.domain.presentation.dto.response;

import az.rock.flyjob.auth.root.user.UserRoot;
import az.rock.lib.valueObject.Gender;
import az.rock.lib.valueObject.TimeZoneID;

import java.util.UUID;

public record UserAnyAccountResponse(UUID uuid,
                                     String firstName,
                                     String lastName,
                                     String username,
                                     TimeZoneID timezone,
                                     Gender gender) {

    private UserAnyAccountResponse(UserRoot root){
        this(root.getRootID().getRootID(),
                root.getFirstName(),
                root.getLastName(),
                root.getUsername(),
                root.getTimezone(),
                root.getGender());
    }
    public static UserAnyAccountResponse of(UserRoot root){
        return new UserAnyAccountResponse(root);
    }
}
