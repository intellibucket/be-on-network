package az.rock.flyjob.auth.root;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.PasswordID;
import az.rock.lib.valueObject.DataStatus;
import az.rock.lib.valueObject.ProcessStatus;

import java.time.ZonedDateTime;

public class PasswordRoot extends AggregateRoot<PasswordID>{

    private final UserRoot user;
    private final String salt;
    private final String hash;

    protected PasswordRoot(PasswordID passwordID,
                           UserRoot user,
                           String salt,
                           String hash) {
        super(passwordID);
        this.user = user;
        this.salt = salt;
        this.hash = hash;
    }

    private PasswordRoot(Builder builder) {
        super(builder.id, builder.version, builder.processStatus, builder.dataStatus, builder.createdDate, builder.modificationDate);
        user = builder.user;
        salt = builder.salt;
        hash = builder.hash;
    }

    public String getSalt() {
        return salt;
    }

    public String getHash() {
        return hash;
    }






    @Override
    public String toString() {
        return "PasswordRoot{" +
                "user id=" + user.getUUID().getId() +
                '}';
    }


    public static final class Builder {
        private PasswordID id;
        private Long version;
        private ProcessStatus processStatus;
        private DataStatus dataStatus;
        private ZonedDateTime createdDate;
        private ZonedDateTime modificationDate;
        private UserRoot user;
        private String salt;
        private String hash;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder id(PasswordID val) {
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

        public Builder user(UserRoot val) {
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

        public PasswordRoot build() {
            return new PasswordRoot(this);
        }
    }
}
