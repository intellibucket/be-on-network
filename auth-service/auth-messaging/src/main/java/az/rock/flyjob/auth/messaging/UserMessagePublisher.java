package az.rock.flyjob.auth.messaging;

import az.rock.auth.domain.presentation.ports.output.message.AbstractUserMessagePublisher;
import az.rock.flyjob.auth.event.CompanyCreatedEvent;
import az.rock.flyjob.auth.event.UserCreatedEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserMessagePublisher implements AbstractUserMessagePublisher {
    private final KafkaTemplate<String, UserCreatedEvent> userCreatedEventKafkaTemplate;

    private final KafkaTemplate<String, CompanyCreatedEvent> companyCreatedEventKafkaTemplate;

    public UserMessagePublisher(KafkaTemplate<String, UserCreatedEvent> userCreatedEventKafkaTemplate,
                                KafkaTemplate<String, CompanyCreatedEvent> companyCreatedEventKafkaTemplate) {
        this.userCreatedEventKafkaTemplate = userCreatedEventKafkaTemplate;
        this.companyCreatedEventKafkaTemplate = companyCreatedEventKafkaTemplate;
    }

    @Override
    public void publish(UserCreatedEvent userCreatedEvent) {
        this.userCreatedEventKafkaTemplate.send("user-created", userCreatedEvent);
    }

    @Override
    public void publish(CompanyCreatedEvent companyCreatedEvent) {
        this.companyCreatedEventKafkaTemplate.send("company-created", companyCreatedEvent);
    }
}
