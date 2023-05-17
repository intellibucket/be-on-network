package az.rock.flyjob.auth.root;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.AccountPlanID;
import az.rock.lib.valueObject.AccountPlanType;
import az.rock.lib.valueObject.DataStatus;
import az.rock.lib.valueObject.ProcessStatus;

import java.sql.Timestamp;
import java.time.ZonedDateTime;

public final class AccountPlanRoot extends AggregateRoot<AccountPlanID> {

    private final UserRoot user;

    private final AccountPlanType plan;

    private final ZonedDateTime startDate;

    private final ZonedDateTime expiredDate;

    private final Boolean isExpired;

    private final String promoCode;


    public AccountPlanRoot(AccountPlanID accountPlanID,
                           Long version,
                           ProcessStatus processStatus,
                           DataStatus dataStatus,
                           ZonedDateTime createdDate,
                           ZonedDateTime modificationDate,
                           UserRoot user,
                           AccountPlanType plan,
                           ZonedDateTime startDate,
                           ZonedDateTime expiredDate,
                           Boolean isExpired,
                           String promoCode) {
        super(accountPlanID, version, processStatus, dataStatus, createdDate, modificationDate);
        this.user = user;
        this.plan = plan;
        this.startDate = startDate;
        this.expiredDate = expiredDate;
        this.isExpired = isExpired;
        this.promoCode = promoCode;
    }

    private AccountPlanRoot(Builder builder) {
        super(builder.accountPlanID, builder.version, builder.processStatus, builder.dataStatus, builder.createdDate, builder.modificationDate);
        user = builder.user;
        plan = builder.plan;
        startDate = builder.startDate;
        expiredDate = builder.expiredDate;
        isExpired = builder.isExpired;
        promoCode = builder.promoCode;
    }

    public UserRoot getUser() {
        return user;
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
        private Long version;
        private ProcessStatus processStatus;
        private DataStatus dataStatus;
        private ZonedDateTime createdDate;
        private ZonedDateTime modificationDate;
        private UserRoot user;
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
