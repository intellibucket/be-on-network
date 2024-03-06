package az.rock.flyjob.auth.model.root.user;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.auth.AccountPlanID;
import az.rock.lib.domain.id.auth.UserID;
import az.rock.lib.valueObject.AccountPlanType;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.Version;

import java.time.ZonedDateTime;

public final class AccountPlanRoot extends AggregateRoot<AccountPlanID> {

    public static final AccountPlanRoot NULL = new AccountPlanRoot();

    private final UserID userID;

    private final AccountPlanType plan;

    private final ZonedDateTime startDate;

    private final ZonedDateTime expiredDate;

    private final Boolean isExpired;

    private final String promoCode;

    private AccountPlanRoot() {
        super(AccountPlanID.NULL);
        userID = UserID.NULL;
        plan = AccountPlanType.UNKNOWN;
        startDate = null;
        expiredDate = null;
        isExpired = null;
        promoCode = null;
    }


    @Override
    public Boolean isNull() {
        return this == NULL;
    }

    public AccountPlanRoot(AccountPlanID accountPlanID,
                           Long version,
                           ProcessStatus processStatus,
                           RowStatus rowStatus,
                           ZonedDateTime createdDate,
                           ZonedDateTime modificationDate,
                           UserID userID,
                           AccountPlanType plan,
                           ZonedDateTime startDate,
                           ZonedDateTime expiredDate,
                           Boolean isExpired,
                           String promoCode) {
        super(accountPlanID, version, processStatus, rowStatus, createdDate, modificationDate);
        this.userID = userID;
        this.plan = plan;
        this.startDate = startDate;
        this.expiredDate = expiredDate;
        this.isExpired = isExpired;
        this.promoCode = promoCode;
    }

    private AccountPlanRoot(Builder builder) {
        super(builder.accountPlanID, builder.version, builder.processStatus, builder.rowStatus, builder.createdDate, builder.modificationDate);
        userID = builder.userID;
        plan = builder.plan;
        startDate = builder.startDate;
        expiredDate = builder.expiredDate;
        isExpired = builder.isExpired;
        promoCode = builder.promoCode;
    }

    public UserID getUserID() {
        return userID;
    }

    public AccountPlanType getPlan() {
        return plan;
    }

    public ZonedDateTime getStartDate() {
        return startDate;
    }

    public ZonedDateTime getExpiredDate() {
        return expiredDate;
    }

    public Boolean getExpired() {
        return isExpired;
    }

    public String getPromoCode() {
        return promoCode;
    }

    public static final class Builder {
        private AccountPlanID accountPlanID;
        private Version version;
        private ProcessStatus processStatus;
        private RowStatus rowStatus;
        private ZonedDateTime createdDate;
        private ZonedDateTime modificationDate;
        private UserID userID;
        private AccountPlanType plan;
        private ZonedDateTime startDate;
        private ZonedDateTime expiredDate;
        private Boolean isExpired;
        private String promoCode;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder accountPlanID(AccountPlanID val) {
            accountPlanID = val;
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

        public Builder user(UserID val) {
            userID = val;
            return this;
        }

        public Builder plan(AccountPlanType val) {
            plan = val;
            return this;
        }

        public Builder startDate(ZonedDateTime val) {
            startDate = val;
            return this;
        }

        public Builder expiredDate(ZonedDateTime val) {
            expiredDate = val;
            return this;
        }

        public Builder isExpired(Boolean val) {
            isExpired = val;
            return this;
        }

        public Builder promoCode(String val) {
            promoCode = val;
            return this;
        }

        public AccountPlanRoot build() {
            return new AccountPlanRoot(this);
        }
    }
}
