package az.rock.flyjob.auth.dataAccess.adapter.command;

import az.rock.auth.domain.presentation.ports.output.repository.command.AbstractBlockRelationCommandRepositoryAdapter;
import az.rock.flyjob.auth.dataAccess.mapper.concretes.BlockRelationDataAccessMapper;
import az.rock.flyjob.auth.dataAccess.model.entity.network.BlockRelationEntity;
import az.rock.flyjob.auth.dataAccess.repository.abstracts.command.AbstractBlockRelationCommandCustomJPARepository;
import az.rock.flyjob.auth.model.root.network.BlockRelationRoot;
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
    public void updateAll(List<BlockRelationRoot> roots) {
        var rootList = roots
                .stream()
                .map(this.blockRelationDataAccessMapper::toEntity)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
        this.blockRelationCommandCustomJPARepository.updateAll(rootList);
    }

    @Override
    public void inActive(BlockRelationRoot root) {
        var entity = this.blockRelationDataAccessMapper.toEntity(root);
        entity.ifPresent(this.blockRelationCommandCustomJPARepository::inActive);
    }
}
