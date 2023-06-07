package az.rock.flyjob.auth.dataAccess.entity.user;

import az.rock.flyjob.auth.dataAccess.entity.user.UserEntity;
import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.EmailType;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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
@Table(name = "emails", schema = "auth")
@Entity(name = "EmailEntity")
public class EmailEntity extends BaseEntity {

    @Column(length = 32, columnDefinition = "varchar(32) default 'ONLY_AUTHENTICATED'")
    @Enumerated(EnumType.STRING)
    private AccessModifier accessModifier;
    @ManyToOne
    private UserEntity user;

    @Enumerated(EnumType.STRING)
    private EmailType type;

    @Email
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "is_enable_notification", nullable = false,columnDefinition = "boolean default false")
    private Boolean isEnableNotification;

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

    @Column(name = "is_subscribed_promotions", nullable = false,columnDefinition = "boolean default false")
    private Boolean isSubscribedPromotions;

    @Column(name = "subscribed_date")
    private Timestamp subscribedDate;

    private EmailEntity(Builder builder) {
        setUser(builder.user);
        setType(builder.type);
        setEmail(builder.email);
        setIsEnableNotification(builder.isEnableNotification);
        setAccessModifier(builder.accessModifier);
        setIsPrimary(builder.isPrimary);
        setIsVerified(builder.isVerified);
        setVerificationCode(builder.verificationCode);
        setVerificationCodeExpireDate(builder.verificationCodeExpireDate);
        setVerificationCodeSendDate(builder.verificationCodeSendDate);
        setVerificationCodeSendCount(builder.verificationCodeSendCount);
        setIsSubscribedPromotions(builder.isSubscribedPromotions);
        setSubscribedDate(builder.subscribedDate);
        setUuid(builder.uuid);
        setVersion(builder.version);
        setProcessStatus(builder.processStatus);
        setRowStatus(builder.rowStatus);
        setCreatedDate(builder.createdDate);
        setLastModifiedDate(builder.lastModifiedDate);
    }


    public static final class Builder {
        private UserEntity user;
        private EmailType type;
        private @Email String email;

        private AccessModifier accessModifier;
        private Boolean isEnableNotification;
        private Boolean isPrimary;
        private Boolean isVerified;
        private String verificationCode;
        private Timestamp verificationCodeExpireDate;
        private Timestamp verificationCodeSendDate;
        private BigInteger verificationCodeSendCount;
        private Boolean isSubscribedPromotions;
        private Timestamp subscribedDate;
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

        public Builder user(UserEntity val) {
            user = val;
            return this;
        }

        public Builder type(EmailType val) {
            type = val;
            return this;
        }

        public Builder email(@Email String val) {
            email = val;
            return this;
        }

        public Builder accessModifier(AccessModifier val) {
            accessModifier = val;
            return this;
        }

        public Builder isEnableNotification(Boolean val) {
            isEnableNotification = val;
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

        public Builder isSubscribedPromotions(Boolean val) {
            isSubscribedPromotions = val;
            return this;
        }

        public Builder subscribedDate(Timestamp val) {
            subscribedDate = val;
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

        public EmailEntity build() {
            return new EmailEntity(this);
        }
    }
}
