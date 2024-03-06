package az.rock.auth.domain.presentation.ports.output.repository.command;

import az.rock.flyjob.auth.model.root.user.AccountPlanRoot;
import az.rock.lib.adapter.repository.AbstractCommandRepositoryAdapter;
import az.rock.lib.annotation.DomainOutputPort;

@DomainOutputPort
public interface AbstractAccountPlanCommandRepositoryAdapter extends AbstractCommandRepositoryAdapter<AccountPlanRoot> {
}
