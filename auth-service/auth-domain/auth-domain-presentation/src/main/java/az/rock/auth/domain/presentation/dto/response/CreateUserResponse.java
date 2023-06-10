package az.rock.auth.domain.presentation.dto.response;

import az.rock.flyjob.auth.root.user.UserRoot;
import lombok.Builder;

import java.util.UUID;

@Builder
public record CreateUserResponse(UUID userId,String firstName,String username,String email) {
    public  static CreateUserResponse of(UserRoot root){
        return new CreateUserResponse(root.getRootID().getAbsoluteID(),root.getFirstName(), root.getUsername(), root.getAbsoluteEmail());
    }
}
