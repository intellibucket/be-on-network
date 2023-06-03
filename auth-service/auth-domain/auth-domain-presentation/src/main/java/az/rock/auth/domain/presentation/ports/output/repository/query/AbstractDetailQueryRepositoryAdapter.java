package az.rock.auth.domain.presentation.ports.output.repository.query;

import az.rock.auth.domain.presentation.ports.output.repository.AbstractCommandRepositoryAdapter;
import az.rock.auth.domain.presentation.ports.output.repository.AbstractQueryRepositoryAdapter;
import az.rock.flyjob.auth.root.detail.DetailRoot;
import az.rock.lib.annotation.OutputPort;
import az.rock.lib.domain.id.DetailID;
import az.rock.lib.domain.id.UserID;

@OutputPort
public interface AbstractDetailQueryRepositoryAdapter extends AbstractQueryRepositoryAdapter<DetailRoot, DetailID, UserID> {
}
