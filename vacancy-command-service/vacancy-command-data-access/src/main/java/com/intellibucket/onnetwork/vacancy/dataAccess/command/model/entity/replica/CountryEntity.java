package com.intellibucket.onnetwork.vacancy.dataAccess.command.model.entity.replica;

import az.rock.lib.domain.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "replica", name = "countries")
@Entity(name = "CountryEntity")
public class CountryEntity extends BaseEntity {

    private String name;

    private String code;

    private String phoneCode;

    private String currency;

    private String currencyCode;

    private String currencySymbol;

    private byte[] flag;

    private String flagUrl;

    private String timezone;

    private String timezoneOffset;

    private BigDecimal latitude;

    private BigDecimal longitude;

    @OneToMany(mappedBy = "country")
    private List<CityEntity> cities;

}
