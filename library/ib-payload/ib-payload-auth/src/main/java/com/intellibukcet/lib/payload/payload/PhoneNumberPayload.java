package com.intellibukcet.lib.payload.payload;

import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.PhoneNumberType;

import java.math.BigInteger;
import java.time.ZonedDateTime;
import java.util.UUID;

public class PhoneNumberPayload {
    private final UUID id;

    private final UUID userID;

    private final AccessModifier accessModifier;

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

    private PhoneNumberPayload(Builder builder) {
        id = builder.id;
        userID = builder.userID;
        accessModifier = builder.accessModifier;
        countryCode = builder.countryCode;
        phoneNumber = builder.phoneNumber;
        type = builder.type;
        isEnableSmsNotification = builder.isEnableSmsNotification;
        isEnableWhatsappNotification = builder.isEnableWhatsappNotification;
        isPrimary = builder.isPrimary;
        isVerified = builder.isVerified;
        verificationCode = builder.verificationCode;
        verificationCodeExpireDate = builder.verificationCodeExpireDate;
        verificationCodeSendDate = builder.verificationCodeSendDate;
        verificationCodeSendCount = builder.verificationCodeSendCount;
    }


    public static final class Builder {
        private UUID id;
        private UUID userID;
        private AccessModifier accessModifier;
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

        public Builder id(UUID val) {
            id = val;
            return this;
        }

        public Builder userID(UUID val) {
            userID = val;
            return this;
        }

        public Builder accessModifier(AccessModifier val) {
            accessModifier = val;
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

        public Builder verificationCodeExpireDate(ZonedDateTime val) {
            verificationCodeExpireDate = val;
            return this;
        }

        public Builder verificationCodeSendDate(ZonedDateTime val) {
            verificationCodeSendDate = val;
            return this;
        }

        public Builder verificationCodeSendCount(BigInteger val) {
            verificationCodeSendCount = val;
            return this;
        }

        public PhoneNumberPayload build() {
            return new PhoneNumberPayload(this);
        }
    }
}
