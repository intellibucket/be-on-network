package az.rock.flyjob.auth.dataAccess.model.entity.outbox;

import az.rock.lib.domain.OutboxEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@Builder
@NoArgsConstructor
@Table(name = "process_outbox", schema = "outbox")
@Entity
public class ProcessOutboxEntity extends OutboxEntity {

}
