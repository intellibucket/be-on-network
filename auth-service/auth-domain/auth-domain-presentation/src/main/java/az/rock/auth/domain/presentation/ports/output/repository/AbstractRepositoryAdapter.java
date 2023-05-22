package az.rock.auth.domain.presentation.ports.output.repository;

import java.util.Optional;

public interface AbstractRepositoryAdapter<R> {
    R create(R root) ;
}
