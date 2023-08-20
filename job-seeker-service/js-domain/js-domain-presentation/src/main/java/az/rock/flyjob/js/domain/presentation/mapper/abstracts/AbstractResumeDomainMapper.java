package az.rock.flyjob.js.domain.presentation.mapper.abstracts;

import az.rock.flyjob.js.domain.core.root.ResumeRoot;
import az.rock.lib.event.payload.registration.JobSeekerRegistrationPayload;

public interface AbstractResumeDomainMapper {
    ResumeRoot createNewResume(JobSeekerRegistrationPayload payload);
}
