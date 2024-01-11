package com.intellibucket.onnetwork.company.domain.core.command.root.company;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.company.CompanyID;
import az.rock.lib.domain.id.company.CompanyProfileID;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.Version;


import java.time.ZonedDateTime;



public class CompanyProfileRoot extends AggregateRoot<CompanyProfileID> {
    private CompanyID companyID;

    private Boolean isHiring;

    private CompanyProfileRoot(Builder builder){
        super(builder.companyProfileID, builder.version, builder.processStatus, builder.rowStatus, builder.createdDate, builder.modificationDate);
        companyID = builder.companyID;
        isHiring = builder.isHiring;
    }

    public static final class Builder {
        private CompanyProfileID companyProfileID;
        private CompanyID companyID;
        private Boolean isHiring;
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

        public Builder isHiring(Boolean isHiring) {
            this.isHiring = isHiring;
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

        public Builder uuid(CompanyProfileID companyProfileID) {
            this.companyProfileID = companyProfileID;
            return this;
        }

        public CompanyProfileRoot build() {
            return new CompanyProfileRoot(this);
        }
    }

    public CompanyID getCompanyID() {
        return companyID;
    }

    public Boolean getHiring() {
        return isHiring;
    }
}
