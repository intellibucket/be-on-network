package com.intellibucket.onnetwork.company.domain.core.command.root.company;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.auth.EmailID;
import az.rock.lib.domain.id.company.CompanyID;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.Version;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.UUID;

public class EmailRoot extends AggregateRoot<EmailID> {
    private CompanyID companyID;

    private AccessModifier accessModifier;

    private String email;

    private Boolean isPrimary;

    private Boolean isVerified;

    private String verificationCode;

    private ZonedDateTime verificationRequestDate;

    private ZonedDateTime verificationResponseDate;


    private EmailRoot(Builder builder){
        super(builder.emailID, builder.version, builder.processStatus, builder.rowStatus, builder.createdDate, builder.modificationDate);
        companyID = builder.companyID;
        accessModifier = builder.accessModifier;
        email = builder.email;
        isPrimary = builder.isPrimary;
        isVerified = builder.isVerified;
        verificationCode = builder.verificationCode;
        verificationRequestDate = builder.verificationRequestDate;
        verificationResponseDate = builder.verificationResponseDate;
    }

    public static final class Builder {
        private EmailID emailID;
        private CompanyID companyID;
        private AccessModifier accessModifier;
        private String email;
        private Boolean isPrimary;
        private Boolean isVerified;
        private String verificationCode;
        private ZonedDateTime verificationRequestDate;
        private ZonedDateTime verificationResponseDate;
        private Version version;
        private ProcessStatus processStatus;
        private RowStatus rowStatus;
        private ZonedDateTime createdDate;
        private ZonedDateTime modificationDate;


        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder companyID(CompanyID companyID) {
            this.companyID = companyID;
            return this;
        }

        public Builder accessModifier(AccessModifier accessModifier) {
            this.accessModifier = accessModifier;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
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

        public Builder verificationRequestDate(ZonedDateTime verificationRequestDate) {
            this.verificationRequestDate = verificationRequestDate;
            return this;
        }

        public Builder verificationResponseDate(ZonedDateTime verificationResponseDate) {
            this.verificationResponseDate = verificationResponseDate;
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
           return new EmailRoot(this);
        }
    }
}
