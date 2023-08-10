package az.rock.flyjob.auth.root.user;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.auth.PhoneNumberID;
import az.rock.lib.domain.id.auth.UserID;
import az.rock.lib.valueObject.*;

import java.math.BigInteger;
import java.time.ZonedDateTime;

public class PhoneNumberRoot extends AggregateRoot<PhoneNumberID> {
    private final UserID userID;

    private AccessModifier accessModifier ;

    private final String countryCode;

    private final String phoneNumber;

    private final PhoneNumberType type;

    private final Boolean isEnableSmsNotification;

    private final Boolean isEnableWhatsappNotification;

    private final Boolean isPrimary;

    private final Boolean isVerified;

    private final String verificationCode;

    private final ZonedDateTime verificationCodeExpireDate;

    private final ZonedDateTime verificationCodeSendDate;

    private final BigInteger verificationCodeSendCount;

    public PhoneNumberRoot(PhoneNumberID phoneNumberID,
                           AccessModifier accessModifier,
                           Long version,
                           ProcessStatus processStatus,
                           RowStatus rowStatus,
                           ZonedDateTime createdDate,
                           ZonedDateTime modificationDate,
                           UserID userID,
                           String countryCode,
                           String phoneNumber,
                           PhoneNumberType type,
                           Boolean isEnableSmsNotification,
                           Boolean isEnableWhatsappNotification,
                           Boolean isPrimary,
                           Boolean isVerified,
                           String verificationCode,
                           ZonedDateTime verificationCodeExpireDate,
                           ZonedDateTime verificationCodeSendDate,
                           BigInteger verificationCodeSendCount) {
        super(phoneNumberID, version, processStatus, rowStatus, createdDate, modificationDate);
        this.accessModifier = accessModifier;
        this.userID = userID;
        this.countryCode = countryCode;
        this.phoneNumber = phoneNumber;
        this.type = type;
        this.isEnableSmsNotification = isEnableSmsNotification;
        this.isEnableWhatsappNotification = isEnableWhatsappNotification;
        this.isPrimary = isPrimary;
        this.isVerified = isVerified;
        this.verificationCode = verificationCode;
        this.verificationCodeExpireDate = verificationCodeExpireDate;
        this.verificationCodeSendDate = verificationCodeSendDate;
        this.verificationCodeSendCount = verificationCodeSendCount;
    }


    public static final class Builder {

        private PhoneNumberID phoneNumberID;
        private Long version;
        private ProcessStatus processStatus;
        private RowStatus rowStatus;
        private ZonedDateTime createdDate;
        private ZonedDateTime modificationDate;
        private UserID userID;
        private AccessModifier accessModifier = AccessModifier.ONLY_AUTHENTICATED;
        private String countryCode;
        private String phoneNumber;
        private PhoneNumberType type;
        private Boolean isEnableSmsNotification;
        private Boolean isEnableWhatsappNotification;
        private Boolean isPrimary;
        private Boolean isVerified;
        private String verificationCode;
        private ZonedDateTime verificationCodeExpireDate;
        private ZonedDateTime verificationCodeSendDate;
        private BigInteger verificationCodeSendCount;

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

        public Builder countryCode(String countryCode) {
            this.countryCode = countryCode;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder type(PhoneNumberType type) {
            this.type = type;
            return this;
        }

        public Builder isEnableSmsNotification(Boolean isEnableSmsNotification) {
            this.isEnableSmsNotification = isEnableSmsNotification;
            return this;
        }

        public Builder isEnableWhatsappNotification(Boolean isEnableWhatsappNotification) {
            this.isEnableWhatsappNotification = isEnableWhatsappNotification;
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

        public Builder version(Long version) {
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

        public Builder uuid(PhoneNumberID phoneNumberID) {
            this.phoneNumberID = phoneNumberID;
            return this;
        }

        public PhoneNumberRoot build() {
            return  new PhoneNumberRoot(phoneNumberID,accessModifier, version, processStatus, rowStatus, createdDate, modificationDate, userID, countryCode, phoneNumber, type, isEnableSmsNotification, isEnableWhatsappNotification, isPrimary, isVerified, verificationCode, verificationCodeExpireDate, verificationCodeSendDate, verificationCodeSendCount);
        }
    }


    public AccessModifier getAccessModifier() {
        return accessModifier;
    }
    public UserID getUserID() {
        return userID;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public PhoneNumberType getType() {
        return type;
    }

    public Boolean getEnableSmsNotification() {
        return isEnableSmsNotification;
    }

    public Boolean getEnableWhatsappNotification() {
        return isEnableWhatsappNotification;
    }

    public Boolean getPrimary() {
        return isPrimary;
    }

    public Boolean getVerified() {
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
}