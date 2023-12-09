package com.intellibucket.onnetwork.vacancy.dataAccess.command.model.entity.vacancy;

import az.rock.lib.domain.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
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
@Table(schema = "vacancy", name = "vacancy_saved_users")
@Entity(name = "VacancySaveUserEntity")
public class VacancySaveUserEntity extends BaseEntity {

    @ManyToOne
    private VacancyEntity vacancy;

    @Column(name = "user_id",nullable = false,updatable = false)
    private UUID userId;

}
