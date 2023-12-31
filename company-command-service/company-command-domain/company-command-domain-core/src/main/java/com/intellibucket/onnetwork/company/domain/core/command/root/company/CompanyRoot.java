package com.intellibucket.onnetwork.company.domain.core.command.root.company;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.auth.UserID;
import az.rock.lib.domain.id.company.CompanyID;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class CompanyRoot extends AggregateRoot<CompanyID> {
    private UserID userID;

    private String name;

    private String description;

    private CompanyProfileRoot profile;

    private List<VerificationRoot> verifications;

    private List<EmailRoot> emails;

    private WebsiteRoot websites;
}
