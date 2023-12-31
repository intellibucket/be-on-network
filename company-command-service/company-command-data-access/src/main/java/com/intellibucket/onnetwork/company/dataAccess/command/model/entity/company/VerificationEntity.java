package com.intellibucket.onnetwork.company.dataAccess.command.model.entity.company;

import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.vacancy.CompanyVerificationType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Builder
@NoArgsConstructor
@Entity(name = "VerificationEntity")
@Table(schema = "company", name = "verifications")
public class VerificationEntity extends BaseEntity {
    @ManyToOne
    private CompanyEntity company;

    @Column(name = "is_verified", nullable = false, columnDefinition = "boolean default false")
    private Boolean isVerified;

    @Column(name = "verification_type", nullable = false)
    private CompanyVerificationType verificationType;

    @Column(name = "verification_request_date")
    private Timestamp verificationRequestDate;

    @Column(name = "verification_response_date")
    private Timestamp verificationResponseDate;
}
