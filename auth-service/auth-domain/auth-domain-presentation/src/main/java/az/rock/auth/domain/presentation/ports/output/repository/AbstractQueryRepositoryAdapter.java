package az.rock.auth.domain.presentation.ports.output.repository;

import az.rock.lib.annotation.OutputPort;

import java.util.List;

@OutputPort
public interface AbstractQueryRepositoryAdapter<R,ID, PID> {
    R findById(ID rootId);
    R findByPID(PID parentID);
    default List<R> findAllByPID(PID parentID){return List.of();}
}
