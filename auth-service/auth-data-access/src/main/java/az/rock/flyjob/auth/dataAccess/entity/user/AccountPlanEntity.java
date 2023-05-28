package az.rock.flyjob.auth.dataAccess.entity.user;

import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.AccountPlanType;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.ProcessStatus;
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
@Table(name = "account_plan", schema = "auth")
@Entity(name = "AccountPlanEntity")
public class AccountPlanEntity extends BaseEntity {

    @ManyToOne
    private UserEntity user;

    @Column(name = "plan", nullable = false, length = 100,columnDefinition = "varchar(20) default 'FREE'")
    private AccountPlanType plan;

    @Column(name = "start_date", nullable = false, updatable = false)
    private Timestamp startDate;

    @Column(name = "expired_date", nullable = false, updatable = false)
    private Timestamp expiredDate;

    @Column(name = "is_expired", nullable = false, columnDefinition = "boolean default false")
    private Boolean isExpired;

    @Column(name = "promo_code", nullable = true,updatable = false, length = 100)
    private String promoCode;

    private AccountPlanEntity(Builder builder) {
        setUser(builder.userEntity);
        setPlan(builder.plan);
        setStartDate(builder.startDate);
        setExpiredDate(builder.expiredDate);
        setIsExpired(builder.isExpired);
        setPromoCode(builder.promoCode);
        setUuid(builder.uuid);
        setVersion(builder.version);
        setProcessStatus(builder.processStatus);
        setRowStatus(builder.rowStatus);
        setCreatedDate(builder.createdDate);
        setLastModifiedDate(builder.lastModifiedDate);
    }


    public static final class Builder {
        private UserEntity userEntity;
        private AccountPlanType plan;
        private Timestamp startDate;
        private Timestamp expiredDate;
        private Boolean isExpired;
        private String promoCode;
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

        public Builder userEntity(UserEntity val) {
            userEntity = val;
            return this;
        }

        public Builder plan(AccountPlanType val) {
            plan = val;
            return this;
        }

        public Builder startDate(Timestamp val) {
            startDate = val;
            return this;
        }

        public Builder expiredDate(Timestamp val) {
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

        public AccountPlanEntity build() {
            return new AccountPlanEntity(this);
        }
    }
}
