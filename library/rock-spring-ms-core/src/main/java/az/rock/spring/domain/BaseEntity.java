package az.rock.spring.domain;

import az.rock.lib.valueObject.ColumnStatus;
import jakarta.persistence.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.UUID;

@MappedSuperclass
@Slf4j
public class BaseEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(length = 36, columnDefinition = "varchar", updatable = false, nullable = false)
    private UUID uuid;

    @Version
    private Long version;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, columnDefinition = "varchar(20) default 'ACTIVE'")
    private ColumnStatus status;

    @CreationTimestamp
    @Column(name = "created_date", updatable = false)
    private Timestamp createdDate;

    @Column(name = "modification_date")
    @UpdateTimestamp
    private Timestamp lastModifiedDate;


    @Column(name = "is_active", nullable = false, columnDefinition = "boolean default true")
    private Boolean isActive;

    private BaseEntity(Builder builder) {
        setUuid(builder.uuid);
        setVersion(builder.version);
        setCreatedDate(builder.createdDate);
        setLastModifiedDate(builder.lastModifiedDate);
        status = builder.status;
        isActive = builder.isActive;
    }

    public boolean isNew() {
        return this.uuid == null;
    }


    public BaseEntity() {
    }


    public BaseEntity(UUID uuid, Long version, Timestamp createdDate, Timestamp lastModifiedDate, ColumnStatus status, Boolean isActive) {
        this.uuid = uuid;
        this.version = version;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
        this.status = status;
        this.isActive = isActive;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }


    public void setLastModifiedDate(Timestamp lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public void setCreatedDate(Date createdDate) {
        if (createdDate != null)
            this.createdDate = Timestamp.from(createdDate.toInstant());
    }


    public void setLastModifiedDate(Date lastModifiedDate) {
        if (lastModifiedDate != null)
            this.lastModifiedDate = Timestamp.from(lastModifiedDate.toInstant());
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = Timestamp.valueOf(createdDate);
    }


    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = Timestamp.valueOf(lastModifiedDate);
    }

    public void setCreatedDate(ZonedDateTime createdDate) {
        this.createdDate = Timestamp.valueOf(createdDate.toLocalDateTime());
    }


    public void setLastModifiedDate(ZonedDateTime lastModifiedDate) {
        this.lastModifiedDate = Timestamp.valueOf(lastModifiedDate.toLocalDateTime());
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public void setStatus(ColumnStatus status) {
        this.status = status;
    }

    public UUID getUuid() {
        return uuid;
    }

    public Long getVersion() {
        return version;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public Timestamp getLastModifiedDate() {
        return lastModifiedDate;
    }

    public Boolean getActive() {
        return isActive;
    }

    public ColumnStatus getStatus() {
        return status;
    }

    public static final class Builder {
        private UUID uuid;
        private Long version;
        private Timestamp createdDate;
        private Timestamp lastModifiedDate;
        private ColumnStatus status;
        private Boolean isActive;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder uuid(UUID uuid) {
            this.uuid = uuid;
            return this;
        }

        public Builder version(Long version) {
            this.version = version;
            return this;
        }

        public Builder createdDate(Timestamp createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public Builder lastModifiedDate(Timestamp lastModifiedDate) {
            this.lastModifiedDate = lastModifiedDate;
            return this;
        }

        public Builder status(ColumnStatus status) {
            this.status = status;
            return this;
        }

        public Builder isActive(Boolean isActive) {
            this.isActive = isActive;
            return this;
        }

        public BaseEntity build() {
            return new BaseEntity(this);
        }
    }
}