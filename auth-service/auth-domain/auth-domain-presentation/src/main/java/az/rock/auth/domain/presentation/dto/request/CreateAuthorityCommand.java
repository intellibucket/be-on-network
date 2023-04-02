package az.rock.auth.domain.presentation.dto.request;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class CreateAuthorityCommand {
    private String permission;
}
