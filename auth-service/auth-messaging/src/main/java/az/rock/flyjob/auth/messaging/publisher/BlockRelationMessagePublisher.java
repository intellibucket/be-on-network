package az.rock.flyjob.auth.messaging.publisher;

import az.rock.auth.domain.presentation.ports.output.publisher.AbstractBlockRelationMessagePublisher;
import az.rock.flyjob.auth.model.root.network.BlockRelationRoot;
import com.intellibucket.lib.payload.event.abstracts.AbstractDomainEvent;
import com.intellibucket.lib.payload.trx.Saga;
import org.springframework.stereotype.Component;

@Component
public class BlockRelationMessagePublisher implements AbstractBlockRelationMessagePublisher {
    @Override
    public void publish(Saga<AbstractDomainEvent<BlockRelationRoot>> saga) {

    }
}
