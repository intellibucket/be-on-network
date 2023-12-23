package az.rock.flyjob.auth.dataAccess.model.entity.outbox;

import com.intellibucket.lib.payload.trx.TrxProcessStatus;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@Table(name = "process_outbox", schema = "outbox")
@Entity(name = "ProcessOutboxEntity")
public class ProcessOutboxEntity {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(length = 36, updatable = false, nullable = false)
    private UUID uuid;

    @Column(name = "is_active", nullable = false, columnDefinition = "boolean default true")
    private Boolean isActive;

    @Column(name = "transaction_id", length = 36, updatable = false, nullable = false)
    private UUID transactionId;

    @Version
    private Short version;

    @CreationTimestamp
    @Column(name = "created_date", updatable = false, nullable = false)
    private Timestamp createdDate;

    @Column(name = "modification_date")
    @UpdateTimestamp
    private Timestamp lastModifiedDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "trx_outbox_status", nullable = false)
    private TrxProcessStatus trxProcessStatus;

    @Column(name = "topic", length = 200, nullable = false)
    private String topic;

    @Column(name = "step", length = 200, nullable = false, updatable = false)
    private String step;

    @Column(name = "event", nullable = false)
    private String event;

    /**
     * This field is used for must be retryable current step
     */
    @Column(name = "must_be_retryable_step", nullable = false, columnDefinition = "boolean default false")
    private Boolean mustBeRetryableStep;
}
