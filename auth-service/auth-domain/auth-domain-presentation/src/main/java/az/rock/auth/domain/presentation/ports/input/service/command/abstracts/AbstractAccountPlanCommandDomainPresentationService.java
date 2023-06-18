package az.rock.auth.domain.presentation.ports.input.service.command.abstracts;

import az.rock.lib.valueObject.CustomBugReport;

public interface AbstractAccountPlanCommandDomainPresentationService {
    void updatePlanToBasic();

    void updatePlanToUltimate();

    void updatePlanToBasicDemo();

    void updatePlanToUltimateDemo();

    void cancelCurrentPlan();

    void reportBug(CustomBugReport report);
}
