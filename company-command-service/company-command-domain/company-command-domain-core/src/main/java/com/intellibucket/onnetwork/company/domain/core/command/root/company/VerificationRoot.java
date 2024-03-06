package com.intellibucket.onnetwork.company.domain.core.command.root.company;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.company.CompanyID;
import az.rock.lib.domain.id.company.VerificationID;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.Version;
import az.rock.lib.valueObject.vacancy.CompanyVerificationType;

import java.time.ZonedDateTime;


public class VerificationRoot extends AggregateRoot<VerificationID> {
    private CompanyID companyID;

    private Boolean isVerified;

    private CompanyVerificationType verificationType;

    private ZonedDateTime verificationRequestDate;

    private ZonedDateTime verificationResponseDate;


    private VerificationRoot(Builder builder){
        super(builder.verificationUuid, builder.version, builder.processStatus, builder.rowStatus, builder.createdDate, builder.modificationDate);
        companyID = builder.companyID;
        isVerified = builder.isVerified;
        verificationType = builder.verificationType;
        verificationRequestDate = builder.verificationRequestDate;
        verificationResponseDate = builder.verificationResponseDate;
    }

    public static final class Builder {
        private VerificationID verificationUuid;

        private CompanyID companyID;
        private Boolean isVerified;
        private CompanyVerificationType verificationType;
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

        public Builder isVerified(Boolean isVerified) {
            this.isVerified = isVerified;
            return this;
        }

        public Builder verificationType(CompanyVerificationType verificationType) {
            this.verificationType = verificationType;
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

        public Builder uuid(VerificationID verificationUuid) {
            this.verificationUuid = verificationUuid;
            return this;
        }

        public VerificationRoot build() {
           return new VerificationRoot(this);
        }
    }

    public CompanyID getCompanyID() {
        return companyID;
    }

    public Boolean getVerified() {
        return isVerified;
    }

    public CompanyVerificationType getVerificationType() {
        return verificationType;
    }

    public ZonedDateTime getVerificationRequestDate() {
        return verificationRequestDate;
    }

    public ZonedDateTime getVerificationResponseDate() {
        return verificationResponseDate;
    }
}
