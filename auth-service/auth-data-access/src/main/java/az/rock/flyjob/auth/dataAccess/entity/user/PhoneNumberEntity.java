package az.rock.flyjob.auth.dataAccess.entity.user;

import az.rock.flyjob.auth.dataAccess.entity.user.UserEntity;
import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.PhoneNumberType;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "phone_numbers", schema = "auth")
@Entity(name = "PhoneNumberEntity")
public class PhoneNumberEntity extends BaseEntity {

    @Column(length = 32, columnDefinition = "varchar(32) default 'ONLY_AUTHENTICATED'")
    @Enumerated(EnumType.STRING)
    private AccessModifier accessModifier;
    @ManyToOne
    private UserEntity user;

    @Column(name = "country_code", length = 1, nullable = false)
    private String countryCode;

    @Column(name = "phone_number", length = 20, nullable = false)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private PhoneNumberType type;

    @Column(name = "is_enable_sms_notification", nullable = false,columnDefinition = "boolean default false")
    private Boolean isEnableSmsNotification;

    @Column(name = "is_enable_whatsapp_notification", nullable = false,columnDefinition = "boolean default false")
    private Boolean isEnableWhatsappNotification;

    @Column(name = "is_primary", nullable = false,columnDefinition = "boolean default false")
    private Boolean isPrimary;

    @Column(name = "is_verified", nullable = false,columnDefinition = "boolean default false")
    private Boolean isVerified;

    @Column(name = "verification_code", length = 6)
    private String verificationCode;

    @Column(name = "verification_code_expire_date")
    private Timestamp verificationCodeExpireDate;

    @Column(name = "verification_code_send_date")
    private Timestamp verificationCodeSendDate;

    @Column(name = "verification_code_send_count")
    private BigInteger verificationCodeSendCount;

    private PhoneNumberEntity(Builder builder) {
        setUser(builder.user);
        setAccessModifier(builder.accessModifier);
        setCountryCode(builder.countryCode);
        setPhoneNumber(builder.phoneNumber);
        setType(builder.type);
        setIsEnableSmsNotification(builder.isEnableSmsNotification);
        setIsEnableWhatsappNotification(builder.isEnableWhatsappNotification);
        setIsPrimary(builder.isPrimary);
        setIsVerified(builder.isVerified);
        setVerificationCode(builder.verificationCode);
        setVerificationCodeExpireDate(builder.verificationCodeExpireDate);
        setVerificationCodeSendDate(builder.verificationCodeSendDate);
        setVerificationCodeSendCount(builder.verificationCodeSendCount);
        setUuid(builder.uuid);
        setVersion(builder.version);
        setProcessStatus(builder.processStatus);
        setRowStatus(builder.rowStatus);
        setCreatedDate(builder.createdDate);
        setLastModifiedDate(builder.lastModifiedDate);
    }


    public static final class Builder {
        private UserEntity user;
        private AccessModifier accessModifier = AccessModifier.PRIVATE;
        private String countryCode;
        private String phoneNumber;
        private PhoneNumberType type;
        private Boolean isEnableSmsNotification;
        private Boolean isEnableWhatsappNotification;
        private Boolean isPrimary;
        private Boolean isVerified;
        private String verificationCode;
        private Timestamp verificationCodeExpireDate;
        private Timestamp verificationCodeSendDate;
        private BigInteger verificationCodeSendCount;
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


        public Builder accessModifier(AccessModifier val) {
            accessModifier = val;
            return this;
        }
        public Builder user(UserEntity val) {
            user = val;
            return this;
        }

        public Builder countryCode(String val) {
            countryCode = val;
            return this;
        }

        public Builder phoneNumber(String val) {
            phoneNumber = val;
            return this;
        }

        public Builder type(PhoneNumberType val) {
            type = val;
            return this;
        }

        public Builder isEnableSmsNotification(Boolean val) {
            isEnableSmsNotification = val;
            return this;
        }

        public Builder isEnableWhatsappNotification(Boolean val) {
            isEnableWhatsappNotification = val;
            return this;
        }

        public Builder isPrimary(Boolean val) {
            isPrimary = val;
            return this;
        }

        public Builder isVerified(Boolean val) {
            isVerified = val;
            return this;
        }

        public Builder verificationCode(String val) {
            verificationCode = val;
            return this;
        }

        public Builder verificationCodeExpireDate(Timestamp val) {
            verificationCodeExpireDate = val;
            return this;
        }

        public Builder verificationCodeSendDate(Timestamp val) {
            verificationCodeSendDate = val;
            return this;
        }

        public Builder verificationCodeSendCount(BigInteger val) {
            verificationCodeSendCount = val;
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

        public PhoneNumberEntity build() {
            return new PhoneNumberEntity(this);
        }
    }
}
