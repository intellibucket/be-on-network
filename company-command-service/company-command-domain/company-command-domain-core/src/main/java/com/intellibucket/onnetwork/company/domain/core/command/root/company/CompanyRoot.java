package com.intellibucket.onnetwork.company.domain.core.command.root.company;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.company.CompanyID;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.Version;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Getter
public class CompanyRoot extends AggregateRoot<CompanyID> {
    private UUID userID;

    private String name;

    private String description;


    private CompanyProfileRoot profile;

    private List<VerificationRoot> verifications;

    private List<EmailRoot> emails;

    private WebsiteRoot websites;

    private CompanyRoot(Builder builder) {
        super(builder.companyID, builder.version, builder.processStatus, builder.rowStatus, builder.createdDate, builder.modificationDate);
        userID = builder.userID;
        name = builder.name;
        description = builder.description;
        profile = builder.profile;
        verifications = builder.verifications;
        emails = builder.emails;
        websites = builder.websites;
    }

    public static final class Builder{
        private CompanyID companyID;

        private Version version;

        private ProcessStatus processStatus;

        private RowStatus rowStatus;

        private ZonedDateTime createdDate;

        private ZonedDateTime modificationDate;

        private UUID userID;

        private String name;

        private String description;

        private CompanyProfileRoot profile;

        private List<VerificationRoot> verifications;

        private List<EmailRoot> emails;

        private WebsiteRoot websites;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder uuid(UUID uuid){
            this.companyID = CompanyID.of(uuid);
            return this;
        }

        public Builder uuid(CompanyID companyID){
            this.companyID = companyID;
            return this;
        }

        public Builder version(Long val) {
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

        public Builder userId(UUID val) {
            userID = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder description(String val) {
            description = val;
            return this;
        }

        public Builder profile(CompanyProfileRoot val) {
            profile = val;
            return this;
        }

        public Builder verification(List<VerificationRoot> val) {
            verifications = val;
            return this;
        }

        public Builder email(List<EmailRoot> val) {
            emails = val;
            return this;
        }
        public Builder website(WebsiteRoot val) {
            websites = val;
            return this;
        }

        public CompanyRoot build() {
            return new CompanyRoot(this);
        }

    }

}
