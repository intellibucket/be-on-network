package az.rock.flyjob.js.domain.presentation.dto.request.item;

import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.AbstractCommandModel;
import az.rock.lib.valueObject.LanguageLevel;

import java.util.UUID;

public class ResumeLanguageCommandModel extends AbstractCommandModel {
    private UUID languageUUID;

    private String additionalInfo;

    private LanguageLevel level;
}
