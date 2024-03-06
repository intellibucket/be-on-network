package az.rock.auth.domain.presentation.handler.concretes;

import az.rock.auth.domain.presentation.handler.abstracts.AbstractDetailCreateCommandHandler;
import az.rock.auth.domain.presentation.mapper.abstracts.AbstractDetailDomainMapper;
import az.rock.auth.domain.presentation.ports.output.repository.command.AbstractDetailCommandRepositoryAdapter;
import az.rock.flyjob.auth.event.DetailCreatedEvent;
import az.rock.flyjob.auth.model.root.user.UserRoot;
import az.rock.flyjob.auth.service.abstracts.AbstractDetailDomainService;
import org.springframework.stereotype.Component;

@Component
public class DetailCreateCommandHandler implements AbstractDetailCreateCommandHandler {

    private final AbstractDetailDomainService detailDomainService;

    private final AbstractDetailDomainMapper detailDomainMapper;

    private final AbstractDetailCommandRepositoryAdapter detailCommandRepositoryAdapter;

    public DetailCreateCommandHandler(AbstractDetailDomainService detailDomainService,
                                      AbstractDetailDomainMapper detailDomainMapper,
                                      AbstractDetailCommandRepositoryAdapter detailCommandRepositoryAdapter) {
        this.detailDomainService = detailDomainService;
        this.detailDomainMapper = detailDomainMapper;
        this.detailCommandRepositoryAdapter = detailCommandRepositoryAdapter;
    }


    @Override
    public DetailCreatedEvent handle(UserRoot userRoot) {
        return null;
    }
}
