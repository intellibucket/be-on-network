package az.rock.flyjob.js.domain.presentation.dto.request.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReorderCommandModel {
    private UUID targetId;
    private Integer orderNumber;
}
