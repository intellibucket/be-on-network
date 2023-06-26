package az.rock.flyjob.auth.dataAccess.repository.abstracts.command.email;

import az.rock.flyjob.auth.dataAccess.entity.user.EmailEntity;
import az.rock.flyjob.auth.dataAccess.repository.abstracts.BaseCustomRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface AbstractEmailCommandCustomJPARepository extends BaseCustomRepository<EmailEntity> {
}
