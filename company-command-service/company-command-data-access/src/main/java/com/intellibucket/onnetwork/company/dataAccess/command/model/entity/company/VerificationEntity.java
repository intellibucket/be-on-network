package com.intellibucket.onnetwork.company.dataAccess.command.model.entity.company;

import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.vacancy.CompanyVerificationType;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "VerificationEntity")
@Table(schema = "company", name = "verifications")
public class VerificationEntity extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    private CompanyEntity company;

    @Column(name = "is_verified", nullable = false, columnDefinition = "boolean default false")
    private Boolean isVerified;

    @Column(name = "verification_type", nullable = false)
    private CompanyVerificationType verificationType;

    @Column(name = "verification_request_date")
    private Timestamp verificationRequestDate;

    @Column(name = "verification_response_date")
    private Timestamp verificationResponseDate;

    private VerificationEntity(Builder builder) {
        setCompany(builder.company);
        setIsVerified(builder.isVerified);
        setVerificationType(builder.verificationType);
        setVerificationRequestDate(builder.verificationRequestDate);
        setVerificationResponseDate(builder.verificationResponseDate);
        setUuid(builder.uuid);
        setVersion(builder.version);
        setProcessStatus(builder.processStatus);
        setRowStatus(builder.rowStatus);
        setCreatedDate(builder.createdDate);
        setLastModifiedDate(builder.lastModifiedDate);
    }


    public static final class Builder {
        private CompanyEntity company;
        private Boolean isVerified;
        private CompanyVerificationType verificationType;
        private Timestamp verificationRequestDate;
        private Timestamp verificationResponseDate;
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

        public Builder company(CompanyEntity val) {
            company = val;
            return this;
        }

        public Builder isVerified(Boolean val) {
            isVerified = val;
            return this;
        }

        public Builder verificationType(CompanyVerificationType val) {
            verificationType = val;
            return this;
        }

        public Builder verificationRequestDate(Timestamp val) {
            verificationRequestDate = val;
            return this;
        }

        public Builder verificationResponseDate(Timestamp val) {
            verificationResponseDate = val;
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

        public VerificationEntity build() {
            return new VerificationEntity(this);
        }
    }



}
