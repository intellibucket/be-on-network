package az.rock.auth.domain.presentation.ports.output.repository;

import az.rock.lib.annotation.OutputPort;

import java.util.Optional;

@OutputPort
public interface AbstractCommandRepositoryAdapter<R> {
    Optional<R> create(R root);
}
