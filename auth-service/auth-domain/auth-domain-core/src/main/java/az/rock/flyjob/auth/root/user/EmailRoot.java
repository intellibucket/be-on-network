package az.rock.flyjob.auth.root.user;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.auth.EmailID;
import az.rock.lib.domain.id.auth.UserID;
import az.rock.lib.valueObject.*;

import java.math.BigInteger;
import java.time.ZonedDateTime;
import java.util.Objects;

public class EmailRoot extends AggregateRoot<EmailID> {
    private final UserID userID;
    private final AccessModifier accessModifier;
    private final EmailType type;
    private final String email;
    private Boolean isEnableNotification;
    private Boolean isPrimary;
    private Boolean isVerified;
    private String verificationCode;
    private final ZonedDateTime verificationCodeExpireDate;
    private final ZonedDateTime verificationCodeSendDate;
    private final BigInteger verificationCodeSendCount;
    private Boolean isSubscribedPromotions;
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
                     AccessModifier accessModifier,
                     Boolean isEnableNotification,
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
        this.accessModifier = accessModifier;
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

    public AccessModifier getAccessModifier() {
        return accessModifier;
    }

    public Boolean isEnableNotification() {
        return isEnableNotification;
    }

    public Boolean isPrimary() {
        return isPrimary;
    }

    public Boolean isPublic() {
        return accessModifier.isPublic();
    }

    public Boolean isVerified() {
        return isVerified;
    }

    public EmailRoot enableNotification() {
        this.isEnableNotification = Boolean.TRUE;
        return this;
    }

    public EmailRoot changeEmailNotification(SwitchCase switchCase) {
        if (switchCase.isActive()) return enableNotification();
        else return disableNotification();
    }

    public EmailRoot disableNotification() {
        this.isEnableNotification = Boolean.FALSE;
        return this;
    }

    public EmailRoot changeUnPrimary() {
        this.isPrimary = Boolean.FALSE;
        return this;
    }

    public EmailRoot changePrimary() {
        this.isPrimary = Boolean.TRUE;
        return this;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmailRoot emailRoot)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getEmail(), emailRoot.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getEmail());
    }

    public Boolean isOwned(UserID userID) {
        return this.userID.equals(userID);
    }

    public EmailRoot changeEmailSubscribedPromotions(SwitchCase switchCase) {
        if (switchCase.isActive()) return enableSubscribedPromotions();
        else return disableSubscribedPromotions();
    }

    public EmailRoot enableSubscribedPromotions() {
        this.isSubscribedPromotions = Boolean.TRUE;
        return this;
    }

    public EmailRoot disableSubscribedPromotions() {
        this.isSubscribedPromotions = Boolean.FALSE;
        return this;
    }

    public static final class Builder {
        private UserID userID;
        private EmailType type;
        private String email;

        private AccessModifier accessModifier = AccessModifier.PRIVATE;
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

        public Builder accessModifier(AccessModifier accessModifier) {
            this.accessModifier = accessModifier;
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
            return new EmailRoot(emailID, version, processStatus, rowStatus, createdDate, modificationDate, userID, type, email, accessModifier, isEnableNotification, isPrimary, isVerified, verificationCode, verificationCodeExpireDate, verificationCodeSendDate, verificationCodeSendCount, isSubscribedPromotions, subscribedDate);
        }
    }
}
