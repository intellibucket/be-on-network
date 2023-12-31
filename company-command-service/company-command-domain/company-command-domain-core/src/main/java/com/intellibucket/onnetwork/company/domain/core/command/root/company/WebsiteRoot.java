package com.intellibucket.onnetwork.company.domain.core.command.root.company;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.company.CompanyID;
import az.rock.lib.domain.id.company.WebsiteID;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;

@Getter
@Builder
public class WebsiteRoot extends AggregateRoot<WebsiteID> {
    private CompanyID companyID;

    private String website;

    private Boolean isVerified;

    private ZonedDateTime verificationRequestDate;

    private ZonedDateTime verificationResponseDate;
}
