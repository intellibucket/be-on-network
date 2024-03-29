package az.rock.lib.adapter.repository;

import az.rock.lib.annotation.DomainOutputPort;

import java.util.List;
import java.util.Optional;

@DomainOutputPort
public interface AbstractQueryRepositoryAdapter<R, ID, PID> {
    default Optional<R> findOwnByID(PID parentID, ID rootId) {
        return Optional.empty();
    }

    Optional<R> findById(ID rootId);

    default Optional<R> findByPID(PID parentID) {
        return Optional.empty();
    }

    default List<R> findAllByPID(PID parentID) {
        return List.of();
    }
}
