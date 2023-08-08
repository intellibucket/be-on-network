package az.rock.flyjob.js.domain.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.ZonedDateTime;

@Getter
@AllArgsConstructor
public class AwardCreateRequest {
    private String award;
    private String link;
    private String issuer;
    private ZonedDateTime date;
    private String description;
}
