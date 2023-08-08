package az.rock.flyjob.js.domain.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class AwardUpdateRequest {
    private UUID awardId;
    private String award;
    private String link;
    private String issuer;
    private ZonedDateTime date;
    private String description;
}
