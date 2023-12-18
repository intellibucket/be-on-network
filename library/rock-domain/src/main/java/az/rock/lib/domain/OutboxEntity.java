package az.rock.lib.domain;

import com.intellibucket.lib.payload.trx.OutboxStatus;
import com.intellibucket.lib.payload.trx.SagaStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.UUID;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OutboxEntity {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(length = 36, updatable = false, nullable = false )
    private UUID uuid;

    @Column(name = "saga_id", length = 36, updatable = false, nullable = false )
    private UUID sagaId;

    @Version
    private Short version;

    @CreationTimestamp
    @Column(name = "created_date", updatable = false, nullable = false)
    private Timestamp createdDate;

    @Column(name = "modification_date")
    @UpdateTimestamp
    private Timestamp lastModifiedDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "outbox_status", nullable = false)
    private OutboxStatus outboxStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "saga_status", nullable = false)
    private SagaStatus sagaStatus;

    @Column(name = "process", length = 200, nullable = false)
    private String process;

    @Column(name = "topic", length = 200, nullable = false)
    private String topic;

    @Column(name = "payload", nullable = false)
    private String payload;

    @Column(name = "step", length = 200, nullable = false, updatable = false)
    private String step;

    @Column(name = "retryable", nullable = false, columnDefinition = "boolean default false")
    private Boolean retryable;

}
