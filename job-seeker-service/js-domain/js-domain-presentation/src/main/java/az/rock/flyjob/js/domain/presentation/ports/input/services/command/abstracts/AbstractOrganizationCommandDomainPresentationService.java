package az.rock.flyjob.js.domain.presentation.ports.input.services.command.abstracts;

public interface AbstractOrganizationCommandDomainPresentationService {

    void createOrganization();
    void updateOrganization();
    void deleteOrganization();
    void reorderOrganization();
}
