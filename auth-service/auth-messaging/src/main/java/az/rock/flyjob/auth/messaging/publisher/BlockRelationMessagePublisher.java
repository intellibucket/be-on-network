package az.rock.flyjob.auth.messaging.publisher;

import az.rock.auth.domain.presentation.ports.output.publisher.AbstractBlockRelationMessagePublisher;
import az.rock.flyjob.auth.root.network.BlockRelationRoot;
import com.intellibukcet.lib.payload.event.abstracts.AbstractDomainEvent;
import com.intellibukcet.lib.payload.trx.Saga;
import org.springframework.stereotype.Component;

@Component
public class BlockRelationMessagePublisher implements AbstractBlockRelationMessagePublisher {
    @Override
    public void publish(Saga<AbstractDomainEvent<BlockRelationRoot>> saga) {

    }
}
