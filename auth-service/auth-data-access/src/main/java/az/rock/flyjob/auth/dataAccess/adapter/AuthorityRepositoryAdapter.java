package az.rock.flyjob.auth.dataAccess.adapter;

import az.rock.flyjob.auth.dataAccess.repository.AuthorityJPARepository;
import org.springframework.stereotype.Component;

@Component
public class AuthorityRepositoryAdapter {
    private final AuthorityJPARepository authorityJPARepository;

    public AuthorityRepositoryAdapter(AuthorityJPARepository authorityJPARepository) {
        this.authorityJPARepository = authorityJPARepository;
    }
}
