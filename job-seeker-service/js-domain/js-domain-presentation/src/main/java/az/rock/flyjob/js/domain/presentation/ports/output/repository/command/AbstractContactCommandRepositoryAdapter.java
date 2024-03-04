package az.rock.flyjob.js.domain.presentation.ports.output.repository.command;

import az.rock.flyjob.js.domain.core.root.ResumeRoot;

import java.util.Optional;

public interface AbstractContactCommandRepositoryAdapter {
    Optional<ResumeRoot> create(ResumeRoot root);

}
