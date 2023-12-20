package com.intellibucket.onnetwork.vacancy.domain.presentation.command.dto.request;

import az.rock.lib.valueObject.vacancy.VacancySkillType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VacancySkillCommand {
    private VacancySkillType skillType;

    private String skill;
}
