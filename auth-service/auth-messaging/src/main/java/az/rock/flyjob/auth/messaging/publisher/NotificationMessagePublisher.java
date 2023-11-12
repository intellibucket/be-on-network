package az.rock.flyjob.auth.messaging.publisher;

import az.rock.auth.domain.presentation.ports.output.publisher.AbstractNotificationMessagePublisher;
import com.intellibucket.lib.fj.notificatin.api.notifications.ViewedProfileNotification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NotificationMessagePublisher implements AbstractNotificationMessagePublisher {
    @Override
    public void send(ViewedProfileNotification notification) {
        log.info("Notify user about viewed profile");
    }
}
