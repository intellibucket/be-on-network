package az.rock.flyjob.js.domain.presentation.dto.request.model;

import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.AbstractCommandModel;

import java.time.ZonedDateTime;

public class PublicationCommandModel extends AbstractCommandModel {
    private String title;
    private String publisher;
    private String link;
    private ZonedDateTime startDate;
    private ZonedDateTime endDate;
    private String description;
}
