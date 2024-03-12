package az.rock.flyjob.js.dataaccess.mapper.abstracts;

import az.rock.lib.domain.AggregateRoot;
import com.intellibucket.lib.fj.dataaccess.AbstractDataAccessMapper;

public interface AbstractInterestDataAccessMapper  <E,R extends AggregateRoot<?>> extends AbstractDataAccessMapper<E,R> {
}
