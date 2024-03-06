package com.intellibucket.onnetwork.company.domain.core.command.root.vacancy;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.auth.UserID;
import az.rock.lib.domain.id.vacancy.AppliedUserID;
import az.rock.lib.domain.id.vacancy.VacancyID;
import az.rock.lib.valueObject.vacancy.AppliedStatus;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AppliedUserRoot extends AggregateRoot<AppliedUserID> {

    private VacancyID vacancy;

    private UserID jobSeekerId;

    private AppliedStatus appliedStatus;

}
