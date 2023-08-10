package az.rock.flyjob.js.domain.presentation.dto.request.model;

import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.AbstractCommandModel;

import java.time.ZonedDateTime;
import java.util.UUID;

public class ProjectCommandModel extends AbstractCommandModel {
    private String title;
    private String subtitle;
    private String link;
    private ZonedDateTime startDate;
    private ZonedDateTime endDate;
    private String description;
}
