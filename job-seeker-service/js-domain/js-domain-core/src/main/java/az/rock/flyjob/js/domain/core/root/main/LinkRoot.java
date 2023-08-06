package az.rock.flyjob.js.domain.core.root.main;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.js.LinkID;
import az.rock.lib.valueObject.js.LinkType;

public class LinkRoot extends AggregateRoot<LinkID> {
    private LinkID information;

    private LinkType type;

    private String explanation;

    private String link;
}
