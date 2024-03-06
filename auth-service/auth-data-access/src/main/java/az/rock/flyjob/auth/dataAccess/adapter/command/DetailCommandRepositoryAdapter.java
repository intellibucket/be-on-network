package az.rock.flyjob.auth.dataAccess.adapter.command;

import az.rock.auth.domain.presentation.ports.output.repository.command.AbstractDetailCommandRepositoryAdapter;
import az.rock.flyjob.auth.dataAccess.mapper.concretes.DetailDataAccessMapper;
import az.rock.flyjob.auth.dataAccess.repository.abstracts.command.DetailCommandJPARepository;
import az.rock.flyjob.auth.model.root.detail.DetailRoot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class DetailCommandRepositoryAdapter implements AbstractDetailCommandRepositoryAdapter {
    private final DetailCommandJPARepository detailJPARepository;

    private final DetailDataAccessMapper detailDataAccessMapper;

    public DetailCommandRepositoryAdapter(DetailCommandJPARepository detailJPARepository,
                                          DetailDataAccessMapper detailDataAccessMapper) {
        this.detailJPARepository = detailJPARepository;
        this.detailDataAccessMapper = detailDataAccessMapper;
    }

    @Override
    public Optional<DetailRoot> create(DetailRoot root) {
        var entity = this.detailDataAccessMapper.toNewEntity(root);
        if (entity.isPresent()) {
            var savedEntity = this.detailJPARepository.save(entity.get());
            return this.detailDataAccessMapper.toRoot(savedEntity);
        } else return Optional.empty();
    }

    @Override
    public void rollback(DetailRoot root) {
        var optionalEntity = this.detailDataAccessMapper.toEntity(root);
        optionalEntity.ifPresentOrElse(
                (entity) -> detailJPARepository.rollback(entity.getUuid()),
                () -> log.error("User cannot rollback because of entity is null")
        );
    }
}
