package az.rock.flyjob.auth.dataAccess.model.entity.outbox;

import az.rock.lib.domain.OutboxEntity;
import com.intellibucket.lib.payload.trx.TrxProcessStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "process_outbox", schema = "outbox")
@Entity(name = "ProcessOutboxEntity")
public class ProcessOutboxEntity extends OutboxEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "trx_status", nullable = false)
    private TrxProcessStatus trxStatus;

    @Column(name = "topic", length = 200, nullable = false)
    private String topic;

    @Column(name = "process", length = 200, nullable = false)
    private String process;

    @Column(name = "step", length = 200, nullable = false, updatable = false)
    private String step;

    @Column(name = "event", nullable = false)
    private String event;
    /**
     * This field is used for must be retryable current step
     */
    @Column(name = "must_be_retryable_step", nullable = false, columnDefinition = "boolean default false")
    private Boolean mustBeRetryableStep;

    public Boolean isCompleted() {
        return this.trxStatus.equals(TrxProcessStatus.COMPLETED);
    }

    public Boolean isFailed() {
        return this.trxStatus.equals(TrxProcessStatus.FAILED);
    }

    public Boolean isOnStarted() {
        return this.trxStatus.equals(TrxProcessStatus.STARTED);
    }

    public Boolean isOnAnyStarted() {
        return this.isOnStarted() || this.isOnRestarted();
    }

    public Boolean isOnRestarted() {
        return this.trxStatus.equals(TrxProcessStatus.RESTARTED);
    }
}
