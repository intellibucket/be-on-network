package az.rock.auth.domain.presentation.mapper.abstracts;

import az.rock.flyjob.auth.root.user.EmailRoot;

public interface AbstractEmailDomainMapper {
    EmailRoot toNewEmailRoot(String email);
}
