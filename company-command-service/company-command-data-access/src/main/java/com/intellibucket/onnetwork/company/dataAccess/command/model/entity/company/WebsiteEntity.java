package com.intellibucket.onnetwork.company.dataAccess.command.model.entity.company;


import az.rock.lib.domain.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
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
@Entity(name = "WebsiteEntity")
@Table(schema = "company", name = "websites")
public class WebsiteEntity extends BaseEntity {
    @OneToOne
    private CompanyEntity company;

    @Column(name = "website", nullable = false, updatable = false)
    private String website;

    @Column(name = "is_verified", nullable = false)
    private Boolean isVerified;

    @Column(name = "verification_request_date", nullable = false)
    private Timestamp verificationRequestDate;

    @Column(name = "verification_response_date", nullable = false)
    private Timestamp verificationResponseDate;

}
