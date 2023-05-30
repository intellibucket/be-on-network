package az.rock.flyjob.auth.dataAccess.entity.user;

import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "passwords", schema = "auth")
@Entity(name = "PasswordEntity")
public class PasswordEntity extends BaseEntity {

    @ManyToOne
    private UserEntity user;

    @Column(name = "salt", nullable = false)
    private String salt;

    @Column(name = "hash", nullable = false)
    private String hash;

    private PasswordEntity(Builder builder) {
        setUser(builder.user);
        setSalt(builder.salt);
        setHash(builder.hash);
        setUuid(builder.uuid);
        setVersion(builder.version);
        setProcessStatus(builder.processStatus);
        setRowStatus(builder.rowStatus);
        setCreatedDate(builder.createdDate);
        setLastModifiedDate(builder.lastModifiedDate);
    }


    public static final class Builder {

        private UUID uuid;
        private Long version;

        private ProcessStatus processStatus;
        private RowStatus rowStatus;
        private Timestamp createdDate;
        private Timestamp lastModifiedDate;
        private UserEntity user;
        private String salt;
        private String hash;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder user(UserEntity val) {
            user = val;
            return this;
        }

        public Builder salt(String val) {
            salt = val;
            return this;
        }

        public Builder hash(String val) {
            hash = val;
            return this;
        }

        public Builder uuid(UUID val) {
            uuid = val;
            return this;
        }

        public Builder version(Long val) {
            version = val;
            return this;
        }

        public Builder processStatus(ProcessStatus val) {
            processStatus = val;
            return this;
        }

        public Builder rowStatus(RowStatus val) {
            rowStatus = val;
            return this;
        }

        public Builder createdDate(Timestamp val) {
            createdDate = val;
            return this;
        }

        public Builder lastModifiedDate(Timestamp val) {
            lastModifiedDate = val;
            return this;
        }

        public PasswordEntity build() {
            return new PasswordEntity(this);
        }
    }
}
