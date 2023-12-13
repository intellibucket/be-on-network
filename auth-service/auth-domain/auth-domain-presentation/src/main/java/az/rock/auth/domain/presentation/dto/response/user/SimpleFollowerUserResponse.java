package az.rock.auth.domain.presentation.dto.response.user;

import lombok.Data;

import java.util.UUID;

@Data
public class SimpleFollowerUserResponse {
    private UUID authId;
    private String username;
    private String firstName;
    private String lastName;
    private String title;
//    private Boolean oppositeFollow;
}
