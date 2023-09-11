package com.intellibucket.flyjob.vacancy.dataAccess.model.entity;

import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.Currency;
import az.rock.lib.valueObject.vacancy.PayingType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "vacancy", name = "salaries")
@Entity(name = "SalaryEntity")
public class SalaryEntity extends BaseEntity {
    @OneToOne
    private VacancyEntity vacancy;

    @Column(name = "has_salary")
    private Boolean hasSalary;

    @Column(name = "currency")
    private Currency currency;

    @Column(name = "start_amount")
    private BigDecimal startAmount;

    @Column(name = "end_amount")
    private BigDecimal endAmount;

    @Column(name = "is_estimated")
    private Boolean isEstimated;

    @Enumerated(EnumType.STRING)
    private PayingType payingType;
}
