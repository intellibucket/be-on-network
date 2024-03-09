package az.rock.flyjob.js.domain.presentation.dto.response;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@SuperBuilder
public class BaseResponseModel {
    private UUID id;
    private LocalDateTime lastModifiedDate;
}
