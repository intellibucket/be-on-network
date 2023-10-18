package az.rock.flyjob.auth.messaging.publisher;

import az.rock.auth.domain.presentation.ports.output.publisher.AbstractNetworkRelationMessagePublisher;
import az.rock.flyjob.auth.root.network.NetworkRelationRoot;
import com.intellibukcet.lib.payload.event.abstracts.AbstractDomainEvent;
import com.intellibukcet.lib.payload.trx.Saga;
import org.springframework.stereotype.Component;

@Component
public class NetworkRelationMessagePublisher implements AbstractNetworkRelationMessagePublisher {
    @Override
    public void publish(Saga<AbstractDomainEvent<NetworkRelationRoot>> saga) {

    }
}
