package az.rock.auth.domain.presentation.dto.request;

import az.rock.lib.valueObject.Gender;
import com.intellibucket.ws.validation.annotation.GEmail;
import com.intellibucket.ws.validation.annotation.GNotNull;
import com.intellibucket.ws.validation.annotation.GPattern;
import com.intellibucket.ws.validation.annotation.GStringValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@AllArgsConstructor
@Setter
public class CreateUserCommand {

    @GNotNull
    @GStringValue(absoluteName = "username")
    private final String username;

    @GNotNull
    @GStringValue(absoluteName = "firstName")
    private final String firstName;

    @GNotNull
    @GStringValue(absoluteName = "lastName")
    private final String lastName;

    @GPattern
    private final String password;

    @GNotNull
    private final Gender gender;

    @GNotNull
    @GEmail
    private final String email;

}