package az.rock.flyjob.js.messaging.publishers.concretes;

import az.rock.flyjob.js.domain.presentation.ports.output.publisher.AbstractJobSeekerResponseMessagePublisher;
import com.intellibucket.lib.payload.trx.AbstractSagaProcess;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class JobSeekerResponseMessagePublisher implements AbstractJobSeekerResponseMessagePublisher {

    @Override
    public void publish(String s, AbstractSagaProcess<?> abstractSagaProcess) {

    }
}
