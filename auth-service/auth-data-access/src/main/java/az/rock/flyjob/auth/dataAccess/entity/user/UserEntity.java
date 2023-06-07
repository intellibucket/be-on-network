package az.rock.flyjob.auth.dataAccess.entity.user;

import az.rock.flyjob.auth.dataAccess.entity.detail.DetailEntity;
import az.rock.flyjob.auth.dataAccess.entity.user.device.DeviceEntity;
import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.Gender;
import az.rock.lib.valueObject.ProcessStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users", schema = "auth", indexes = {
        @Index(name = "idx_users_username", columnList = "username")
})
@Entity(name = "UserEntity")
public class UserEntity extends BaseEntity {

    @Column(length = 32, columnDefinition = "varchar(32) default 'ONLY_AUTHENTICATED'")
    @Enumerated(EnumType.STRING)
    private AccessModifier accessModifier;

    @Column(name = "key", nullable = false, unique = true)
    private UUID key;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "timezone", nullable = false)
    private String timezone;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<PasswordEntity> passwords;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<EmailEntity> emails;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<PhoneNumberEntity> phoneNumbers;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    private DetailEntity detail;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<AccountPlanEntity> accountPlans;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<DeviceEntity> devices;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private UserSettingsEntity settings;

    private UserEntity(Builder builder) {
        setKey(builder.key);
        setAccessModifier(builder.accessModifier);
        setFirstName(builder.firstName);
        setLastName(builder.lastName);
        setUsername(builder.username);
        setTimezone(builder.timezone);
        setGender(builder.gender);
        setPasswords(builder.passwords);
        setEmails(builder.emails);
        setPhoneNumbers(builder.phoneNumbers);
        setDetail(builder.detail);
        setAccountPlans(builder.accountPlans);
        setDevices(builder.devices);
        setSettings(builder.settings);
        setUuid(builder.uuid);
        setVersion(builder.version);
        setProcessStatus(builder.processStatus);
        setRowStatus(builder.rowStatus);
        setCreatedDate(builder.createdDate);
        setLastModifiedDate(builder.lastModifiedDate);
    }


    public static final class Builder {
        private UUID key;
        private @Min(value = 3, message = "First name must be at least 3 characters long") @Max(value = 30, message = "First name must be at most 20 characters long") String firstName;
        private @Min(value = 3, message = "Last name must be at least 3 characters long") @Max(value = 40, message = "Last name must be at most 20 characters long") String lastName;
        private @Min(value = 2, message = "Username must be at least 3 characters long") @Max(value = 30, message = "Username must be at most 20 characters long") String username;
        private @Min(value = 1, message = "Timezone must be at least 3 characters long") String timezone;
        private Gender gender;

        private AccessModifier accessModifier;
        private List<PasswordEntity> passwords;
        private List<EmailEntity> emails;
        private List<PhoneNumberEntity> phoneNumbers;
        private DetailEntity detail;
        private List<AccountPlanEntity> accountPlans;
        private List<DeviceEntity> devices;
        private UserSettingsEntity settings;
        private UUID uuid;
        private Long version;
        private ProcessStatus processStatus;

        private RowStatus rowStatus;
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

        public Builder accessModifier(AccessModifier val) {
            accessModifier = val;
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

        public Builder timezone(@Min(value = 1, message = "Timezone must be at least 3 characters long") String val) {
            timezone = val;
            return this;
        }

        public Builder gender(Gender val) {
            gender = val;
            return this;
        }

        public Builder passwords(List<PasswordEntity> val) {
            passwords = val;
            return this;
        }

        public Builder emails(List<EmailEntity> val) {
            emails = val;
            return this;
        }

        public Builder phoneNumbers(List<PhoneNumberEntity> val) {
            phoneNumbers = val;
            return this;
        }

        public Builder detail(DetailEntity val) {
            detail = val;
            return this;
        }

        public Builder accountPlans(List<AccountPlanEntity> val) {
            accountPlans = val;
            return this;
        }

        public Builder devices(List<DeviceEntity> val) {
            devices = val;
            return this;
        }

        public Builder settings(UserSettingsEntity val) {
            settings = val;
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

        public UserEntity build() {
            return new UserEntity(this);
        }
    }
}
