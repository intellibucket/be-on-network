package az.rock.flyjob.js.domain.presentation.mapper.concretes;

import az.rock.flyjob.js.domain.core.root.ResumeRoot;
import az.rock.flyjob.js.domain.presentation.mapper.abstracts.AbstractResumeDomainMapper;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.event.payload.registration.JobSeekerRegistrationPayload;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.Version;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ResumeDomainMapper implements AbstractResumeDomainMapper {
    @Override
    public ResumeRoot createNewResume(JobSeekerRegistrationPayload payload) {
        return ResumeRoot.Builder
                .builder()
                .resumeID(ResumeID.of(UUID.randomUUID()))
                .accessModifier(AccessModifier.PUBLIC)
                .version(Version.ONE)
                .build();
    }
}
