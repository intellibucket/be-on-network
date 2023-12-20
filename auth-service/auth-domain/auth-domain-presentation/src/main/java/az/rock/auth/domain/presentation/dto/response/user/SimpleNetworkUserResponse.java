package az.rock.auth.domain.presentation.dto.response.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;

import java.math.BigInteger;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SimpleNetworkUserResponse {
    private UUID authId;
    private String username;
    private String firstName;
    private String lastName;
    private String title;

}
