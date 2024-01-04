package com.intellibucket.onnetwork.company.dataAccess.command.model.entity.company;

import az.rock.lib.domain.BaseEntity;
import az.rock.lib.domain.id.company.CompanyID;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "CompanyEntity")
@Table(schema = "company", name = "companies")
@AllArgsConstructor
public class CompanyEntity extends BaseEntity {

    @Column(name = "user_uuid", nullable = false, updatable = false)
    private UUID userUUID;

    @Column(name = "name")
    @Max(100)
    private String name;

    @Column(name = "description")
    @Max(2000)
    private String description;

    @OneToOne(mappedBy = "company",cascade = {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    private CompanyProfileEntity profile;

    @OneToMany(mappedBy = "company", cascade = {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    private List<VerificationEntity> verifications;

    @OneToMany(mappedBy = "company", cascade = {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    private List<EmailEntity> emails;

    @OneToOne(mappedBy = "company", cascade = {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    private WebsiteEntity websites;

    private CompanyEntity(Builder builder) {
        setUserUUID(builder.userID);
        setName(builder.name);
        setDescription(builder.description);
        setVersion(builder.version);
        setProcessStatus(builder.processStatus);
        setRowStatus(builder.rowStatus);
        setCreatedDate(builder.createdDate);
        setLastModifiedDate(builder.lastModifiedDate);
//        setVerifications(builder.verifications);
//        setEmails(builder.emails);
//        setVerifications(builder.verifications);
//        setWebsites(builder.websites);
//        setProfile(builder.profile);
    }

    public static final class Builder {
        private CompanyID companyID;

        private Long version;

        private ProcessStatus processStatus;

        private RowStatus rowStatus;

        private Timestamp createdDate;

        private Timestamp lastModifiedDate;

        private UUID userID;

        private String name;

        private String description;

        private CompanyProfileEntity profile;

        private List<VerificationEntity> verifications;

        private List<EmailEntity> emails;

        private WebsiteEntity websites;


        private Builder() {
        }

        public static CompanyEntity.Builder builder() {
            return new CompanyEntity.Builder();
        }

        public CompanyEntity.Builder uuid(UUID uuid) {
            this.companyID = CompanyID.of(uuid);
            return this;
        }

        public CompanyEntity.Builder uuid(CompanyID companyID) {
            this.companyID = companyID;
            return this;
        }

        public Builder version(Long val) {
            version = val;
            return this;
        }

        public CompanyEntity.Builder processStatus(ProcessStatus val) {
            processStatus = val;
            return this;
        }

        public CompanyEntity.Builder rowStatus(RowStatus val) {
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

        public CompanyEntity.Builder userId(UUID val) {
            userID = val;
            return this;
        }

        public CompanyEntity.Builder name(String val) {
            name = val;
            return this;
        }

        public Builder description(String val) {
            description = val;
            return this;
        }

        public Builder profile(CompanyProfileEntity val) {
            profile = val;
            return this;
        }

        public Builder verification(List<VerificationEntity> val) {
            verifications = val;
            return this;
        }

        public Builder email(List<EmailEntity> val) {
            emails = val;
            return this;
        }
        public CompanyEntity.Builder website(WebsiteEntity val) {
            websites = val;
            return this;
        }

        public CompanyEntity build() {
            return new CompanyEntity(this);
        }
    }
}
