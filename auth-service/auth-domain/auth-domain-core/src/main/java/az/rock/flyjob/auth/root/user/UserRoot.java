package az.rock.flyjob.auth.root.user;

import az.rock.flyjob.auth.root.*;
import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.UserID;
import az.rock.lib.valueObject.DataStatus;
import az.rock.lib.valueObject.Gender;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.TimeZoneID;

import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class UserRoot extends AggregateRoot<UserID> {
    private final UUID key;
    private final String firstName;
    private final String lastName;
    private final String username;
    private final TimeZoneID timezone;
    private final Gender gender;
    private final Set<PasswordRoot> passwords;
    private final Set<EmailRoot> emails;
    private final Set<PhoneNumberRoot> phoneNumbers;
    private final DetailRoot detailRoot;
    private final Set<AccountPlanRoot> accountPlans;
    private final Set<DeviceRoot> devices;
    private final UserSettingsRoot userSettingsRoot;


    private UserRoot(Builder builder) {
        super(builder.id, builder.version, builder.processStatus, builder.dataStatus, builder.createdDate, builder.modificationDate);
        this.key = builder.key;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.username = builder.username;
        this.passwords = builder.password;
        this.timezone = builder.timezone;
        this.emails = builder.emails;
        this.detailRoot = builder.detail;
        this.gender = builder.gender;
        this.phoneNumbers = builder.phoneNumbers;
        this.accountPlans = builder.accountPlans;
        this.devices = builder.devices;
        this.userSettingsRoot = builder.userSettingsRoot;
    }

    public UUID getKey() {
        return key;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public Set<PasswordRoot> getPasswords() {
        return passwords;
    }

    public Set<PasswordRoot> getInActivePasswords() {
        return passwords.stream().filter(PasswordRoot::inActivePassword).collect(Collectors.toSet());
    }
    public PasswordRoot getCurrentPassword() {
        return passwords.stream().filter(PasswordRoot::currentPassword).findFirst().orElse(null);
    }

    public TimeZoneID getTimezone() {
        return timezone;
    }


    public Set<EmailRoot> getEmails() {
        return emails;
    }

    public EmailRoot getPrimaryEmail() {
        return this.emails.stream().filter(EmailRoot::getPrimary).findFirst().orElse(null);
    }

    public String getAbsoluteEmail() {
        return this.getPrimaryEmail().getEmail();
    }

    public DetailRoot getDetailRoot() {
        return detailRoot;
    }

    public Gender getGender() {
        return gender;
    }

    public static final class Builder {
        private UserID id;
        private Long version;
        private ProcessStatus processStatus;
        private DataStatus dataStatus;
        private ZonedDateTime createdDate;
        private ZonedDateTime modificationDate;
        private UUID key;
        private String firstName;
        private String lastName;
        private String username;
        private TimeZoneID timezone;
        public Gender gender;
        private Set<PasswordRoot> password = new HashSet<>();
        private Set<EmailRoot> emails = new HashSet<>();
        private Set<PhoneNumberRoot> phoneNumbers = new HashSet<>();
        private DetailRoot detail;
        public Set<AccountPlanRoot> accountPlans = new HashSet<>();
        public Set<DeviceRoot> devices  = new HashSet<>();
        public UserSettingsRoot userSettingsRoot ;


        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder id(UserID val) {
            id = val;
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

        public Builder dataStatus(DataStatus val) {
            dataStatus = val;
            return this;
        }

        public Builder createdDate(ZonedDateTime val) {
            createdDate = val;
            return this;
        }

        public Builder modificationDate(ZonedDateTime val) {
            modificationDate = val;
            return this;
        }

        public Builder key(UUID val) {
            key = val;
            return this;
        }

        public Builder firstName(String val) {
            firstName = val;
            return this;
        }

        public Builder lastName(String val) {
            lastName = val;
            return this;
        }

        public Builder username(String val) {
            username = val;
            return this;
        }

        public Builder passwords(Set<PasswordRoot> val) {
            password = val;
            return this;
        }

        public Builder password(PasswordRoot val) {
            password = Set.of(val);
            return this;
        }

        public Builder timezone(TimeZoneID val) {
            timezone = val;
            return this;
        }

        public Builder gender(Gender val){
            gender = val;
            return this;
        }

        public Builder email(Set<EmailRoot> val) {
            emails = val;
            return this;
        }

        public Builder email(EmailRoot val) {
            emails = Set.of(val);
            return this;
        }

        public Builder phoneNumbers(Set<PhoneNumberRoot> val) {
            phoneNumbers = val;
            return this;
        }

        public Builder phoneNumber(PhoneNumberRoot val) {
            phoneNumbers = Set.of(val);
            return this;
        }

        public Builder account(DetailRoot val) {
            detail = val;
            return this;
        }

        public Builder accountPlans(Set<AccountPlanRoot> val) {
            accountPlans = val;
            return this;
        }

        public Builder accountPlan(AccountPlanRoot val) {
            accountPlans = Set.of(val);
            return this;
        }

        public Builder devices(Set<DeviceRoot> val) {
            devices = val;
            return this;
        }

        public Builder device(DeviceRoot val) {
            devices = Set.of(val);
            return this;
        }

        public Builder userSettings(UserSettingsRoot val) {
            userSettingsRoot = val;
            return this;
        }

        public UserRoot build() {
            return new UserRoot(this);
        }
    }
}
