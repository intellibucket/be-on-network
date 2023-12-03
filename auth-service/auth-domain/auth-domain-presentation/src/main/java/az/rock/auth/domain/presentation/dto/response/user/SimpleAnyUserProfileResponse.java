package az.rock.auth.domain.presentation.dto.response.user;

import java.util.UUID;

public class SimpleAnyUserProfileResponse {
    private UUID userId;
    private String username;
    private String firstName;
    private String lastName;
    private String title;
    private Boolean oppositeFollow;
}
