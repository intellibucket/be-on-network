package com.intellibucket.onnetwork.company.domain.core.command.root.company;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.company.CompanyID;
import az.rock.lib.domain.id.company.WebsiteID;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.Version;

import java.time.ZonedDateTime;
import java.util.UUID;

public class WebsiteRoot extends AggregateRoot<WebsiteID> {
    private CompanyID companyID;

    private String website;


    private Boolean isVerified;

    private ZonedDateTime verificationRequestDate;

    private ZonedDateTime verificationResponseDate;

    private WebsiteRoot(Builder builder) {
        super(builder.websiteID,builder.version,builder.processStatus,builder.rowStatus,builder.createdDate,builder.modificationDate);
        companyID = builder.companyID;
        website = builder.website;
        isVerified = builder.isVerified;
        verificationRequestDate = builder.verificationRequestDate;
        verificationResponseDate = builder.verificationResponseDate;
    }

    public static final class Builder {
        private WebsiteID websiteID;

        private Version version;

        private ProcessStatus processStatus;

        private RowStatus rowStatus;

        private ZonedDateTime createdDate;

        private ZonedDateTime modificationDate;
        private CompanyID companyID;
        private String website;
        private Boolean isVerified;
        private ZonedDateTime verificationRequestDate;
        private ZonedDateTime verificationResponseDate;

        private Builder(){}

        public static Builder builder(){
            return new Builder();
        }

        public Builder uuid(UUID uuid){
            this.websiteID = WebsiteID.of(uuid);
            return this;
        }

        public  Builder version(Long val) {
            version = Version.of(val);
            return this;
        }

        public Builder version(Version val) {
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

        public Builder createdDate(ZonedDateTime val) {
            createdDate = val;
            return this;
        }

        public Builder modificationDate(ZonedDateTime val) {
            modificationDate = val;
            return this;
        }

        public Builder companyId(UUID val) {
            companyID = CompanyID.of(val);
            return this;
        }

        public Builder website(String website){
            this.website = website;
            return this;
        }

        public Builder isVerified(Boolean isVerified){
            this.isVerified = isVerified;
            return this;
        }


        public Builder verificationRequestDate(ZonedDateTime verificationRequestDate){
            this.verificationRequestDate = verificationRequestDate;
            return this;
        }

        public Builder verificationResponseDate(ZonedDateTime verificationResponseDate) {
            this.verificationResponseDate = verificationResponseDate;
            return this;
        }
        public WebsiteRoot build() {
            return new WebsiteRoot(this);
        }
    }

    public CompanyID getCompanyID() {
        return companyID;
    }

    public String getWebsite() {
        return website;
    }

    public Boolean getVerified() {
        return isVerified;
    }

    public ZonedDateTime getVerificationRequestDate() {
        return verificationRequestDate;
    }

    public ZonedDateTime getVerificationResponseDate() {
        return verificationResponseDate;
    }
}
