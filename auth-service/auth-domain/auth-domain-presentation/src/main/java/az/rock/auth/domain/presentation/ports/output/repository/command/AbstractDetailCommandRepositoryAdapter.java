package az.rock.auth.domain.presentation.ports.output.repository.command;

import az.rock.auth.domain.presentation.ports.output.repository.AbstractCommandRepositoryAdapter;
import az.rock.flyjob.auth.root.detail.DetailRoot;
import az.rock.lib.annotation.DomainOutputPort;

@DomainOutputPort
public interface AbstractDetailCommandRepositoryAdapter extends AbstractCommandRepositoryAdapter<DetailRoot> {

}
