package az.rock.flyjob.js.domain.presentation.mapper.concretes;

import az.rock.flyjob.js.domain.core.root.detail.EducationRoot;
import az.rock.flyjob.js.domain.presentation.dto.request.item.EducationCommandModel;
import az.rock.flyjob.js.domain.presentation.mapper.abstracts.AbstractEducationDomainMapper;
import az.rock.lib.domain.id.js.EducationID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.Version;
import com.intellibucket.lib.payload.payload.EducationPayload;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EducationDomainMapper implements AbstractEducationDomainMapper {


    private int orderNumber = 0;

    private Integer orderNumber() {
        return orderNumber++;
    }


    @Override
    public EducationRoot toNewRoot(ResumeID resumeID, EducationCommandModel educationCommandModel) {
        return EducationRoot.Builder
                .builder()
                .uuid(EducationID.of(UUID.randomUUID()))
                .version(Version.ONE)
                .accessModifier(AccessModifier.PUBLIC)
                .processStatus(ProcessStatus.COMPLETED)
                .rowStatus(RowStatus.ACTIVE)
                .resume(resumeID)
                .orderNumber(orderNumber())
                .degree(educationCommandModel.getDegree())
                .state(educationCommandModel.getState())
                .link(educationCommandModel.getLink())
                .establishmentUUID(educationCommandModel.getEstablishmentUUID())
                .establishmentName(educationCommandModel.getEstablishmentName())
                .cityId(educationCommandModel.getCityId())
                .startDate(educationCommandModel.getStartDate())
                .endDate(educationCommandModel.getEndDate())
                .description(educationCommandModel.getDescription())
                .build();
    }


    public EducationRoot toExistRoot(EducationRoot educationRoot, EducationCommandModel educationCommandModel) {
        educationRoot.setEducationDegree(educationCommandModel.getDegree());
        educationRoot.setEducationDescription(educationCommandModel.getDescription());
        educationRoot.setEducationState(educationCommandModel.getState());
        educationRoot.setEducationStartDate(educationCommandModel.getStartDate());
        educationRoot.setEducationEndDate(educationCommandModel.getEndDate());
        educationRoot.setLink(educationCommandModel.getLink());
        educationRoot.setEstablishmentName(educationCommandModel.getEstablishmentName());
        return educationRoot;
    }

    @Override
    public EducationRoot toRoot(ResumeID resumeID, EducationCommandModel educationCommandModel) {
        return EducationRoot.Builder
                .builder()
                .resume(resumeID)
                .orderNumber(orderNumber())
                .degree(educationCommandModel.getDegree())
                .state(educationCommandModel.getState())
                .link(educationCommandModel.getLink())
                .establishmentUUID(educationCommandModel.getEstablishmentUUID())
                .establishmentName(educationCommandModel.getEstablishmentName())
                .cityId(educationCommandModel.getCityId())
                .startDate(educationCommandModel.getStartDate())
                .endDate(educationCommandModel.getEndDate())
                .description(educationCommandModel.getDescription())
                .build();
    }


    @Override
    public EducationPayload toPayload(EducationRoot educationRoot) {
        return EducationPayload
                .builder()
                .id(educationRoot.getRootID().getAbsoluteID())
                .resumeId(educationRoot.getResumeID().getRootID())
                .accessModifier(educationRoot.getAccessModifier())
                .build();

    }


}