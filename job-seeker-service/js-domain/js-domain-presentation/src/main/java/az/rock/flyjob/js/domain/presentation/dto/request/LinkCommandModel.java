package az.rock.flyjob.js.domain.presentation.dto.request;

import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.AbstractCommandModel;
import az.rock.lib.valueObject.js.LinkType;

public class LinkCommandModel extends AbstractCommandModel {
    private LinkType type;
    private String explanation;
    private String link;
}
