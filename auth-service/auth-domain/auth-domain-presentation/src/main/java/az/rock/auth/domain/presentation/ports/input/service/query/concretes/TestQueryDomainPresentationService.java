package az.rock.auth.domain.presentation.ports.input.service.query.concretes;

import az.rock.auth.domain.presentation.ports.input.service.query.abstracts.AbstractTestQueryDomainPresentationService;
import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractTestQueryRepositoryAdapter;
import az.rock.lib.annotation.InputPort;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@InputPort
public class TestQueryDomainPresentationService implements AbstractTestQueryDomainPresentationService {
    private final AbstractTestQueryRepositoryAdapter abstractTestQueryRepositoryAdapter;

    public TestQueryDomainPresentationService(AbstractTestQueryRepositoryAdapter abstractTestQueryRepositoryAdapter) {
        this.abstractTestQueryRepositoryAdapter = abstractTestQueryRepositoryAdapter;
    }

    @Override
    public void case1(UUID userId) {
        abstractTestQueryRepositoryAdapter.case1(userId);
    }
}
