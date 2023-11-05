package az.rock.flyjob.auth.dataAccess.repository.abstracts.query.jooq;

import az.rock.flyjob.auth.dataAccess.model.jooq.auth.tables.Users;
import com.intellibucket.lib.fj.dataaccess.annotations.JOOQRepository;

import java.util.UUID;

@JOOQRepository
public interface AbstractUserJOOQRepository  {
    Users findUserById(UUID uuid);
}
