package com.intellibucket.onnetwork.vacancy.domain.presentation.command.dto.request;

import az.rock.lib.valueObject.Currency;
import az.rock.lib.valueObject.vacancy.Payment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VacancySalaryCommand {
    private Boolean hasSalary;

    private Currency currency;

    private BigDecimal startAmount;

    private BigDecimal endAmount;

    private Boolean isEstimated;

    private Payment payment;
}
