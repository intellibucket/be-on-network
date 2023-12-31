package com.intellibucket.onnetwork.company.dataAccess.command.model.entity.company;

import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.AccessModifier;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "EmailEntity")
@Table(schema = "company", name = "emails")
public class EmailEntity extends BaseEntity {
    @ManyToOne
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

}
