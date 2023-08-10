package az.rock.flyjob.js.domain.presentation.dto.request.item;

import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.AbstractCommandModel;
import az.rock.lib.valueObject.js.PaneType;

import java.time.ZonedDateTime;
import java.util.UUID;

public class CustomPaneCommandModel extends AbstractCommandModel {
    private String name;
    private PaneType type;
    private String title;
    private String link;
    private String subtitle;
    private UUID cityId;
    private ZonedDateTime startDate;
    private ZonedDateTime endDate;
    private String description;
}
