package com.intellibucket.onnetwork.vacancy.dataAccess.command.model.entity.replica;

import az.rock.lib.domain.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "replica", name = "cities")
@Entity(name = "CityEntity")
public class CityEntity extends BaseEntity {
    @ManyToOne
    private CountryEntity country;

    private String name;

    private BigDecimal latitude;

    private BigDecimal longitude;

    private String timezone;

    private String timezoneOffset;

}
