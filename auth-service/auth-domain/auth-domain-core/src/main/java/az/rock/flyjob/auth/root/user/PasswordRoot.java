package az.rock.flyjob.auth.root.user;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.PasswordID;
import az.rock.lib.domain.id.UserID;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.Version;

import java.time.ZonedDateTime;

public class PasswordRoot extends AggregateRoot<PasswordID>{

    private final UserID userID;

    private final String salt;
    private final String hash;

    protected PasswordRoot(PasswordID passwordID,
                           UserID userID,
                           String salt,
                           String hash) {
        super(passwordID);
        this.userID = userID;
        this.salt = salt;
        this.hash = hash;
    }


    public static PasswordRoot of(UserID userID,String salt,String hash){
        return new PasswordRoot(PasswordID.of(),userID,salt, hash);
    }

    private PasswordRoot(Builder builder) {
        super(builder.id, builder.version, builder.processStatus, builder.rowStatus, builder.createdDate, builder.modificationDate);
        userID = builder.userID;
        salt = builder.salt;
        hash = builder.hash;
    }

    public Boolean currentPassword(){
        return this.getRowStatus().isActive();
    }

    public String getSalt() {
        return salt;
    }

    public String getHash() {
        return hash;
    }

    public Boolean inActivePassword() {
        return this.getRowStatus().isInactive();
    }

    @Override
    public String toString() {
        return "PasswordRoot{}";
    }

    public static final class Builder {
        private PasswordID id;
        private Version version;
        private ProcessStatus processStatus;
        private RowStatus rowStatus;
        private ZonedDateTime createdDate;
        private ZonedDateTime modificationDate;

        private UserID userID;
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
            version = Version.of(val);
            return this;
        }

        public Builder version(Version val) {
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

        public Builder createdDate(ZonedDateTime val) {
            createdDate = val;
            return this;
        }

        public Builder modificationDate(ZonedDateTime val) {
            modificationDate = val;
            return this;
        }

        public Builder userID(UserID val) {
            userID = val;
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

        @Override
        public String toString() {
            return "Builder{" +
                    "id=" + id +
                    '}';
        }
    }
}
