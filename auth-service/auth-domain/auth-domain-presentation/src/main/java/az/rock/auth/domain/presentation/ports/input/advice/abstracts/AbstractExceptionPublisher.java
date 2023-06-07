package az.rock.auth.domain.presentation.ports.input.advice.abstracts;

import az.rock.lib.domain.id.UserID;
import az.rock.lib.valueObject.ExceptionPublishModel;

public interface AbstractExceptionPublisher {
    void publish(UserID userID,Exception exception);
}
