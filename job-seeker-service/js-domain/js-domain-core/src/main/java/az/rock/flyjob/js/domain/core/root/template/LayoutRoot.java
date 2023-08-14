package az.rock.flyjob.js.domain.core.root.template;


import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.js.LayoutID;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.js.LayoutColumnAlignmentType;
import az.rock.lib.valueObject.js.LayoutType;

public class LayoutRoot extends AggregateRoot<LayoutID> {
    private LayoutType layoutType;
    private LayoutColumnAlignmentType layoutColumnAlignmentType;
}
