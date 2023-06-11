package az.rock.auth.domain.presentation.dto.request;

import az.rock.lib.valueObject.Gender;
import az.rock.lib.valueObject.UserRegistrationType;
import com.intellibucket.ws.validation.annotation.GEmail;
import com.intellibucket.ws.validation.annotation.GNotNull;
import com.intellibucket.ws.validation.annotation.GPattern;
import com.intellibucket.ws.validation.annotation.GStringValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class CreateUserCommand {

    @GNotNull
    @GStringValue(absoluteName = "username")
    private String username;

    @GNotNull
    @GStringValue(absoluteName = "firstName")
    private String firstName;

    @GNotNull
    @GStringValue(absoluteName = "lastName")
    private String lastName;

    @GPattern
    private String password;

    @GNotNull
    private Gender gender;

    @GNotNull
    @GEmail
    private String email;



}