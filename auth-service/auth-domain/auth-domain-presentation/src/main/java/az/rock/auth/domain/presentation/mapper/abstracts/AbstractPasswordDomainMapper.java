package az.rock.auth.domain.presentation.mapper.abstracts;

import az.rock.flyjob.auth.root.PasswordRoot;

public interface AbstractPasswordDomainMapper {
    PasswordRoot toNewPasswordRoot(String rawPassword);
}
