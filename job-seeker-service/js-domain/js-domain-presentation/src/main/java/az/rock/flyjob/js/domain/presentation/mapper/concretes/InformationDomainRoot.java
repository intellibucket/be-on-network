package az.rock.flyjob.js.domain.presentation.mapper.concretes;

import az.rock.flyjob.js.domain.core.root.main.InformationRoot;
import az.rock.flyjob.js.domain.presentation.mapper.abstracts.AbstractInformationDomainMapper;
import az.rock.lib.domain.id.js.InformationID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.Version;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class InformationDomainRoot implements AbstractInformationDomainMapper {
    @Override
    public InformationRoot createNewInformation(ResumeID resumeID, String firstName, String lastName) {
        return InformationRoot.Builder
                .builder()
                .id(InformationID.of(UUID.randomUUID()))
                .processStatus(ProcessStatus.COMPLETED)
                .rowStatus(RowStatus.ACTIVE)
                .version(Version.ONE)
                .resume(resumeID)
                .firstName(firstName)
                .lastName(lastName)
                .build();
    }
}
