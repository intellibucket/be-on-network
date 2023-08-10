package az.rock.flyjob.auth.dataAccess.adapter.command;

import az.rock.auth.domain.presentation.ports.output.repository.command.AbstractFollowCommandRepositoryAdapter;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractDataAccessMapper;
import az.rock.flyjob.auth.dataAccess.mapper.concretes.FollowDataAccessMapper;
import az.rock.flyjob.auth.dataAccess.model.entity.network.FollowRelationEntity;
import az.rock.flyjob.auth.dataAccess.repository.abstracts.command.network.AbstractFollowCommandCustomJPARepository;
//import az.rock.flyjob.auth.dataAccess.repository.abstracts.command.network.FollowCommandJPARepository;
import az.rock.flyjob.auth.root.network.FollowRelationRoot;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FollowCommandRepositoryAdapter implements AbstractFollowCommandRepositoryAdapter {

    private final AbstractFollowCommandCustomJPARepository followCommandJPARepository;

    private final AbstractDataAccessMapper<FollowRelationEntity,FollowRelationRoot> followDataAccessMapper;


    public FollowCommandRepositoryAdapter(AbstractFollowCommandCustomJPARepository followCommandJPARepository,
                                          FollowDataAccessMapper followDataAccessMapper){
        this.followCommandJPARepository = followCommandJPARepository;
        this.followDataAccessMapper = followDataAccessMapper;
    }

    @Override
    public Optional<FollowRelationRoot> create(FollowRelationRoot root) {
        return Optional.empty();
    }


//    @Override
//    public Optional<FollowRelationRoot> create(FollowRelationRoot root) {
//        var optionalRoot = Optional.ofNullable(root);
//        var optionalEntity = this.followDataAccessMapper.toEntity(optionalRoot.get());
//        if (optionalEntity.isPresent()) {
//            var savedEntity = this.followCommandJPARepository.persist(optionalEntity.get());
//        //    return this.accountPlanDataAccessMapper.toRoot(savedEntity);
//        }
//        return Optional.empty();
//    }

//    @Override
//    public void update(FollowRelationRoot root) {
//        AbstractFollowCommandRepositoryAdapter.super.update(root);
//    }
//
//    @Override
//    public void updateAll(List<EmailRoot> emailRoots) {
//        AbstractFollowCommandRepositoryAdapter.super.updateAll(emailRoots);
//    }
//
//    @Override
//    public void delete(FollowRelationRoot root) {
//        AbstractFollowCommandRepositoryAdapter.super.delete(root);
//    }
}
