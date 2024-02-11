package az.rock.flyjob.js.domain.presentation.ports.input.coordinator.abstracts;

import az.rock.lib.coordinator.AbstractEventResponseCoordinator;
import com.intellibucket.lib.payload.event.create.user.JobSeekerCreatedEvent;
import com.intellibucket.lib.payload.payload.reg.JobSeekerRegistrationPayload;

public abstract class AbstractJobSeekerCreatedResponseEventCoordinator extends AbstractEventResponseCoordinator<JobSeekerRegistrationPayload, JobSeekerCreatedEvent> {

}
