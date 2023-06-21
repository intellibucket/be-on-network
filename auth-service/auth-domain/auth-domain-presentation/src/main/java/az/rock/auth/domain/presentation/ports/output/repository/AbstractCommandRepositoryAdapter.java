package az.rock.auth.domain.presentation.ports.output.repository;

import az.rock.flyjob.auth.root.user.UserRoot;
import az.rock.lib.annotation.OutputPort;

import java.util.Optional;

@OutputPort
public interface AbstractCommandRepositoryAdapter<R> {
    Optional<R> create(R root);

    default void update(R root){
        throw new UnsupportedOperationException();
    }
}
