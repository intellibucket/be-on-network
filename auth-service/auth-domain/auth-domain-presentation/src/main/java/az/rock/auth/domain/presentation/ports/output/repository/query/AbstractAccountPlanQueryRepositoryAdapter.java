package az.rock.auth.domain.presentation.ports.output.repository.query;

import az.rock.auth.domain.presentation.ports.output.repository.AbstractQueryRepositoryAdapter;
import az.rock.flyjob.auth.root.user.AccountPlanRoot;
import az.rock.lib.annotation.OutputPort;
import az.rock.lib.domain.id.AccountPlanID;
import az.rock.lib.domain.id.UserID;

import java.util.List;
import java.util.Optional;

@OutputPort
public interface AbstractAccountPlanQueryRepositoryAdapter extends AbstractQueryRepositoryAdapter<AccountPlanRoot, AccountPlanID, UserID> {
    List<AccountPlanRoot> findByPIDAndInActiveStatus(UserID parentID);
    List<AccountPlanRoot> findAllByPIDAndActiveStatus(UserID parentID);

    List<AccountPlanRoot> findAllUnCompletedAccountPlanByPID(UserID parentID);
}
