package az.rock.flyjob.js.domain.presentation.mapper.abstracts;

import az.rock.flyjob.js.domain.core.root.ResumeRoot;
import com.intellibucket.lib.payload.payload.reg.JobSeekerRegistrationPayload;

public interface AbstractResumeDomainMapper {
    ResumeRoot createNewResume(JobSeekerRegistrationPayload payload);
}
