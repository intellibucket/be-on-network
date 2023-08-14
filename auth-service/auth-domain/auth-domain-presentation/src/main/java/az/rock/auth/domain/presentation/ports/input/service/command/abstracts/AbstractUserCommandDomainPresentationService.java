package az.rock.auth.domain.presentation.ports.input.service.command.abstracts;

import az.rock.auth.domain.presentation.dto.request.CreateUserCommand;
import az.rock.auth.domain.presentation.dto.response.CreateUserResponse;
import az.rock.lib.annotation.InputPort;
import az.rock.lib.valueObject.Gender;
import az.rock.lib.valueObject.TimeZoneID;
import org.springframework.transaction.annotation.Transactional;

@InputPort
@Transactional
public interface AbstractUserCommandDomainPresentationService {
    void createJobSeeker(CreateUserCommand createUserCommand);

    void createCompany(CreateUserCommand createUserCommand);

    void changeFirstName(String firstName);

    void changeLastName(String lastName);

    void changeUsername(String username);

    void changeGender(Gender gender);

    void changeTimezone(TimeZoneID timezone);
}
