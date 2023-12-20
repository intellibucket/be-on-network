package az.rock.flyjob.auth.dataAccess.mapper.outbox;

import az.rock.flyjob.auth.dataAccess.model.entity.outbox.ProcessOutboxEntity;
import az.rock.flyjob.auth.model.root.UserOutboxRoot;
import com.intellibucket.lib.fj.dataaccess.AbstractDataAccessMapper;

public interface AbstractUserOutboxDataAccessMapper extends AbstractDataAccessMapper<ProcessOutboxEntity, UserOutboxRoot> {
}
