package az.rock.flyjob.auth.root.user;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.EmailID;
import az.rock.lib.domain.id.UserID;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.EmailType;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.Version;

import java.math.BigInteger;
import java.time.ZonedDateTime;

public class EmailRoot extends AggregateRoot<EmailID> {
    private final UserID userID;
    private final EmailType type;
    private final String email;

    private final Boolean isPublic;
    private final Boolean isEnableNotification;
    private final Boolean isPrimary;
    private final Boolean isVerified;
    private final String verificationCode;
    private final ZonedDateTime verificationCodeExpireDate;
    private final ZonedDateTime verificationCodeSendDate;
    private final BigInteger verificationCodeSendCount;
    private final Boolean isSubscribedPromotions;
    private final ZonedDateTime subscribedDate;
    public EmailRoot(EmailID emailID,
                     Version version,
                     ProcessStatus processStatus,
                     RowStatus rowStatus,
                     ZonedDateTime createdDate,
                     ZonedDateTime modificationDate,
                     UserID userID,
                     EmailType type,
                     String email,
                     Boolean isPublic, Boolean isEnableNotification,
                     Boolean isPrimary,
                     Boolean isVerified,
                     String verificationCode,
                     ZonedDateTime verificationCodeExpireDate,
                     ZonedDateTime verificationCodeSendDate,
                     BigInteger verificationCodeSendCount,
                     Boolean isSubscribedPromotions,
                     ZonedDateTime subscribedDate) {
        super(emailID, version, processStatus, rowStatus, createdDate, modificationDate);
        this.userID = userID;
        this.type = type;
        this.email = email;
        this.isPublic = isPublic;
        this.isEnableNotification = isEnableNotification;
        this.isPrimary = isPrimary;
        this.isVerified = isVerified;
        this.verificationCode = verificationCode;
        this.verificationCodeExpireDate = verificationCodeExpireDate;
        this.verificationCodeSendDate = verificationCodeSendDate;
        this.verificationCodeSendCount = verificationCodeSendCount;
        this.isSubscribedPromotions = isSubscribedPromotions;
        this.subscribedDate = subscribedDate;
    }

    public UserID getUserId() {
        return userID;
    }

    public EmailType getType() {
        return type;
    }

    public String getEmail() {
        return email;
    }

    public Boolean isEnableNotification() {
        return isEnableNotification;
    }

    public Boolean isPrimary() {
        return isPrimary;
    }

    public Boolean isPublic() {
        return isPublic;
    }

    public Boolean isVerified() {
        return isVerified;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public ZonedDateTime getVerificationCodeExpireDate() {
        return verificationCodeExpireDate;
    }

    public ZonedDateTime getVerificationCodeSendDate() {
        return verificationCodeSendDate;
    }

    public BigInteger getVerificationCodeSendCount() {
        return verificationCodeSendCount;
    }

    public Boolean isSubscribedPromotions() {
        return isSubscribedPromotions;
    }

    public ZonedDateTime getSubscribedDate() {
        return subscribedDate;
    }

    public static final class Builder {
        private UserID userID;
        private EmailType type;
        private String email;

        private Boolean isPublic = Boolean.TRUE;
        private Boolean isEnableNotification;
        private Boolean isPrimary;
        private Boolean isVerified;
        private String verificationCode;
        private ZonedDateTime verificationCodeExpireDate;
        private ZonedDateTime verificationCodeSendDate;
        private BigInteger verificationCodeSendCount;
        private Boolean isSubscribedPromotions;
        private ZonedDateTime subscribedDate;
        private Version version;
        private ProcessStatus processStatus;
        private RowStatus rowStatus;
        private ZonedDateTime createdDate;
        private ZonedDateTime modificationDate;
        private EmailID emailID;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder user(UserID userID) {
            this.userID = userID;
            return this;
        }

        public Builder isPublic(Boolean isPublic) {
            this.isPublic = isPublic;
            return this;
        }

        public Builder type(EmailType type) {
            this.type = type;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder isEnableNotification(Boolean isEnableNotification) {
            this.isEnableNotification = isEnableNotification;
            return this;
        }

        public Builder isPrimary(Boolean isPrimary) {
            this.isPrimary = isPrimary;
            return this;
        }

        public Builder isVerified(Boolean isVerified) {
            this.isVerified = isVerified;
            return this;
        }

        public Builder verificationCode(String verificationCode) {
            this.verificationCode = verificationCode;
            return this;
        }

        public Builder verificationCodeExpireDate(ZonedDateTime verificationCodeExpireDate) {
            this.verificationCodeExpireDate = verificationCodeExpireDate;
            return this;
        }

        public Builder verificationCodeSendDate(ZonedDateTime verificationCodeSendDate) {
            this.verificationCodeSendDate = verificationCodeSendDate;
            return this;
        }

        public Builder verificationCodeSendCount(BigInteger verificationCodeSendCount) {
            this.verificationCodeSendCount = verificationCodeSendCount;
            return this;
        }

        public Builder isSubscribedPromotions(Boolean isSubscribedPromotions) {
            this.isSubscribedPromotions = isSubscribedPromotions;
            return this;
        }

        public Builder subscribedDate(ZonedDateTime subscribedDate) {
            this.subscribedDate = subscribedDate;
            return this;
        }

        public Builder version(Long version) {
            this.version = Version.of(version);
            return this;
        }

        public Builder version(Version version) {
            this.version = version;
            return this;
        }

        public Builder processStatus(ProcessStatus processStatus) {
            this.processStatus = processStatus;
            return this;
        }

        public Builder rowStatus(RowStatus rowStatus) {
            this.rowStatus = rowStatus;
            return this;
        }

        public Builder createdDate(ZonedDateTime createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public Builder modificationDate(ZonedDateTime modificationDate) {
            this.modificationDate = modificationDate;
            return this;
        }

        public Builder uuid(EmailID emailID) {
            this.emailID = emailID;
            return this;
        }

        public EmailRoot build() {
            return new EmailRoot(emailID, version, processStatus, rowStatus, createdDate, modificationDate, userID, type, email, isPublic, isEnableNotification, isPrimary, isVerified, verificationCode, verificationCodeExpireDate, verificationCodeSendDate, verificationCodeSendCount, isSubscribedPromotions, subscribedDate);
        }
    }
}
