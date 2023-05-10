package az.rock.flyjob.auth.dataAccess.mapper.abstracts;

public interface AbstractDataAccessMapper <E,R>{
    R toRoot(E entity);
    E toEntity(R root);
    E toNewEntity(R root);
}
