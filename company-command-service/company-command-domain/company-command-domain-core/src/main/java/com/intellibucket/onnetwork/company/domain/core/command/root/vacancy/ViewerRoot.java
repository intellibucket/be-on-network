package com.intellibucket.onnetwork.company.domain.core.command.root.vacancy;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.auth.UserID;
import az.rock.lib.domain.id.vacancy.VacancyID;
import az.rock.lib.domain.id.vacancy.ViewerID;
import az.rock.lib.valueObject.vacancy.ViewerType;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.ZonedDateTime;

@Getter
@Builder
public class ViewerRoot extends AggregateRoot<ViewerID> {
    private VacancyID vacancy;

    private UserID userId;

    private ViewerType viewerType;

    private ZonedDateTime viewedAt;
}
