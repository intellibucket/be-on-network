package az.rock.flyjob.auth.messaging.listener;

import az.rock.auth.domain.presentation.ports.input.listener.concretes.JobSeekerCreatedCoordinatorListener;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intellibucket.lib.payload.trx.SagaProcess;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class JobSeekerCreatedKafkaListener {
    private final ObjectMapper objectMapper;
    private final JobSeekerCreatedCoordinatorListener jobSeekerCreatedCoordinatorListener;

    public JobSeekerCreatedKafkaListener(ObjectMapper objectMapper, JobSeekerCreatedCoordinatorListener jobSeekerCreatedCoordinatorListener) {
        this.objectMapper = objectMapper;
        this.jobSeekerCreatedCoordinatorListener = jobSeekerCreatedCoordinatorListener;
    }


    @KafkaListener(topics = "auth.user-created-event.js.success",groupId = "auth.user-created-group")
    public void successCaseListener(JsonNode record) {
        try {
            var model = this.objectMapper.treeToValue(record, SagaProcess.class);
            this.jobSeekerCreatedCoordinatorListener.listenOnSuccess(model);
        } catch (JsonProcessingException e) {
            //TODO
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @KafkaListener(topics = "auth.user-created-event.js.fail",groupId = "auth.user-created-group")
    public void failCaseListener(JsonNode record) {
        try {
            var model = this.objectMapper.treeToValue(record, SagaProcess.class);
            this.jobSeekerCreatedCoordinatorListener.listenOnFail(model);
        } catch (JsonProcessingException e) {
            //TODO
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
