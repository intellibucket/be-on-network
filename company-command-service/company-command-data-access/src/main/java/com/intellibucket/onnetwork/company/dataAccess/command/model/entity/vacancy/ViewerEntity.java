package com.intellibucket.onnetwork.company.dataAccess.command.model.entity.vacancy;

import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.vacancy.ViewerType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "vacancy", name = "viewers")
@Entity(name = "ViewerEntity")
public class ViewerEntity extends BaseEntity {
    @ManyToOne
    private VacancyEntity vacancy;

    @Column(name = "user_id",nullable = false,updatable = false)
    private UUID userId;

    @Column(name = "viewer_type",nullable = false,updatable = false)
    private ViewerType viewerType;

    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp viewedAt;
}
