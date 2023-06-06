package az.rock.auth.domain.presentation.ports.output.repository;

import az.rock.lib.annotation.OutputPort;

import java.util.List;
import java.util.Optional;

@OutputPort
public interface AbstractQueryRepositoryAdapter<R,ID, PID> {
    Optional<R> findById(ID rootId);
    Optional<R> findByPID(PID parentID);
    default List<Optional<R>> findAllByPID(PID parentID){return List.of();}
}
