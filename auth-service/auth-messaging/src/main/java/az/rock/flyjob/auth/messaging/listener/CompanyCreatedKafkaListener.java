package az.rock.flyjob.auth.messaging.listener;

import az.rock.auth.domain.presentation.ports.input.listener.concretes.CompanyCreatedCoordinatorListener;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intellibucket.lib.payload.trx.AbstractSagaProcess;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CompanyCreatedKafkaListener {
    private final ObjectMapper objectMapper;
    private final CompanyCreatedCoordinatorListener companyCreatedCoordinatorListener;

    public CompanyCreatedKafkaListener(ObjectMapper objectMapper, CompanyCreatedCoordinatorListener companyCreatedCoordinatorListener) {
        this.objectMapper = objectMapper;
        this.companyCreatedCoordinatorListener = companyCreatedCoordinatorListener;
    }


    @KafkaListener(topics = "${topic.cmp.created.success}", groupId = "auth.user-created-group")
    public void successCaseListener(JsonNode record) {
        try {
            var model = this.objectMapper.treeToValue(record, AbstractSagaProcess.class);
            this.companyCreatedCoordinatorListener.listenOnSuccess(model);
        } catch (JsonProcessingException e) {
            log.error("Error while parsing json to object", e);
            throw new RuntimeException(e);
        }
    }

    @KafkaListener(topics = "${topic.cmp.created.fail}", groupId = "auth.user-created-group")
    public void failCaseListener(JsonNode record) {
        try {
            var model = this.objectMapper.treeToValue(record, AbstractSagaProcess.class);
            this.companyCreatedCoordinatorListener.listenOnFail(model);
        } catch (JsonProcessingException e) {
            log.error("Error while parsing json to object", e);
            throw new RuntimeException(e);
        }
    }
}
