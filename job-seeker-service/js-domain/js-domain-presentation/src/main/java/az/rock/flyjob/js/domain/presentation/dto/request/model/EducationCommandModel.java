package az.rock.flyjob.js.domain.presentation.dto.request.model;

import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.AbstractCommandModel;
import az.rock.lib.valueObject.js.EducationDegree;
import az.rock.lib.valueObject.js.EducationState;
import az.rock.lib.valueObject.js.PaneType;

import java.time.ZonedDateTime;
import java.util.UUID;

public class EducationCommandModel extends AbstractCommandModel {
    private EducationDegree degree;
    private EducationState state;
    private String link;
    private UUID establishmentUUID;
    private String establishmentName;
    private UUID cityId;
    private ZonedDateTime startDate;
    private ZonedDateTime endDate;
    private String description;
}
