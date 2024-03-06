package az.rock.auth.domain.presentation.dto.response.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SimpleAnyUserProfileResponse {
    private UUID userId;
    private String username;
    private String firstName;
    private String lastName;
    private String title;
    private Boolean oppositeFollow;
}
