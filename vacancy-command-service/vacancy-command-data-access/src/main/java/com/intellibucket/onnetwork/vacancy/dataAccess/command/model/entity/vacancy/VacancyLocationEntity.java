package com.intellibucket.onnetwork.vacancy.dataAccess.command.model.entity.vacancy;

import az.rock.lib.domain.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "vacancy", name = "vacancy_locations")
@Entity(name = "VacancyLocationEntity")
public class VacancyLocationEntity extends BaseEntity {
    @OneToOne
    private VacancyEntity vacancy;

    @Column(name = "country_id",nullable = false)
    private UUID countryId;

    @Column(name = "city_id",nullable = false)
    private UUID cityId;
}
