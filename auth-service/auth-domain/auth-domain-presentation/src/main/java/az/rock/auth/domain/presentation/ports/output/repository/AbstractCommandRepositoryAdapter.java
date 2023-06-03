package az.rock.auth.domain.presentation.ports.output.repository;

import az.rock.lib.annotation.OutputPort;

@OutputPort
public interface AbstractCommandRepositoryAdapter<R> {
    R create(R root);
}
