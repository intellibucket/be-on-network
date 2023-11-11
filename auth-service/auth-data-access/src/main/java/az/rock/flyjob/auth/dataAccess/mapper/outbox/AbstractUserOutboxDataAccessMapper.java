package az.rock.flyjob.auth.dataAccess.mapper.outbox;

import az.rock.flyjob.auth.dataAccess.model.entity.outbox.UserOutboxEntity;
import az.rock.flyjob.auth.model.root.UserOutboxRoot;
import com.intellibucket.lib.fj.dataaccess.AbstractDataAccessMapper;

public interface AbstractUserOutboxDataAccessMapper  extends AbstractDataAccessMapper<UserOutboxEntity, UserOutboxRoot> {
}
