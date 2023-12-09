package com.intellibucket.onnetwork.vacancy.domain.core.command.model.root.vacancy;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.RootID;
import az.rock.lib.domain.id.auth.UserID;
import az.rock.lib.domain.id.vacancy.VacancyID;
import az.rock.lib.domain.id.vacancy.ViewerID;
import az.rock.lib.valueObject.vacancy.ViewerType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;

import java.util.UUID;

public class ViewerRoot extends AggregateRoot<ViewerID> {
    private VacancyID vacancy;

    private UserID userId;

    private ViewerType viewerType;
}
