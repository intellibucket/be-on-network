package com.intellibucket.onnetwork.company.domain.core.command.root.company;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.company.CompanyID;
import az.rock.lib.domain.id.company.CompanyProfileID;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CompanyProfileRoot extends AggregateRoot<CompanyProfileID> {
    private CompanyID companyID;

    private Boolean isHiring;
}
