package az.rock.auth.domain.presentation.ports.output.repository.query;

import az.rock.auth.domain.presentation.ports.output.repository.AbstractQueryRepositoryAdapter;
import az.rock.flyjob.auth.root.detail.DetailRoot;
import az.rock.lib.annotation.OutputPort;
import az.rock.lib.domain.id.DetailID;
import az.rock.lib.domain.id.UserID;

import java.util.Optional;

@OutputPort
public interface AbstractDetailQueryRepositoryAdapter extends AbstractQueryRepositoryAdapter<DetailRoot, DetailID, UserID> {
    Optional<DetailRoot> findByPIDAndActiveStatus(UserID parentID);

    Optional<DetailRoot> findByIdAndActiveStatus(DetailID detailID);
}
