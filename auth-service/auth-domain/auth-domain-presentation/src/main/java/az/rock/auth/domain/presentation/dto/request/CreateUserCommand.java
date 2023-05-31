package az.rock.auth.domain.presentation.dto.request;

import az.rock.lib.valueObject.Gender;
import com.intellibucket.ws.validation.annotation.GEmail;
import com.intellibucket.ws.validation.annotation.GPattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@AllArgsConstructor
@Setter
public class CreateUserCommand {

    @GEmail
    private final String username;
    private final String firstName;
    private final String lastName;
    @GPattern
    private final String password;
    private final Gender gender;
    private final String email;

}