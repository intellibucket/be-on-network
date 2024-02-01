package az.rock.flyjob.auth.dataAccess.mapper.outbox;

import az.rock.flyjob.auth.dataAccess.model.entity.outbox.ProcessOutboxEntity;
import az.rock.lib.domain.outbox.ProcessOutboxRoot;
import com.intellibucket.lib.fj.dataaccess.AbstractDataAccessMapper;

public interface AbstractProcessOutboxDataAccessMapper extends AbstractDataAccessMapper<ProcessOutboxEntity, ProcessOutboxRoot> {
}
