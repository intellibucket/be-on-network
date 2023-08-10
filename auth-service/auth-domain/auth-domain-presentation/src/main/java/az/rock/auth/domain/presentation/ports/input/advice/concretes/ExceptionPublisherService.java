package az.rock.auth.domain.presentation.ports.input.advice.concretes;

import az.rock.auth.domain.presentation.ports.input.advice.abstracts.AbstractExceptionPublisherService;
import az.rock.lib.domain.id.auth.UserID;
import az.rock.lib.valueObject.ExceptionPublishModel;
import org.springframework.stereotype.Service;

@Service
public class ExceptionPublisherService implements AbstractExceptionPublisherService {

    @Override
    public void publish(UserID userID,Exception exception) {
        var publishModel = ExceptionPublishModel.of(userID,exception);
    }
}
