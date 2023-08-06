package az.rock.flyjob.mapper;

import java.util.Optional;

public interface AbstractDataAccessMapper<E,R>{
    Optional<R> toRoot(E entity);
    Optional<E> toEntity(R root);
}
