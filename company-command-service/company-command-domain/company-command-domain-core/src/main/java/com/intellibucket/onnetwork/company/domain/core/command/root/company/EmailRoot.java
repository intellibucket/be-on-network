package com.intellibucket.onnetwork.company.domain.core.command.root.company;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.auth.EmailID;
import az.rock.lib.domain.id.company.CompanyID;
import az.rock.lib.valueObject.AccessModifier;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;

@Getter
@Builder
public class EmailRoot extends AggregateRoot<EmailID> {
    private CompanyID companyID;

    private AccessModifier accessModifier;

    private String email;

    private Boolean isPrimary;

    private Boolean isVerified;

    private String verificationCode;

    private ZonedDateTime verificationRequestDate;

    private ZonedDateTime verificationResponseDate;
}
