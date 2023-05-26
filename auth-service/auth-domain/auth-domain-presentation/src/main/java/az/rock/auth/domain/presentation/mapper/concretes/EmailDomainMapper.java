package az.rock.auth.domain.presentation.mapper.concretes;

import az.rock.auth.domain.presentation.mapper.abstracts.AbstractEmailDomainMapper;
import az.rock.flyjob.auth.root.EmailRoot;

public class EmailDomainMapper implements AbstractEmailDomainMapper {
    @Override
    public EmailRoot toNewEmailRoot(String email) {
        return null;
    }
}
