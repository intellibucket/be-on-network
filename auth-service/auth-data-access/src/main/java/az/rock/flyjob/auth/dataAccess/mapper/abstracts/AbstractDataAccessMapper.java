package az.rock.flyjob.auth.dataAccess.mapper.abstracts;

import java.util.Optional;

public interface AbstractDataAccessMapper <E,R>{
    Optional<R> toRoot(E entity);
    Optional<E> toEntity(R root);
    Optional<E> toNewEntity(R root);
}
