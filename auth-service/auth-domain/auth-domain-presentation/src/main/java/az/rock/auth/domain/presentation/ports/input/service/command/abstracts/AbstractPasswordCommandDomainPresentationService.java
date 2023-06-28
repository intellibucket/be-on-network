package az.rock.auth.domain.presentation.ports.input.service.command.abstracts;

import az.rock.auth.domain.presentation.dto.request.PasswordChangeRequest;
import az.rock.lib.annotation.InputPort;
import org.springframework.transaction.annotation.Transactional;

@InputPort
@Transactional
public interface AbstractPasswordCommandDomainPresentationService {
    void changePassword(PasswordChangeRequest passwordChangeRequest);
}
