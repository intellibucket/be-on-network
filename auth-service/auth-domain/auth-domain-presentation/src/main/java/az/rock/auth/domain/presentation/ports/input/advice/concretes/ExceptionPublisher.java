package az.rock.auth.domain.presentation.ports.input.advice.concretes;

import az.rock.auth.domain.presentation.ports.input.advice.abstracts.AbstractExceptionPublisher;
import az.rock.lib.domain.id.UserID;
import az.rock.lib.valueObject.ExceptionPublishModel;
import org.springframework.stereotype.Component;

@Component
public class ExceptionPublisher implements AbstractExceptionPublisher {

    @Override
    public void publish(UserID userID,Exception exception) {
        var publishModel = ExceptionPublishModel.of(userID,exception);
    }
}
