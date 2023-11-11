package az.rock.auth.domain.presentation.handler.abstracts;

import az.rock.flyjob.auth.event.DetailCreatedEvent;
import az.rock.flyjob.auth.model.root.user.UserRoot;

public interface AbstractDetailCreateCommandHandler extends AbstractCommandHandler<DetailCreatedEvent, UserRoot> {

}
