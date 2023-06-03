package az.rock.flyjob.auth.dataAccess.adapter;

import az.rock.auth.domain.presentation.ports.output.repository.command.AbstractAuthorityCommandRepositoryAdapter;
import az.rock.flyjob.auth.dataAccess.mapper.concretes.AuthorityDataAccessMapper;
import az.rock.flyjob.auth.dataAccess.repository.AuthorityJPARepository;
import az.rock.flyjob.auth.root.AuthorityRoot;
import org.springframework.stereotype.Component;

@Component
public class AuthorityRepositoryAdapter implements AbstractAuthorityCommandRepositoryAdapter {
    private final AuthorityJPARepository authorityJPARepository;

    private final AuthorityDataAccessMapper authorityDataAccessMapper;
    public AuthorityRepositoryAdapter(AuthorityJPARepository authorityJPARepository,
                                      AuthorityDataAccessMapper authorityDataAccessMapper) {
        this.authorityJPARepository = authorityJPARepository;
        this.authorityDataAccessMapper = authorityDataAccessMapper;
    }

    @Override
    public AuthorityRoot create(AuthorityRoot root) {
        var entity = this.authorityDataAccessMapper.toNewEntity(root);
        var savedEntity  = this.authorityJPARepository.save(entity);
        return this.authorityDataAccessMapper.toRoot(savedEntity);
    }
}
