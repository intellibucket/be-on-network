package com.intellibucket.onnetwork.company.dataAccess.command.model.entity.company;

import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "EmailEntity")
@Table(schema = "company", name = "emails")
public class EmailEntity extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    private CompanyEntity company;

    @Column(name = "access_modifier", nullable = false)
    private AccessModifier accessModifier;

    @Email
    @Column(name = "email", nullable = false, updatable = false)
    private String email;

    @Column(name = "is_primary", nullable = false)
    private Boolean isPrimary;

    @Column(name = "is_verified", nullable = false)
    private Boolean isVerified;

    @Column(name = "verification_code", nullable = false)
    private String verificationCode;

    @Column(name = "verification_request_date", nullable = false)
    private Timestamp verificationRequestDate;

    @Column(name = "verification_response_date", nullable = false)
    private Timestamp verificationResponseDate;

    private EmailEntity(Builder builder) {
        setCompany(builder.company);
        setAccessModifier(builder.accessModifier);
        setEmail(builder.email);
        setIsPrimary(builder.isPrimary);
        setIsVerified(builder.isVerified);
        setVerificationCode(builder.verificationCode);
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
        private AccessModifier accessModifier;
        private @Email String email;
        private Boolean isPrimary;
        private Boolean isVerified;
        private String verificationCode;
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

        public Builder accessModifier(AccessModifier val) {
            accessModifier = val;
            return this;
        }

        public Builder email(@Email String val) {
            email = val;
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

        public EmailEntity build() {
            return new EmailEntity(this);
        }
    }
}
