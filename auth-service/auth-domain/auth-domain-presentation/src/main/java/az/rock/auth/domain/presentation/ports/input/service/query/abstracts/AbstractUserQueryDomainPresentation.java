package az.rock.auth.domain.presentation.ports.input.service.query.abstracts;

import az.rock.auth.domain.presentation.dto.response.UserMyAccountResponse;
import az.rock.lib.annotation.InputPort;
import org.springframework.transaction.annotation.Transactional;

@InputPort
@Transactional(readOnly = true)
public interface AbstractUserQueryDomainPresentation {
    UserMyAccountResponse myAccount();
}
