package az.rock.flyjob.js.domain.presentation.dto.request.model;

import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.AbstractCommandModel;
import az.rock.lib.valueObject.WorkingTimeType;
import az.rock.lib.valueObject.WorkingType;

import java.time.ZonedDateTime;
import java.util.UUID;

public class InterestCommandModel extends AbstractCommandModel {
    private Boolean isHobby;
    private String name;
    private String description;
}
