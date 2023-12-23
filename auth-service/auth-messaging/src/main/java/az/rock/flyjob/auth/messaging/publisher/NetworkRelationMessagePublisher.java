package az.rock.flyjob.auth.messaging.publisher;

import az.rock.auth.domain.presentation.ports.output.publisher.AbstractNetworkRelationMessagePublisher;
import az.rock.flyjob.auth.model.root.network.NetworkRelationRoot;
import com.intellibucket.lib.payload.event.abstracts.AbstractDomainEvent;
import com.intellibucket.lib.payload.trx.SagaProcess;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class NetworkRelationMessagePublisher implements AbstractNetworkRelationMessagePublisher {
    @Override
    public void publish(SagaProcess<AbstractDomainEvent<NetworkRelationRoot>> sagaProcess) {
        log.info("NetworkRelationMessagePublisher.publish");
    }
}
