package az.rock.auth.domain.presentation.ports.output.repository.query;

import java.util.Optional;
import java.util.UUID;

public interface AbstractTestQueryRepositoryAdapter {
    Optional<?> case1(UUID userId);
}
