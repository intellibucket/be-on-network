package com.intellibucket.onnetwork.vacancy.domain.core.command.model.root.vacancy;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.auth.UserID;
import az.rock.lib.domain.id.vacancy.AppliedUserID;
import az.rock.lib.domain.id.vacancy.VacancyID;
import az.rock.lib.valueObject.vacancy.AppliedStatus;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;

import java.util.UUID;

public class AppliedUserRoot extends AggregateRoot<AppliedUserID> {

    private VacancyID vacancy;

    private UserID jobSeekerId;

    private AppliedStatus appliedStatus;

}
