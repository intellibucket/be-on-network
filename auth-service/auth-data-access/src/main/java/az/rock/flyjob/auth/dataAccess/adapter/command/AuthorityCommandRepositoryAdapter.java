package az.rock.flyjob.auth.dataAccess.adapter.command;

import az.rock.auth.domain.presentation.ports.output.repository.command.AbstractAuthorityCommandRepositoryAdapter;
import az.rock.flyjob.auth.dataAccess.mapper.concretes.AuthorityDataAccessMapper;
import az.rock.flyjob.auth.dataAccess.repository.abstracts.command.AuthorityCommandJPARepository;
import az.rock.flyjob.auth.root.security.AuthorityRoot;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuthorityCommandRepositoryAdapter implements AbstractAuthorityCommandRepositoryAdapter {
    private final AuthorityCommandJPARepository authorityCommandJPARepository;

    private final AuthorityDataAccessMapper authorityDataAccessMapper;
    public AuthorityCommandRepositoryAdapter(AuthorityCommandJPARepository authorityCommandJPARepository,
                                             AuthorityDataAccessMapper authorityDataAccessMapper) {
        this.authorityCommandJPARepository = authorityCommandJPARepository;
        this.authorityDataAccessMapper = authorityDataAccessMapper;
    }

    @Override
    public Optional<AuthorityRoot> create(AuthorityRoot root) {
        var optionalAuthorityEntity = this.authorityDataAccessMapper.toNewEntity(root);
        if (optionalAuthorityEntity.isPresent()) {
            var savedEntity = this.authorityCommandJPARepository.save(optionalAuthorityEntity.get());
            return this.authorityDataAccessMapper.toRoot(savedEntity);
        }else return Optional.empty();
    }
}
