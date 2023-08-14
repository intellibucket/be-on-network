package az.rock.flyjob.js.domain.presentation.dto.request.item;

import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.AbstractCommandModel;

import java.time.ZonedDateTime;
import java.util.UUID;

public class OrganizationCommandModel extends AbstractCommandModel {
    private String organizationName;
    private String position;
    private ZonedDateTime startDate;
    private ZonedDateTime endDate;
    private UUID cityId;
    private String description;
}
