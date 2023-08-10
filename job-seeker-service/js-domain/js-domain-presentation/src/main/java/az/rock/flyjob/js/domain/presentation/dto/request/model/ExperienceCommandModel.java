package az.rock.flyjob.js.domain.presentation.dto.request.model;

import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.AbstractCommandModel;
import az.rock.lib.valueObject.WorkingTimeType;
import az.rock.lib.valueObject.WorkingType;
import az.rock.lib.valueObject.js.EducationDegree;
import az.rock.lib.valueObject.js.EducationState;

import java.time.ZonedDateTime;
import java.util.UUID;

public class ExperienceCommandModel extends AbstractCommandModel {
    private String employer;
    private String link;
    private String jobTitle;
    private UUID cityId;
    private WorkingType workingType;
    private WorkingTimeType workingTimeType;
    private String description;
    private ZonedDateTime startDate;
    private ZonedDateTime endDate;
}
