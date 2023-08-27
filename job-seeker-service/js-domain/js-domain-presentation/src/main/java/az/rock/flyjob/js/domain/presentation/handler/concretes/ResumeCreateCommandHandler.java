package az.rock.flyjob.js.domain.presentation.handler.concretes;

import az.rock.flyjob.js.domain.presentation.handler.abstracts.AbstractResumeCreateCommandHandler;
import az.rock.flyjob.js.domain.presentation.mapper.abstracts.AbstractResumeDomainMapper;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.command.AbstractResumeCommandRepositoryAdapter;
import com.intellibukcet.lib.payload.event.abstracts.AbstractDomainEvent;
import com.intellibukcet.lib.payload.event.concretes.FailDomainEvent;
import com.intellibukcet.lib.payload.event.create.ResumeCreatedEvent;
import com.intellibukcet.lib.payload.event.create.user.JobSeekerCreatedEvent;
import com.intellibukcet.lib.payload.payload.Payload;
import com.intellibukcet.lib.payload.payload.ResumeCreatedPayload;
import org.springframework.stereotype.Component;

@Component
public class ResumeCreateCommandHandler implements AbstractResumeCreateCommandHandler {
    private final AbstractResumeDomainMapper resumeDomainMapper;
    private final AbstractResumeCommandRepositoryAdapter resumeCommandRepositoryAdapter;

    public ResumeCreateCommandHandler(AbstractResumeDomainMapper resumeDomainMapper,
                                      AbstractResumeCommandRepositoryAdapter resumeCommandRepositoryAdapter) {
        this.resumeDomainMapper = resumeDomainMapper;
        this.resumeCommandRepositoryAdapter = resumeCommandRepositoryAdapter;
    }

    @Override
    @SuppressWarnings("all")
    public AbstractDomainEvent<? extends Payload> createResume(JobSeekerCreatedEvent event){
        var payload = event.getPayload();
        try {
            var newResumeRoot = this.resumeDomainMapper.createNewResume(payload);
            var optionalResumeRoot = this.resumeCommandRepositoryAdapter.create(newResumeRoot);
            if (optionalResumeRoot.isPresent()){
                return ResumeCreatedEvent.of(
                        ResumeCreatedPayload.of(
                                optionalResumeRoot
                                        .get()
                                        .getRootID()
                                        .getAbsoluteID()
                        )
                );
            }else return FailDomainEvent.of("F0000000001");
        }catch (Exception exception){
            exception.printStackTrace();
         return FailDomainEvent.of(exception.getMessage());
        }
    }
}
