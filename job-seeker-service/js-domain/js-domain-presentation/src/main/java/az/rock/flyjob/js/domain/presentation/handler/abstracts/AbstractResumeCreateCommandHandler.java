package az.rock.flyjob.js.domain.presentation.handler.abstracts;

import com.intellibucket.lib.payload.event.abstracts.AbstractDomainEvent;
import com.intellibucket.lib.payload.event.create.user.JobSeekerCreatedEvent;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRES_NEW)
public interface AbstractResumeCreateCommandHandler {
    AbstractDomainEvent<?> createResume(JobSeekerCreatedEvent event);
}
