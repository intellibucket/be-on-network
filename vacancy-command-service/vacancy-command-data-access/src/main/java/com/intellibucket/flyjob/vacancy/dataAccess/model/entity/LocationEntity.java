package com.intellibucket.flyjob.vacancy.dataAccess.model.entity;

import az.rock.lib.domain.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "vacancy", name = "locations")
@Entity(name = "LocationEntity")
public class LocationEntity extends BaseEntity {
}
