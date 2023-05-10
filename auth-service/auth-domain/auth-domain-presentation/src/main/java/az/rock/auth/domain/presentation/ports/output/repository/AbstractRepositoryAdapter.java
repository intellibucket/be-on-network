package az.rock.auth.domain.presentation.ports.output.repository;

public interface AbstractRepositoryAdapter<R> {
    R create(R root) ;
}
