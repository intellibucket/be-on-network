package az.rock.flyjob.auth.dataAccess.adapter;

import az.rock.flyjob.auth.dataAccess.mapper.AuthorityDataAccessMapper;
import az.rock.flyjob.auth.dataAccess.repository.AuthorityJPARepository;
import org.springframework.stereotype.Component;

@Component
public class AuthorityRepositoryAdapter {
    private final AuthorityJPARepository authorityJPARepository;

    private final AuthorityDataAccessMapper authorityDataAccessMapper;
    public AuthorityRepositoryAdapter(AuthorityJPARepository authorityJPARepository,
                                      AuthorityDataAccessMapper authorityDataAccessMapper) {
        this.authorityJPARepository = authorityJPARepository;
        this.authorityDataAccessMapper = authorityDataAccessMapper;
    }
}
