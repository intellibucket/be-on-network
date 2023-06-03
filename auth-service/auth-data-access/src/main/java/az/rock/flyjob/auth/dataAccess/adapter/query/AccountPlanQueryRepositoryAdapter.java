package az.rock.flyjob.auth.dataAccess.adapter.query;

import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractAccountPlanQueryRepositoryAdapter;
import az.rock.flyjob.auth.root.user.AccountPlanRoot;
import az.rock.lib.domain.id.AccountPlanID;
import az.rock.lib.domain.id.UserID;

public class AccountPlanQueryRepositoryAdapter implements AbstractAccountPlanQueryRepositoryAdapter {
    @Override
    public AccountPlanRoot findById(AccountPlanID rootId) {
        return null;
    }

    @Override
    public AccountPlanRoot findByPID(UserID parentID) {
        return null;
    }
}
