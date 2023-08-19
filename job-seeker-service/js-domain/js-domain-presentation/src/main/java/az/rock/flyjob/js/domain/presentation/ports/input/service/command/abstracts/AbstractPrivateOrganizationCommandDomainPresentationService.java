package az.rock.flyjob.js.domain.presentation.ports.input.service.command.abstracts;

public interface AbstractPrivateOrganizationCommandDomainPresentationService {
    void searchJob();
    void addJob();
    void deleteJob();
    void upgradeJobToUltimate();
}
