package az.rock.flyjob.auth.dataAccess.mapper.abstracts;

import az.rock.lib.domain.AggregateRoot;
import com.intellibucket.lib.fj.dataaccess.AbstractDataAccessMapper;

public interface AbstractUserDataAccessMapper <E,R extends AggregateRoot<?>> extends AbstractDataAccessMapper<E,R>{
}