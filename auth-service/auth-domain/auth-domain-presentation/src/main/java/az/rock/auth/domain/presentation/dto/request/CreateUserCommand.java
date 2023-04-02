package az.rock.auth.domain.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@AllArgsConstructor
@Setter
public class CreateUserCommand {

    private final String username;
    private final String firstName;
    private final String lastName;
    private final String password;
    private final String email;

}