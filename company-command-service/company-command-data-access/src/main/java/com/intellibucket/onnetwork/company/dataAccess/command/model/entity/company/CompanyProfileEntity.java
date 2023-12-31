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

@Getter
@Setter
@Builder
@NoArgsConstructor
@Entity(name = "CompanyProfileEntity")
@Table(schema = "company", name = "profiles")
public class CompanyProfileEntity extends BaseEntity {

    @OneToOne
    private CompanyEntity company;

    @Column(name = "is_hiring", nullable = false)
    private Boolean isHiring;
}
