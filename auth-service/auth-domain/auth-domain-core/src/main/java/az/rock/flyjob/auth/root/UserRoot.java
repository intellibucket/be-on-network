package az.rock.flyjob.auth.root;

import az.rock.flyjob.auth.root.detail.DetailRoot;
import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.UserID;
import az.rock.lib.valueObject.DataStatus;
import az.rock.lib.valueObject.ProcessStatus;

import java.time.ZonedDateTime;
import java.util.Set;
import java.util.UUID;

public class UserRoot extends AggregateRoot<UserID> {

    private final UUID key;
    private final String firstName;
    private final String lastName;
    private final String username;
    private final Set<PasswordRoot> password;
    private final String timezone;
    private final String email;
    private final DetailRoot account;

    protected UserRoot(UserID userID,
                       Long version,
                       ProcessStatus processStatus,
                       DataStatus dataStatus,
                       ZonedDateTime createdDate,
                       ZonedDateTime modificationDate,
                       UUID key,
                       String firstName,
                       String lastName,
                       String username,
                       Set<PasswordRoot> password,
                       String timezone,
                       String email,
                       DetailRoot account) {
        super(userID, version, processStatus, dataStatus, createdDate, modificationDate);
        this.key = key;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.timezone = timezone;
        this.email = email;
        this.account = account;
    }

    private UserRoot(Builder builder) {
        super(builder.id, builder.version, builder.processStatus, builder.dataStatus, builder.createdDate, builder.modificationDate);
        this.key = builder.key;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.username = builder.username;
        this.password = builder.password;
        this.timezone = builder.timezone;
        this.email = builder.email;
        this.account = builder.account;
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
        return password;
    }

    public String getTimezone() {
        return timezone;
    }

    public String getEmail() {
        return email;
    }

    public DetailRoot getAccount() {
        return account;
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
        private Set<PasswordRoot> password;
        private String timezone;
        private String email;
        private DetailRoot account;

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

        public Builder password(Set<PasswordRoot> val) {
            password = val;
            return this;
        }

        public Builder timezone(String val) {
            timezone = val;
            return this;
        }

        public Builder email(String val) {
            email = val;
            return this;
        }

        public Builder account(DetailRoot val) {
            account = val;
            return this;
        }

        public UserRoot build() {
            return new UserRoot(this);
        }
    }
}
