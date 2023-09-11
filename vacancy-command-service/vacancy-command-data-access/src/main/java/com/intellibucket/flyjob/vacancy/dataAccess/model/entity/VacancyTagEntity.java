package com.intellibucket.flyjob.vacancy.dataAccess.model.entity;

import az.rock.lib.domain.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "vacancy", name = "tags")
@Entity(name = "VacancyTagEntity")
public class VacancyTagEntity extends BaseEntity {

    @ManyToOne
    private VacancyEntity vacancy;

    @Column(name = "tag",nullable = false,updatable = false)
    private String tag;

}
