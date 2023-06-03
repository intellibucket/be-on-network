package az.rock.auth.domain.presentation.handler.concretes;

import az.rock.auth.domain.presentation.handler.abstracts.AbstractDetailCreateCommandHandler;
import az.rock.auth.domain.presentation.mapper.abstracts.AbstractDetailDomainMapper;
import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractDetailQueryRepositoryAdapter;
import az.rock.flyjob.auth.event.DetailCreatedEvent;
import az.rock.flyjob.auth.root.user.UserRoot;
import az.rock.flyjob.auth.service.abstracts.AbstractDetailDomainService;
import org.springframework.stereotype.Component;

@Component
public class DetailCreateCommandHandler implements AbstractDetailCreateCommandHandler {

    private final AbstractDetailDomainService detailDomainService;

    private final AbstractDetailDomainMapper detailDomainMapper;

    private final AbstractDetailQueryRepositoryAdapter detailRepositoryAdapter;

    public DetailCreateCommandHandler(AbstractDetailDomainService detailDomainService,
                                      AbstractDetailDomainMapper detailDomainMapper,
                                      AbstractDetailQueryRepositoryAdapter detailRepositoryAdapter) {
        this.detailDomainService = detailDomainService;
        this.detailDomainMapper = detailDomainMapper;
        this.detailRepositoryAdapter = detailRepositoryAdapter;
    }


    @Override
    public DetailCreatedEvent handle(UserRoot userRoot) {
        return null;
    }
}
