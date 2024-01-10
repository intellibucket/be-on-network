package com.intellibucket.onnetwork.company.dataAccess.command.model.entity.company;


import az.rock.lib.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "WebsiteEntity")
@Table(schema = "company", name = "websites")
public class WebsiteEntity extends BaseEntity {
    @OneToOne(fetch = FetchType.LAZY)
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
