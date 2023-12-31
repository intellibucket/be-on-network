package com.intellibucket.onnetwork.company.dataAccess.command.model.entity.company;

import az.rock.lib.domain.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@Entity(name = "CompanyEntity")
@Table(schema = "company", name = "companies")
@AllArgsConstructor
public class CompanyEntity extends BaseEntity {

    @Column(name = "company_id", nullable = false, updatable = false)
    private UUID companyID;

    @Column(name = "name")
    @Max(100)
    private String name;

    @Column(name = "description")
    @Max(2000)
    private String description;

    @OneToOne(mappedBy = "company")
    private CompanyProfileEntity profile;

    @OneToMany(mappedBy = "company")
    private List<VerificationEntity> verifications;

    @OneToMany(mappedBy = "company")
    private List<EmailEntity> emails;

    @OneToOne(mappedBy = "company")
    private WebsiteEntity websites;

}
