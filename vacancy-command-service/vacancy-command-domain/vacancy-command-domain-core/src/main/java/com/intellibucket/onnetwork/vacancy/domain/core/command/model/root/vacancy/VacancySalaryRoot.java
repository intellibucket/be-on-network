package com.intellibucket.onnetwork.vacancy.domain.core.command.model.root.vacancy;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.vacancy.VacancyID;
import az.rock.lib.domain.id.vacancy.VacancySalaryID;
import az.rock.lib.valueObject.Currency;
import az.rock.lib.valueObject.vacancy.Payment;

import java.math.BigDecimal;

public class VacancySalaryRoot extends AggregateRoot<VacancySalaryID> {
    private VacancyID vacancy;

    private Boolean hasSalary;

    private Currency currency;

    private BigDecimal startAmount;

    private BigDecimal endAmount;

    private Boolean isEstimated;

    private Payment payment;
}
