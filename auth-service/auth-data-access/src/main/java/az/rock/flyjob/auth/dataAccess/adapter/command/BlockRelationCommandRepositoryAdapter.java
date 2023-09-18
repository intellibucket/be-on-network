package az.rock.flyjob.auth.dataAccess.adapter.command;

import az.rock.auth.domain.presentation.ports.output.repository.command.AbstractBlockRelationCommandRepositoryAdapter;
import az.rock.flyjob.auth.dataAccess.mapper.concretes.BlockRelationDataAccessMapper;
import az.rock.flyjob.auth.dataAccess.model.entity.network.BlockRelationEntity;
import az.rock.flyjob.auth.dataAccess.repository.abstracts.command.AbstractBlockRelationCommandCustomJPARepository;
import az.rock.flyjob.auth.root.network.BlockRelationRoot;
import az.rock.flyjob.auth.root.user.EmailRoot;
import com.intellibucket.lib.fj.dataaccess.AbstractDataAccessMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BlockRelationCommandRepositoryAdapter implements AbstractBlockRelationCommandRepositoryAdapter {

    private final AbstractBlockRelationCommandCustomJPARepository blockRelationCommandCustomJPARepository;

    private final AbstractDataAccessMapper<BlockRelationEntity, BlockRelationRoot> blockRelationDataAccessMapper;


    public BlockRelationCommandRepositoryAdapter(AbstractBlockRelationCommandCustomJPARepository blockRelationCommandCustomJPARepository,
                                          BlockRelationDataAccessMapper blockRelationDataAccessMapper){
        this.blockRelationCommandCustomJPARepository = blockRelationCommandCustomJPARepository;
        this.blockRelationDataAccessMapper = blockRelationDataAccessMapper;
    }

    @Override
    public Optional<BlockRelationRoot> create(BlockRelationRoot root) {
        var entity = this.blockRelationDataAccessMapper.toEntity(root);
        if (entity.isPresent()) {
            var savedEntity = this.blockRelationCommandCustomJPARepository.persist(entity.get());
            return this.blockRelationDataAccessMapper.toRoot(savedEntity);
        }
        return Optional.empty();
    }
    @Override
    public void update(BlockRelationRoot root) {
        var entity = this.blockRelationDataAccessMapper.toEntity(root);
        entity.ifPresent(this.blockRelationCommandCustomJPARepository::update);
    }

    @Override
    public void updateAll(List<EmailRoot> emailRoots) {
        AbstractBlockRelationCommandRepositoryAdapter.super.updateAll(emailRoots);
    }

    @Override
    public void delete(BlockRelationRoot root) {
        var entity = this.blockRelationDataAccessMapper.toEntity(root);
        entity.ifPresent(this.blockRelationCommandCustomJPARepository::remove);
    }
}
