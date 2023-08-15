package az.rock.lib.domain;

import az.rock.lib.event.trx.State;
import az.rock.lib.valueObject.OutboxStatus;
import az.rock.lib.valueObject.ProcessStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.Objects;
import java.util.UUID;

@MappedSuperclass
@Getter
@Setter
public class OutboxEntity {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(length = 36, updatable = false, nullable = false )
    private UUID uuid;

    @Column(name = "saga_id", length = 36, updatable = false, nullable = false )
    private UUID sagaId;

    @Version
    private Long version;

    @CreationTimestamp
    @Column(name = "created_date", updatable = false, nullable = false)
    private Timestamp createdDate;

    @Column(name = "modification_date")
    @UpdateTimestamp
    private Timestamp lastModifiedDate;

    @Enumerated(EnumType.STRING)
    private State sagaStatus;

    @Enumerated(EnumType.STRING)
    private OutboxStatus outboxStatus;

    @Column(name = "type", length = 100)
    private String type;

    @Column(name = "payload")
    private String payload;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OutboxEntity that)) return false;
        return getUuid().equals(that.getUuid()) && getSagaId().equals(that.getSagaId()) && getVersion().equals(that.getVersion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUuid(), getSagaId(), getVersion(), getCreatedDate(), getLastModifiedDate(), getSagaStatus(), getOutboxStatus(), getType(), getPayload());
    }
}
