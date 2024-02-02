package az.rock.flyjob.auth.dataAccess.mapper.outbox.abstracts;

import az.rock.flyjob.auth.dataAccess.model.entity.outbox.FailOutboxEntity;
import az.rock.lib.domain.outbox.FailOutboxRoot;
import com.intellibucket.lib.fj.dataaccess.AbstractDataAccessMapper;

public interface AbstractFailOutboxDataAccessMapper extends AbstractDataAccessMapper<FailOutboxEntity, FailOutboxRoot> {
}
