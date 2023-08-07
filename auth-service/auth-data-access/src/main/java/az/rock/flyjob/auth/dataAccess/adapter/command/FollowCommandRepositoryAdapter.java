package az.rock.flyjob.auth.dataAccess.adapter.command;

import az.rock.auth.domain.presentation.ports.output.repository.command.AbstractFollowCommandRepositoryAdapter;
import az.rock.flyjob.auth.root.network.FollowRelationRoot;
import az.rock.flyjob.auth.root.user.EmailRoot;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class FollowCommandRepositoryAdapter implements AbstractFollowCommandRepositoryAdapter {
    @Override
    public Optional<FollowRelationRoot> create(FollowRelationRoot root) {
        return Optional.empty();
    }

    @Override
    public void update(FollowRelationRoot root) {
        AbstractFollowCommandRepositoryAdapter.super.update(root);
    }

    @Override
    public void updateAll(List<EmailRoot> emailRoots) {
        AbstractFollowCommandRepositoryAdapter.super.updateAll(emailRoots);
    }

    @Override
    public void delete(FollowRelationRoot root) {
        AbstractFollowCommandRepositoryAdapter.super.delete(root);
    }
}
