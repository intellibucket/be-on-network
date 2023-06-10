package az.rock.flyjob.auth.service.abstracts;

import az.rock.flyjob.auth.event.CompanyCreatedEvent;
import az.rock.flyjob.auth.event.JobSeekerCreatedEvent;
import az.rock.flyjob.auth.root.user.UserRoot;

public interface AbstractUserDomainService {
    JobSeekerCreatedEvent validateAndInitializeUser(UserRoot userRoot);

    CompanyCreatedEvent validateAndInitializeCompany(UserRoot userRoot);
}
