package az.rock.auth.domain.presentation.ports.output.repository;

import az.rock.lib.annotation.DomainOutputPort;

import java.util.List;
import java.util.Optional;

@DomainOutputPort
public interface AbstractCommandRepositoryAdapter<R> {
    Optional<R> create(R root);

    default void update(R root){
        throw new UnsupportedOperationException();
    }

    default void updateAll(List<R> emailRoots){
        throw new UnsupportedOperationException();
    }

    default void inActive(R root){
        throw new UnsupportedOperationException();
    }

    default void deleteAll(List<R> roots){
        throw new UnsupportedOperationException();
    }
}
