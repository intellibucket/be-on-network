package az.rock.flyjob.auth.dataAccess.mapper.concretes;

import az.rock.flyjob.auth.dataAccess.entity.EmailEntity;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractDataAccessMapper;
import az.rock.flyjob.auth.root.EmailRoot;
import org.springframework.stereotype.Component;

@Component
public class EmailDataAccessMapper  implements AbstractDataAccessMapper<EmailEntity, EmailRoot> {
    @Override
    public EmailRoot toRoot(EmailEntity entity) {
        return null;
    }

    @Override
    public EmailEntity toEntity(EmailRoot root) {
        return null;
    }

    @Override
    public EmailEntity toNewEntity(EmailRoot root) {
        return null;
    }
}

