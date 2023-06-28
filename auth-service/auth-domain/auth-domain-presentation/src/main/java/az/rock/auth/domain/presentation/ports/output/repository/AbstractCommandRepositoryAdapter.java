package az.rock.auth.domain.presentation.ports.output.repository;

import az.rock.flyjob.auth.root.user.EmailRoot;
import az.rock.flyjob.auth.root.user.UserRoot;
import az.rock.lib.annotation.OutputPort;

import java.util.List;
import java.util.Optional;

@OutputPort
public interface AbstractCommandRepositoryAdapter<R> {
    Optional<R> create(R root);

    default void update(R root){
        throw new UnsupportedOperationException();
    }

    default void updateAll(List<EmailRoot> emailRoots){
        throw new UnsupportedOperationException();
    }

    default void delete(R root){
        throw new UnsupportedOperationException();
    }
}
