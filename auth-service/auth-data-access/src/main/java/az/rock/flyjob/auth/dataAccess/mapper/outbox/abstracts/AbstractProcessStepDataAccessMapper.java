package az.rock.flyjob.auth.dataAccess.mapper.outbox.abstracts;

import az.rock.flyjob.auth.dataAccess.model.entity.outbox.ProcessStepEntity;
import az.rock.lib.domain.outbox.ProcessStepRoot;
import com.intellibucket.lib.fj.dataaccess.AbstractDataAccessMapper;

public interface AbstractProcessStepDataAccessMapper extends AbstractDataAccessMapper<ProcessStepEntity, ProcessStepRoot> {
}
