package az.rock.flyjob.js.domain.presentation.dto.request.item;

import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.AbstractCommandModel;

import java.time.ZonedDateTime;

public class ProjectCommandModel extends AbstractCommandModel {
    private String title;
    private String subtitle;
    private String link;
    private ZonedDateTime startDate;
    private ZonedDateTime endDate;
    private String description;
}
