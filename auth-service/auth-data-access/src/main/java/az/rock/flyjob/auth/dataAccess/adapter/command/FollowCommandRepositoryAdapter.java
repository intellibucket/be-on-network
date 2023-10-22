package az.rock.flyjob.auth.dataAccess.adapter.command;

import az.rock.auth.domain.presentation.ports.output.repository.command.AbstractFollowRelationCommandRepositoryAdapter;
import az.rock.flyjob.auth.dataAccess.mapper.concretes.FollowDataAccessMapper;
import az.rock.flyjob.auth.dataAccess.model.entity.network.FollowRelationEntity;
import az.rock.flyjob.auth.dataAccess.repository.abstracts.command.AbstractFollowRelationCommandCustomJPARepository;
//import az.rock.flyjob.auth.dataAccess.repository.abstracts.command.network.FollowCommandJPARepository;
import az.rock.flyjob.auth.root.network.FollowRelationRoot;
import com.intellibucket.lib.fj.dataaccess.AbstractDataAccessMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FollowCommandRepositoryAdapter implements AbstractFollowRelationCommandRepositoryAdapter {

    private final AbstractFollowRelationCommandCustomJPARepository followCommandCustomJPARepository;

    private final AbstractDataAccessMapper<FollowRelationEntity,FollowRelationRoot> followDataAccessMapper;


    public FollowCommandRepositoryAdapter(AbstractFollowRelationCommandCustomJPARepository followCommandCustomJPARepository,
                                          FollowDataAccessMapper followDataAccessMapper){
        this.followCommandCustomJPARepository = followCommandCustomJPARepository;
        this.followDataAccessMapper = followDataAccessMapper;
    }

    @Override
    public Optional<FollowRelationRoot> create(FollowRelationRoot root) {
        var entity = this.followDataAccessMapper.toEntity(root);
        if (entity.isPresent()) {
            var savedEntity = this.followCommandCustomJPARepository.persist(entity.get());
            return this.followDataAccessMapper.toRoot(savedEntity);
        }
        return Optional.empty();
    }
    @Override
    public void update(FollowRelationRoot root) {
        var entity = this.followDataAccessMapper.toEntity(root);
        entity.ifPresent(this.followCommandCustomJPARepository::update);
    }

    @Override
    public void delete(FollowRelationRoot root) {
        var entity = this.followDataAccessMapper.toEntity(root);
        entity.ifPresent(this.followCommandCustomJPARepository::inActive);
    }


}
