package az.rock.auth.domain.presentation.ports.input.service.command.concretes;

import az.rock.auth.domain.presentation.ports.input.service.command.abstracts.AbstractPasswordCommandDomainPresentationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Validated
@Service
public class PasswordCommandDomainPresentationService implements AbstractPasswordCommandDomainPresentationService {
}
