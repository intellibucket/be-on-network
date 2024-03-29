package az.rock.flyjob.auth.dataAccess.adapter.command;

import az.rock.auth.domain.presentation.ports.output.repository.command.AbstractEmailCommandRepositoryAdapter;
import az.rock.flyjob.auth.dataAccess.model.entity.user.EmailEntity;
import az.rock.flyjob.auth.dataAccess.repository.abstracts.command.email.AbstractEmailCommandCustomJPARepository;
import az.rock.flyjob.auth.model.root.user.EmailRoot;
import com.intellibucket.lib.fj.dataaccess.AbstractDataAccessMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class EmailCommandRepositoryAdapter implements AbstractEmailCommandRepositoryAdapter {

    private final AbstractEmailCommandCustomJPARepository emailCommandCustomJPARepository;
    private final AbstractDataAccessMapper<EmailEntity,EmailRoot> emailDataAccessMapper;

    public EmailCommandRepositoryAdapter(AbstractEmailCommandCustomJPARepository emailCommandCustomJPARepository,
                                         AbstractDataAccessMapper<EmailEntity, EmailRoot> emailDataAccessMapper) {
        this.emailCommandCustomJPARepository = emailCommandCustomJPARepository;
        this.emailDataAccessMapper = emailDataAccessMapper;
    }

    @Override
    public Optional<EmailRoot> create(EmailRoot root) {
        var entity = this.emailDataAccessMapper.toEntity(root);
        if (entity.isPresent()) {
            var savedEntity = this.emailCommandCustomJPARepository.persist(entity.get());
            return this.emailDataAccessMapper.toRoot(savedEntity);
        }
        return Optional.empty();
    }

    @Override
    public void update(EmailRoot root) {
        var entity = this.emailDataAccessMapper.toEntity(root);
        entity.ifPresent(this.emailCommandCustomJPARepository::update);
    }

    @Override
    public void inActive(EmailRoot root) {
        var entity = this.emailDataAccessMapper.toEntity(root);
        entity.ifPresent(this.emailCommandCustomJPARepository::inActive);
    }

    @Override
    public void updateAll(List<EmailRoot> emailRoots) {
        // FIXME: 28.06.23 updateAll method is not working because throw EntityManager is closed exception
        emailRoots.stream()
                .map(this.emailDataAccessMapper::toEntity)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .forEach(this.emailCommandCustomJPARepository::update);
    }

    @Override
    public void rollback(EmailRoot root) {
        var optionalEntity = this.emailDataAccessMapper.toEntity(root);
        optionalEntity.ifPresentOrElse(
                this.emailCommandCustomJPARepository::rollback,
                () -> log.error("User cannot rollback because of entity is null")
        );
    }
}
