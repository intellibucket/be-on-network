package az.rock.flyjob.auth.dataAccess.model.entity.outbox;

import az.rock.lib.domain.OutboxEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Table(name = "process_steps", schema = "outbox")
@Entity(name = "ProcessStepEntity")
@NoArgsConstructor
@SuperBuilder
public class ProcessStepEntity extends OutboxEntity {

}
