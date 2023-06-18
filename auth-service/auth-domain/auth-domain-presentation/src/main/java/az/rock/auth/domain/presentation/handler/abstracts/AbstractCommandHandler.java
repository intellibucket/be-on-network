package az.rock.auth.domain.presentation.handler.abstracts;

public interface AbstractCommandHandler<E, R> {
    E handle(R root);
}
