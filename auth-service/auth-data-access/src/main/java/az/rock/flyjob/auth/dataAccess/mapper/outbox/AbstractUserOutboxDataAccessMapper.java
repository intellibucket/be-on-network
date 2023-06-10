package az.rock.flyjob.auth.dataAccess.mapper.outbox;

import az.rock.flyjob.auth.dataAccess.entity.outbox.UserOutboxEntity;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractDataAccessMapper;
import az.rock.flyjob.auth.root.UserOutboxRoot;

public interface AbstractUserOutboxDataAccessMapper  extends AbstractDataAccessMapper<UserOutboxEntity, UserOutboxRoot> {
}
