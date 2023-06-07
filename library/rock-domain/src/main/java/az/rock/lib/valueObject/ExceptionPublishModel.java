package az.rock.lib.valueObject;

import az.rock.lib.annotation.ValueObject;
import az.rock.lib.domain.id.UserID;

import java.util.UUID;

@ValueObject
public class ExceptionPublishModel {
    private final UserID userId;
    private final String message;
    private final StackTraceElement[] stackTraces;

    public ExceptionPublishModel(UserID uuid, Exception exception) {
        this.userId = uuid;
        this.message = exception.getMessage();
        this.stackTraces = exception.getStackTrace();
    }

    public static ExceptionPublishModel of(UserID uuid, Exception exception) {
        return new ExceptionPublishModel(uuid, exception);
    }
}
