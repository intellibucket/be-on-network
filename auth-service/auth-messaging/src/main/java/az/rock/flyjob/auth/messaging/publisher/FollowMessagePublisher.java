package az.rock.flyjob.auth.messaging.publisher;

import az.rock.auth.domain.presentation.ports.output.publisher.AbstractFollowMessagePublisher;
import az.rock.flyjob.auth.root.network.FollowRelationRoot;
import az.rock.lib.event.AbstractDomainEvent;
import az.rock.lib.valueObject.SagaRoot;
import org.springframework.stereotype.Component;

@Component
public class FollowMessagePublisher implements AbstractFollowMessagePublisher {
    @Override
    public void publish(SagaRoot<AbstractDomainEvent<FollowRelationRoot>> sagaRoot) {

    }
}
