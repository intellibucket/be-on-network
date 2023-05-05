package az.rock.lib.mapper;

public interface JDataAccessMapper <E,R>{
    E rootToEntity(R root);
    E rootToNewEntity(R root);
    R entityToRoot(E entity);
}