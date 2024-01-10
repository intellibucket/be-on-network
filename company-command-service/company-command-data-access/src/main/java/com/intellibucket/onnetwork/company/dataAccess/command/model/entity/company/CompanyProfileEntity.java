package com.intellibucket.onnetwork.company.dataAccess.command.model.entity.company;

import az.rock.lib.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@Entity(name = "CompanyProfileEntity")
@Table(schema = "company", name = "profiles")
@AllArgsConstructor
public class CompanyProfileEntity extends BaseEntity {

    @OneToOne(fetch = FetchType.LAZY)
    private CompanyEntity company;

    @Column(name = "is_hiring", nullable = false)
    private Boolean isHiring;
}
