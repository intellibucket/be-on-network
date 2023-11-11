package az.rock.auth.domain.presentation.ports.output.repository.query;

import az.rock.auth.domain.presentation.ports.output.repository.AbstractQueryRepositoryAdapter;
import az.rock.flyjob.auth.model.root.user.AccountPlanRoot;
import az.rock.lib.annotation.DomainOutputPort;
import az.rock.lib.domain.id.auth.AccountPlanID;
import az.rock.lib.domain.id.auth.UserID;

import java.util.List;

@DomainOutputPort
public interface AbstractAccountPlanQueryRepositoryAdapter extends AbstractQueryRepositoryAdapter<AccountPlanRoot, AccountPlanID, UserID> {
    List<AccountPlanRoot> findByPIDAndInActiveStatus(UserID parentID);
    List<AccountPlanRoot> findAllByPIDAndActiveStatus(UserID parentID);

    List<AccountPlanRoot> findAllUnCompletedAccountPlanByPID(UserID parentID);
}
