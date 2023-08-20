package az.rock.flyjob.js.domain.presentation.handler.concretes;

import az.rock.flyjob.js.domain.core.service.abstracts.AbstractResumeDomainService;
import az.rock.flyjob.js.domain.presentation.handler.abstracts.AbstractResumeCreateCommandHandler;
import az.rock.flyjob.js.domain.presentation.mapper.abstracts.AbstractResumeDomainMapper;
import az.rock.lib.event.AbstractDomainEvent;
import az.rock.lib.event.impl.concretes.FailDomainEvent;
import az.rock.lib.event.impl.concretes.auth.create.JobSeekerCreatedEvent;
import az.rock.lib.event.impl.concretes.js.create.ResumeCreatedEvent;
import az.rock.lib.event.payload.Payload;
import az.rock.lib.event.payload.js.ResumeCreatedPayload;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class ResumeCreateCommandHandler implements AbstractResumeCreateCommandHandler {
    private final AbstractResumeDomainService resumeDomainService;
    private final AbstractResumeDomainMapper resumeDomainMapper;

    public ResumeCreateCommandHandler(AbstractResumeDomainService resumeDomainService,
                                      AbstractResumeDomainMapper resumeDomainMapper) {
        this.resumeDomainService = resumeDomainService;
        this.resumeDomainMapper = resumeDomainMapper;
    }

    @Override
    public AbstractDomainEvent<? extends Payload> createResume(JobSeekerCreatedEvent event){
        var payload = event.payload();
        try {
            var newResumeRoot = this.resumeDomainMapper.createNewResume(payload);
            var resumeCreatedEvent = new ResumeCreatedEvent(
                    ResumeCreatedPayload.of(newResumeRoot.getRootID().getAbsoluteID())
            );
            return resumeCreatedEvent;
        }catch (Exception exception){
         return FailDomainEvent.of(List.of(exception.getMessage()));
        }
    }
}
