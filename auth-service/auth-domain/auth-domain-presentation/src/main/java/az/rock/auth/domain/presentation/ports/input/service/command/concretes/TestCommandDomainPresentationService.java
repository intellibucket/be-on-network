package az.rock.auth.domain.presentation.ports.input.service.command.concretes;

import az.rock.auth.domain.presentation.ports.input.service.command.abstracts.AbstractTestCommandDomainPresentationService;
import az.rock.auth.domain.presentation.ports.output.repository.command.AbstractUserCommandRepositoryAdapter;
import az.rock.auth.domain.presentation.ports.output.repository.query.user.AbstractUserQueryRepositoryAdapter;
import az.rock.lib.annotation.InputPort;
import az.rock.lib.domain.id.auth.UserID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@InputPort
@Service
@Slf4j
public class TestCommandDomainPresentationService implements AbstractTestCommandDomainPresentationService {
    private final AbstractUserCommandRepositoryAdapter userCommandRepositoryAdapter;
    private final AbstractUserQueryRepositoryAdapter userQueryRepositoryAdapter;

    public TestCommandDomainPresentationService(AbstractUserCommandRepositoryAdapter userCommandRepositoryAdapter,
                                                AbstractUserQueryRepositoryAdapter userQueryRepositoryAdapter) {
        this.userCommandRepositoryAdapter = userCommandRepositoryAdapter;
        this.userQueryRepositoryAdapter = userQueryRepositoryAdapter;
    }

    @Override
    public void testRollbackForUser(UUID userId) {
        this.userQueryRepositoryAdapter.fetchById(UserID.of(userId))
                .ifPresentOrElse(
                        this.userCommandRepositoryAdapter::rollback,
                        () -> log.error("User Root is empty")
                );

    }
}
