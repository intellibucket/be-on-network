package az.rock.flyjob.js.domain.presentation.dto.request.item;

import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.AbstractCommandModel;
import az.rock.lib.valueObject.WorkingTimeType;
import az.rock.lib.valueObject.WorkingType;

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
