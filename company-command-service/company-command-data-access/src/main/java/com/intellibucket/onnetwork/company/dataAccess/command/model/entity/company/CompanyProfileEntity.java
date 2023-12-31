package com.intellibucket.onnetwork.company.dataAccess.command.model.entity.company;

import az.rock.lib.domain.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@Entity(name = "CompanyProfileEntity")
@Table(schema = "company", name = "profiles")
@AllArgsConstructor
public class CompanyProfileEntity extends BaseEntity {

    @OneToOne
    private CompanyEntity company;

    @Column(name = "is_hiring", nullable = false)
    private Boolean isHiring;
}
