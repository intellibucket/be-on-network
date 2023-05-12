package az.rock.flyjob.auth.dataAccess.entity;

import az.rock.flyjob.auth.dataAccess.entity.detail.DetailEntity;
import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.DataStatus;
import az.rock.lib.valueObject.ProcessStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
@Table(name = "users", schema = "auth", indexes = {
        @Index(name = "idx_userentity_username", columnList = "username")
})
@Entity(name = "UserEntity")
public class UserEntity extends BaseEntity {

    @Column(name = "key", nullable = false, unique = true)
    private UUID key;

    @Column(name = "first_name", nullable = false)
    @Min(value = 3, message = "First name must be at least 3 characters long")
    @Max(value = 30, message = "First name must be at most 20 characters long")
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @Min(value = 3, message = "Last name must be at least 3 characters long")
    @Max(value = 40, message = "Last name must be at most 20 characters long")
    private String lastName;

    @Column(name = "username", nullable = false, unique = true)
    @Min(value = 2, message = "Username must be at least 3 characters long")
    @Max(value = 30, message = "Username must be at most 20 characters long")
    private String username;

    @OneToOne(cascade = CascadeType.ALL)
    private PasswordEntity passwordEntity;

    @Column(name = "timezone", nullable = false)
    @Min(value = 1, message = "Timezone must be at least 3 characters long")
    private String timezone;

    @Email
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    private DetailEntity account;

    private UserEntity(Builder builder) {
        setKey(builder.key);
        setFirstName(builder.firstName);
        setLastName(builder.lastName);
        setUsername(builder.username);
        setPasswordEntity(builder.passwordEntity);
        setTimezone(builder.timezone);
        setEmail(builder.email);
        setAccount(builder.account);
        setUuid(builder.uuid);
        setVersion(builder.version);
        setCreatedDate(builder.createdDate);
        setLastModifiedDate(builder.lastModifiedDate);
    }


    public static final class Builder {
        private UUID key;
        private @Min(value = 3, message = "First name must be at least 3 characters long") @Max(value = 30, message = "First name must be at most 20 characters long") String firstName;
        private @Min(value = 3, message = "Last name must be at least 3 characters long") @Max(value = 40, message = "Last name must be at most 20 characters long") String lastName;
        private @Min(value = 2, message = "Username must be at least 3 characters long") @Max(value = 30, message = "Username must be at most 20 characters long") String username;
        private PasswordEntity passwordEntity;
        private @Min(value = 1, message = "Timezone must be at least 3 characters long") String timezone;
        private @Email String email;
        private DetailEntity account;
        private UUID uuid;
        private Long version;

        private ProcessStatus processStatus;

        private DataStatus dataStatus;
        private Timestamp createdDate;
        private Timestamp lastModifiedDate;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder key(UUID val) {
            key = val;
            return this;
        }

        public Builder firstName(@Min(value = 3, message = "First name must be at least 3 characters long") @Max(value = 30, message = "First name must be at most 20 characters long") String val) {
            firstName = val;
            return this;
        }

        public Builder lastName(@Min(value = 3, message = "Last name must be at least 3 characters long") @Max(value = 40, message = "Last name must be at most 20 characters long") String val) {
            lastName = val;
            return this;
        }

        public Builder username(@Min(value = 2, message = "Username must be at least 3 characters long") @Max(value = 30, message = "Username must be at most 20 characters long") String val) {
            username = val;
            return this;
        }

        public Builder passwordEntity(PasswordEntity val) {
            passwordEntity = val;
            return this;
        }

        public Builder timezone(@Min(value = 1, message = "Timezone must be at least 3 characters long") String val) {
            timezone = val;
            return this;
        }

        public Builder email(@Email String val) {
            email = val;
            return this;
        }

        public Builder account(DetailEntity val) {
            account = val;
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

        public Builder createdDate(Timestamp val) {
            createdDate = val;
            return this;
        }

        public Builder lastModifiedDate(Timestamp val) {
            lastModifiedDate = val;
            return this;
        }

        public Builder processStatus(ProcessStatus val) {
            processStatus = val;
            return this;
        }

        public Builder dataStatus(DataStatus val) {
            dataStatus = val;
            return this;
        }

        public UserEntity build() {
            return new UserEntity(this);
        }
    }
}
