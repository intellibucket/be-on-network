package az.rock.flyjob.js.domain.presentation.dto.request.item;

import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.AbstractCommandModel;
import az.rock.lib.valueObject.js.SkillLevel;

public class SkillCommandModel extends AbstractCommandModel {
    private String skillName;
    private SkillLevel skillLevel;
    private String information;
}
