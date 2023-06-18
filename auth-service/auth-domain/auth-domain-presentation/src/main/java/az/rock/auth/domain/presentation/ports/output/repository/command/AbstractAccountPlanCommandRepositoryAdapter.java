package az.rock.auth.domain.presentation.ports.output.repository.command;

import az.rock.auth.domain.presentation.ports.output.repository.AbstractCommandRepositoryAdapter;
import az.rock.flyjob.auth.root.user.AccountPlanRoot;
import az.rock.lib.annotation.OutputPort;

@OutputPort
public interface AbstractAccountPlanCommandRepositoryAdapter extends AbstractCommandRepositoryAdapter<AccountPlanRoot> {
}
