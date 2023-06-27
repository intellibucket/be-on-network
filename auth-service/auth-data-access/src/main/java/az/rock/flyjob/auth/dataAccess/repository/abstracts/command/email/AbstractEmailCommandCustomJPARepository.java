package az.rock.flyjob.auth.dataAccess.repository.abstracts.command.email;

import az.rock.flyjob.auth.dataAccess.entity.user.EmailEntity;
import az.rock.flyjob.auth.dataAccess.repository.abstracts.CustomCommandJPARepository;
import org.springframework.transaction.annotation.Transactional;


public interface AbstractEmailCommandCustomJPARepository extends CustomCommandJPARepository<EmailEntity> {
}
