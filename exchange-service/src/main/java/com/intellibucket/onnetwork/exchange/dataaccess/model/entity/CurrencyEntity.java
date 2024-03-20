package com.intellibucket.onnetwork.exchange.dataaccess.model.entity;

import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.CurrencyCode;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;

import java.util.Objects;

@Entity(name = "CurrencyEntity")
@Table(name = "currency", schema = "exchange", indexes = {
        @Index(name = "currency_code_index", columnList = "code", unique = true)
})
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class CurrencyEntity extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @NotNull
    private CurrencyCode code;

    @Column(name = "symbol", nullable = false)
    private String symbol;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "symbol_native", nullable = false)
    private String symbolNative;
    @Column(name = "decimal_digits", nullable = false)
    private String decimalDigits;
    @Column(name = "rounding", nullable = false)
    private String rounding;
    @Column(name = "name_plural", nullable = false)
    private String namePlural;
    @Column(name = "type", nullable = false)
    private String type;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CurrencyEntity that = (CurrencyEntity) o;
        return getUuid() != null && Objects.equals(getUuid(), that.getUuid());
    }

}
