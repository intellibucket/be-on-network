package az.rock.flyjob.js.dataaccess.model.compose;

import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.js.EducationDegree;
import az.rock.lib.valueObject.js.EducationState;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Data
public class EducationCompose {

    private UUID uuid;

    private Long version;

    private String processStatus;

    private String rowStatus;

    private Date createdDate;

    private Date modificationDate;

    private UUID resumeId;

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
}
