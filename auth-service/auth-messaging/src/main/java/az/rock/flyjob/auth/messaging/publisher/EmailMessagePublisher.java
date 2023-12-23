package az.rock.flyjob.auth.messaging.publisher;

import az.rock.auth.domain.presentation.ports.output.publisher.AbstractEmailMessagePublisher;
import az.rock.flyjob.auth.model.root.user.EmailRoot;
import az.rock.lib.valueObject.SagaRoot;
import com.intellibucket.lib.payload.event.abstracts.AbstractDomainEvent;
import com.intellibucket.lib.payload.trx.SagaProcess;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class EmailMessagePublisher implements AbstractEmailMessagePublisher {
    private final KafkaTemplate<String, SagaRoot<AbstractDomainEvent<EmailRoot>>> kafkaTemplate;

    public EmailMessagePublisher(KafkaTemplate<String, SagaRoot<AbstractDomainEvent<EmailRoot>>> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void publish(SagaProcess<AbstractDomainEvent<EmailRoot>> sagaProcessRoot) {
//        var event = sagaRoot.getData();
//        if (event instanceof EmailCreatedEvent emailCreatedEvent) this.publishCreatedEvent(sagaRoot);
//        else if (event instanceof EmailUpdatedEvent emailUpdatedEvent) this.publishUpdatedEvent(sagaRoot);
    }

    private void publishCreatedEvent(SagaRoot<AbstractDomainEvent<EmailRoot>> sagaRoot) {
        kafkaTemplate.send("auth.email.created", sagaRoot);
    }

    private void publishUpdatedEvent(SagaRoot<AbstractDomainEvent<EmailRoot>> sagaRoot) {
        kafkaTemplate.send("auth.email.updated", sagaRoot);
    }

}
