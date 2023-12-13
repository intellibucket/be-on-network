package com.intellibucket.onnetwork.vacancy.domain.core.command.model.root.replica;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.replica.CountryID;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Builder
@SuperBuilder
public class CountryRoot extends AggregateRoot<CountryID> {
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

    private List<CityRoot> cities;
}
