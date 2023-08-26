package az.rock.flyjob.js.domain.presentation.ports.input.services.command.concretes;

import az.rock.flyjob.js.domain.presentation.ports.input.services.command.abstracts.AbstractOrganizationCommandDomainPresentationService;
import org.springframework.stereotype.Service;

@Service
public class OrganizationCommandDomainPresentationService implements AbstractOrganizationCommandDomainPresentationService {

    @Override
    public void createOrganization() {
        this.createOrganization();
    }

    @Override
    public void updateOrganization() {
        this.updateOrganization();
    }

    @Override
    public void deleteOrganization() {
        this.deleteOrganization();
    }

    @Override
    public void reorderOrganization() {
        this.reorderOrganization();
    }
}
