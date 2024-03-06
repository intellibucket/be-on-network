package com.intellibucket.onnetwork.company.domain.core.command.root.replica;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.replica.CityID;
import az.rock.lib.domain.id.replica.CountryID;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
@Getter
@Builder
public class CityRoot extends AggregateRoot<CityID> {
    private CountryID country;

    private String name;

    private BigDecimal latitude;

    private BigDecimal longitude;

    private String timezone;

    private String timezoneOffset;
}
