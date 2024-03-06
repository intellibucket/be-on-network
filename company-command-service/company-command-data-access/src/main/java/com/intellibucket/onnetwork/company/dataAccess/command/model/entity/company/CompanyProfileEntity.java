package com.intellibucket.onnetwork.company.dataAccess.command.model.entity.company;

import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@Entity(name = "CompanyProfileEntity")
@Table(schema = "company", name = "profiles")
@AllArgsConstructor
public class CompanyProfileEntity extends BaseEntity {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_uuid")
    private CompanyEntity company;

    @Column(name = "is_hiring", nullable = false)
    private Boolean isHiring;

    private CompanyProfileEntity(Builder builder) {
        setCompany(builder.company);
        setIsHiring(builder.isHiring);
        setUuid(builder.uuid);
        setVersion(builder.version);
        setProcessStatus(builder.processStatus);
        setRowStatus(builder.rowStatus);
        setCreatedDate(builder.createdDate);
        setLastModifiedDate(builder.lastModifiedDate);
    }


    public static final class Builder {
        private CompanyEntity company;
        private Boolean isHiring;
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

        public Builder isHiring(Boolean val) {
            isHiring = val;
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

        public CompanyProfileEntity build() {
            return new CompanyProfileEntity(this);
        }
    }
}
