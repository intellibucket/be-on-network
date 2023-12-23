package az.rock.flyjob.auth.dataAccess.model.entity.outbox;

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
@Table(name = "fail_outbox", schema = "outbox")
@Entity(name = "FailOutboxEntity")
public class FailOutboxEntity {
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

    @Column(name = "process", length = 200, nullable = false)
    private String process;

    @Column(name = "step", length = 200, nullable = false, updatable = false)
    private String step;

    @Column(name = "message", length = 200, updatable = false)
    private String message;

    @Column(name = "stack_trace", length = 200, updatable = false)
    private String stackTrace;

}
