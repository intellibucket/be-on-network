package az.rock.flyjob.js.dataaccess.repository.abstracts.command;

import az.rock.flyjob.js.domain.core.root.ResumeRoot;

import java.util.Optional;

public interface AbstractContactCommandJPARepository {
    Optional<ResumeRoot> create(ResumeRoot root);

}
