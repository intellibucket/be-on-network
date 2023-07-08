package az.rock.auth.domain.presentation.handler.concretes;

import az.rock.auth.domain.presentation.context.AbstractSecurityContextHolder;
import az.rock.auth.domain.presentation.dto.request.PasswordChangeRequest;
import az.rock.auth.domain.presentation.exception.UnknownSystemException;
import az.rock.auth.domain.presentation.handler.abstracts.AbstractPasswordUpdateCommandHandler;
import az.rock.auth.domain.presentation.mapper.abstracts.AbstractPasswordDomainMapper;
import az.rock.auth.domain.presentation.ports.output.repository.command.AbstractPasswordCommandRepositoryAdapter;
import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractPasswordQueryRepositoryAdapter;
import az.rock.flyjob.auth.event.PasswordUpdatedEvent;
import az.rock.flyjob.auth.root.user.PasswordProxyRoot;
import az.rock.flyjob.auth.service.abstracts.AbstractPasswordDomainService;
import org.springframework.stereotype.Component;

@Component
public class PasswordUpdateCommandHandler implements AbstractPasswordUpdateCommandHandler {
    private final AbstractSecurityContextHolder securityContextHolder;

    private final AbstractPasswordQueryRepositoryAdapter passwordQueryRepositoryAdapter;

    private final AbstractPasswordCommandRepositoryAdapter passwordCommandRepositoryAdapter;

    private final AbstractPasswordDomainService passwordDomainService;

    private final AbstractPasswordDomainMapper passwordDomainMapper;

    public PasswordUpdateCommandHandler(AbstractSecurityContextHolder securityContextHolder,
                                        AbstractPasswordQueryRepositoryAdapter passwordQueryRepositoryAdapter,
                                        AbstractPasswordCommandRepositoryAdapter passwordCommandRepositoryAdapter,
                                        AbstractPasswordDomainService passwordDomainService,
                                        AbstractPasswordDomainMapper passwordDomainMapper) {
        this.securityContextHolder = securityContextHolder;
        this.passwordQueryRepositoryAdapter = passwordQueryRepositoryAdapter;
        this.passwordCommandRepositoryAdapter = passwordCommandRepositoryAdapter;
        this.passwordDomainService = passwordDomainService;
        this.passwordDomainMapper = passwordDomainMapper;
    }

    @Override
    public PasswordUpdatedEvent handlePasswordChanged(PasswordChangeRequest passwordChangeRequest) {
        // FIXME: 28.06.23
        var currentUserId = this.securityContextHolder.availableUser();
        var currentPassword = this.passwordQueryRepositoryAdapter.findByPID(currentUserId);
        if (currentPassword.isPresent()) {
            var passwordRoot = currentPassword.get();
            var newPassword  = this.passwordDomainMapper.generatePasswordRoot(currentUserId,passwordChangeRequest.newPassword());
            this.passwordDomainService.validateAndInitialize(currentUserId,passwordRoot, newPassword);
            this.passwordCommandRepositoryAdapter.delete(passwordRoot);
            this.passwordCommandRepositoryAdapter.create(newPassword);
            return PasswordUpdatedEvent.of(PasswordProxyRoot.of(newPassword));
        }else throw new UnknownSystemException();
    }
}
