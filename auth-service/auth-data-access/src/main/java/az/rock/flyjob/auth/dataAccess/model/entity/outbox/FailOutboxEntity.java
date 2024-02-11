package az.rock.flyjob.auth.dataAccess.model.entity.outbox;

import az.rock.lib.domain.OutboxEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Table(name = "fail_outbox", schema = "outbox")
@Entity(name = "FailOutboxEntity")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class FailOutboxEntity extends OutboxEntity {

    @Column(name = "message", length = 200, updatable = false)
    private String message;

    @Column(name = "stack_trace", length = 200, updatable = false)
    private String stackTrace;

}
