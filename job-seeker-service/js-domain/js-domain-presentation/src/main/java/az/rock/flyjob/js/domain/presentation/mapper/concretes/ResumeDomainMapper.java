package az.rock.flyjob.js.domain.presentation.mapper.concretes;

import az.rock.flyjob.js.domain.core.root.ResumeRoot;
import az.rock.flyjob.js.domain.presentation.mapper.abstracts.AbstractInformationDomainMapper;
import az.rock.flyjob.js.domain.presentation.mapper.abstracts.AbstractResumeDomainMapper;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.Version;
import com.intellibucket.lib.payload.payload.reg.JobSeekerRegistrationPayload;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ResumeDomainMapper implements AbstractResumeDomainMapper {
    private final AbstractInformationDomainMapper informationDomainMapper;

    public ResumeDomainMapper(AbstractInformationDomainMapper informationDomainMapper) {
        this.informationDomainMapper = informationDomainMapper;
    }

    @Override
    public ResumeRoot createNewResume(JobSeekerRegistrationPayload payload) {
        var resumeId = ResumeID.of(UUID.randomUUID());
        var informationRoot = this.informationDomainMapper.createNewInformation(
                resumeId,payload.getFirstName(),payload.getLastName()
        );
        return ResumeRoot.Builder
                .builder()
                .resumeID(resumeId)
                .accessModifier(AccessModifier.PUBLIC)
                .version(Version.ONE)
                .processStatus(ProcessStatus.COMPLETED)
                .rowStatus(RowStatus.ACTIVE)
                .userId(payload.getUserId())
                .information(informationRoot)
                .build();
    }
}
