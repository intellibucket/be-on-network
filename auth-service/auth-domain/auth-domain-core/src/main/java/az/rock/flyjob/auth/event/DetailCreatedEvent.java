package az.rock.flyjob.auth.event;

import az.rock.flyjob.auth.model.root.detail.DetailRoot;
import com.intellibucket.lib.payload.event.abstracts.AbstractDomainEvent;

public class DetailCreatedEvent  extends AbstractDomainEvent<DetailRoot> {
    protected DetailCreatedEvent(DetailRoot root) {
        super(root);
    }

    public static DetailCreatedEvent of(DetailRoot root) {
        return new DetailCreatedEvent(root);
    }
}
