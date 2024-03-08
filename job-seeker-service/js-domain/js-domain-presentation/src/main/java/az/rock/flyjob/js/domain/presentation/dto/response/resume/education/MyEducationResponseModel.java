package az.rock.flyjob.js.domain.presentation.dto.response.resume.education;

import az.rock.flyjob.js.domain.core.root.detail.EducationRoot;
import az.rock.flyjob.js.domain.presentation.dto.response.MyBaseResponseModel;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.js.EducationDegree;
import az.rock.lib.valueObject.js.EducationState;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@SuperBuilder
public class MyEducationResponseModel extends MyBaseResponseModel {

    private AccessModifier accessModifier;
    private Integer orderNumber;
    private EducationDegree degree;
    private EducationState state;
    private String link;
    private UUID establishmentUUID;
    private String establishmentName;
    private UUID cityId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String description;

    public static MyEducationResponseModel of(EducationRoot root) {
        return MyEducationResponseModel.builder()
                .id(root.getRootID().getAbsoluteID())
                .accessModifier(root.getAccessModifier())
                .orderNumber(root.getOrderNumber())
                .degree(root.getDegree())
                .state(root.getState())
                .link(root.getLink())
                .establishmentUUID(root.getEstablishmentUUID())
                .establishmentName(root.getEstablishmentName())
                .cityId(root.getCityId())
                .startDate(root.getStartDate())
                .endDate(root.getEndDate())
                .description(root.getDescription())
                .build();
    }

}
