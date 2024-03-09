package az.rock.flyjob.js.dataaccess.mapper.abstracts;

import az.rock.flyjob.js.dataaccess.model.entity.resume.details.ContactEntity;
import az.rock.flyjob.js.domain.core.root.detail.ContactRoot;
import az.rock.lib.domain.AggregateRoot;
import com.intellibucket.lib.fj.dataaccess.AbstractDataAccessMapper;

public interface AbstractContactDataAccessMapper<E,R extends AggregateRoot<?>> extends AbstractDataAccessMapper<E, R> {
}
