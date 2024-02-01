package az.rock.auth.domain.presentation.ports.input.coordinator.starter.concretes;

import az.rock.auth.domain.presentation.ports.input.coordinator.starter.abstracts.AbstractCompanyCreateEventCoordinator;
import az.rock.auth.domain.presentation.ports.output.publisher.AbstractUserMessagePublisher;
import com.intellibucket.lib.payload.event.create.user.CompanyCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CompanyCreateEventCoordinator extends AbstractCompanyCreateEventCoordinator {

    @Value(value = "${topic.cmp.created.start}")
    private String companyCreatedTopicName;


    public CompanyCreateEventCoordinator(AbstractUserMessagePublisher<CompanyCreatedEvent> userMessagePublisher1) {
        super(userMessagePublisher1);
    }

    @Override
    public String getStartTopic() {
        return this.companyCreatedTopicName;
    }

    //TODO: If required it can Implement this method onSuccess and onFail
}
