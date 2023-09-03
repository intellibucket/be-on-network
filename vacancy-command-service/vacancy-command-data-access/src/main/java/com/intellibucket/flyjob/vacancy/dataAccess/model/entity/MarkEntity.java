package com.intellibucket.flyjob.vacancy.dataAccess.model.entity;

import az.rock.lib.domain.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(schema = "vacancy", name = "marks")
@Entity(name = "MarkEntity")
public class MarkEntity extends BaseEntity {
    @Column(name = "user_id",nullable = false,updatable = false)
    private UUID userId;

    @Column(name = "vacancy_id",nullable = false,updatable = false)
    private UUID vacancyId;

}
