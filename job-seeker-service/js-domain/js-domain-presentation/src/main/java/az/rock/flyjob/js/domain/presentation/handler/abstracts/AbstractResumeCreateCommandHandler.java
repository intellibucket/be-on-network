package az.rock.flyjob.js.domain.presentation.handler.abstracts;

import com.intellibukcet.lib.payload.event.abstracts.AbstractDomainEvent;
import com.intellibukcet.lib.payload.event.create.user.JobSeekerCreatedEvent;
import com.intellibukcet.lib.payload.trx.Saga;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRES_NEW)
public interface AbstractResumeCreateCommandHandler {
    AbstractDomainEvent<?> createResume(JobSeekerCreatedEvent event);
}
