package az.rock.flyjob.auth.messaging;

import az.rock.auth.domain.presentation.ports.output.message.AbstractUserMessagePublisher;
import az.rock.flyjob.auth.event.CompanyCreatedEvent;
import az.rock.flyjob.auth.event.UserCreatedEvent;
import az.rock.lib.domain.id.UserID;
import model.auth.UserCreatedKafkaModel;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserMessagePublisher implements AbstractUserMessagePublisher {
    private final KafkaTemplate<String, UserCreatedKafkaModel> userCreatedEventKafkaTemplate;

    private final KafkaTemplate<String, UserCreatedKafkaModel> companyCreatedEventKafkaTemplate;

    public UserMessagePublisher(KafkaTemplate<String, UserCreatedKafkaModel> userCreatedEventKafkaTemplate,
                                KafkaTemplate<String, UserCreatedKafkaModel> companyCreatedEventKafkaTemplate) {
        this.userCreatedEventKafkaTemplate = userCreatedEventKafkaTemplate;
        this.companyCreatedEventKafkaTemplate = companyCreatedEventKafkaTemplate;
    }

    @Override
    public void publish(UserCreatedEvent userCreatedEvent) {
        var root = userCreatedEvent.getRoot();
        var model = UserCreatedKafkaModel.of(root.getUUID().getAbsoluteID(), root.getUserType());
        this.userCreatedEventKafkaTemplate.send("user-created", model);
    }

    @Override
    public void publish(CompanyCreatedEvent companyCreatedEvent) {
        var root = companyCreatedEvent.getRoot();
        var model = UserCreatedKafkaModel.of(root.getUUID().getAbsoluteID(), root.getUserType());
        this.userCreatedEventKafkaTemplate.send("user-created", model);
    }
}
