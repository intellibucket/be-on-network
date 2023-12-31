package com.intellibucket.onnetwork.company.domain.core.command.root.company;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.company.CompanyID;
import az.rock.lib.domain.id.company.VerificationID;
import az.rock.lib.valueObject.vacancy.CompanyVerificationType;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;

@Getter
@Builder
public class VerificationRoot extends AggregateRoot<VerificationID> {
    private CompanyID companyID;

    private Boolean isVerified;

    private CompanyVerificationType verificationType;

    private ZonedDateTime verificationRequestDate;

    private ZonedDateTime verificationResponseDate;
}
