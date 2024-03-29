package az.rock.auth.domain.presentation.ports.input.service.command.concretes;

import az.rock.auth.domain.presentation.dto.request.PasswordChangeRequest;
import az.rock.auth.domain.presentation.exception.UnknownSystemException;
import az.rock.auth.domain.presentation.handler.abstracts.AbstractPasswordUpdateCommandHandler;
import az.rock.auth.domain.presentation.ports.input.service.command.abstracts.AbstractPasswordCommandDomainPresentationService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Validated
@Service
public class PasswordCommandDomainPresentationService implements AbstractPasswordCommandDomainPresentationService {

    private final AbstractPasswordUpdateCommandHandler passwordUpdateCommandHandler;

    public PasswordCommandDomainPresentationService(AbstractPasswordUpdateCommandHandler passwordUpdateCommandHandler) {
        this.passwordUpdateCommandHandler = passwordUpdateCommandHandler;
    }

    @Override
    public void changePassword(PasswordChangeRequest passwordChangeRequest) {
        this.passwordUpdateCommandHandler.handlePasswordChanged(passwordChangeRequest);
    }
}
