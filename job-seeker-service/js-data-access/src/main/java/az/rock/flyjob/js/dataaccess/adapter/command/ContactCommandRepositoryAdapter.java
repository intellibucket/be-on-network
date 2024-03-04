package az.rock.flyjob.js.dataaccess.adapter.command;

import az.rock.flyjob.js.dataaccess.repository.abstracts.command.AbstractContactCommandJPARepository;
import az.rock.flyjob.js.dataaccess.repository.abstracts.command.AbstractResumeCommandJPARepository;
import az.rock.flyjob.js.dataaccess.repository.abstracts.command.custom.detail.AbstractContactCustomCommandJPARepository;
import az.rock.flyjob.js.domain.core.root.ResumeRoot;
import az.rock.flyjob.js.domain.presentation.mapper.abstracts.AbstractContactCommandDomainMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class ContactCommandRepositoryAdapter implements AbstractContactCommandJPARepository {
    private final AbstractContactCommandDomainMapper abstractContactCommandDomainMapper;
    private final AbstractContactCommandJPARepository abstractContactCommandJPARepository;

    public ContactCommandRepositoryAdapter(AbstractContactCommandDomainMapper abstractContactCommandDomainMapper, AbstractContactCommandJPARepository abstractContactCommandJPARepository) {
        this.abstractContactCommandDomainMapper = abstractContactCommandDomainMapper;
        this.abstractContactCommandJPARepository = abstractContactCommandJPARepository;
    }


    @Override
    public Optional<ResumeRoot> create(ResumeRoot root) {
        return Optional.empty();
    }
}
