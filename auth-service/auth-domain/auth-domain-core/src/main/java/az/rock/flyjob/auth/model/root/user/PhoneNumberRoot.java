package az.rock.flyjob.auth.model.root.user;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.auth.PhoneNumberID;
import az.rock.lib.domain.id.auth.UserID;
import az.rock.lib.valueObject.*;

import java.math.BigInteger;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PhoneNumberRoot extends AggregateRoot<PhoneNumberID> {
    private final UserID userID;

    private AccessModifier accessModifier ;

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

    public static Map<PhoneNumberID,PhoneNumberRoot> groupByPhoneNumberID(List<PhoneNumberRoot> phoneNumberRoots){
        return phoneNumberRoots.stream().collect(Collectors.toMap(PhoneNumberRoot::getRootID, Function.identity()));
    }

    public Boolean isValid() {
        var countryCodePatter = "^[+][0-9]{1,3}$";
        var pattern = "^[0-9]{1,15}$";
        return this.countryCode.matches(countryCodePatter) &&
                this.phoneNumber.matches(pattern) &&
                this.type != null;
    }

    public PhoneNumberRoot enableSmsNotification() {
        this.isEnableSmsNotification = true;
        return this;
    }


    public PhoneNumberRoot disableSmsNotification() {
        this.isEnableSmsNotification = false;
        return this;
    }

    public PhoneNumberRoot enableWhatsappNotification() {
        this.isEnableWhatsappNotification = true;
        return this;
    }

    public PhoneNumberRoot disableWhatsappNotification() {
        this.isEnableWhatsappNotification = false;
        return this;
    }

    public PhoneNumberRoot setPrimary() {
        this.isPrimary = true;
        return this;
    }

    public PhoneNumberRoot setNotPrimary() {
        this.isPrimary = false;
        return this;
    }

    public PhoneNumberRoot setVerified() {
        this.isVerified = true;
        return this;
    }

    public PhoneNumberRoot setNotVerified() {
        this.isVerified = false;
        return this;
    }

    public PhoneNumberRoot setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
        return this;
    }

    public PhoneNumberRoot setVerificationCodeExpireDate(ZonedDateTime verificationCodeExpireDate) {
        this.verificationCodeExpireDate = verificationCodeExpireDate;
        return this;
    }

    public PhoneNumberRoot setVerificationCodeSendDate(ZonedDateTime verificationCodeSendDate) {
        this.verificationCodeSendDate = verificationCodeSendDate;
        return this;
    }

    public PhoneNumberRoot incrementVerificationCodeSendCount() {
        this.verificationCodeSendCount = this.verificationCodeSendCount.add(BigInteger.ONE);
        return this;
    }

    public PhoneNumberRoot changeType(PhoneNumberType type) {
        this.type = type;
        return this;
    }


    public PhoneNumberRoot changeCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    public PhoneNumberRoot changePhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public void disablePrimary() {
        this.isPrimary = false;
    }

    public void enablePrimary() {
        this.isPrimary = true;
    }


    public static final class Builder {

        private PhoneNumberID phoneNumberID;
        private Long version;
        private ProcessStatus processStatus;
        private RowStatus rowStatus;
        private ZonedDateTime createdDate;
        private ZonedDateTime modificationDate;
        private UserID userID;
        private AccessModifier accessModifier = AccessModifier.AUTHENTICATED;
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

        public Builder version(Version version) {
            this.version = version.value();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumberRoot that = (PhoneNumberRoot) o;
        return Objects.requireNonNullElse(this.countryCode, "").equalsIgnoreCase(that.countryCode) &&
                Objects.requireNonNullElse(this.phoneNumber, "").equalsIgnoreCase(that.phoneNumber) &&
                type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), countryCode, phoneNumber, type);
    }
}