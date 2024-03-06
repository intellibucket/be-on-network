package az.rock.auth.domain.presentation.ports.output.publisher;

import az.rock.lib.annotation.DomainOutputPort;
import com.intellibucket.lib.fj.notificatin.api.notifications.ViewedProfileNotification;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@DomainOutputPort
@Transactional(propagation = Propagation.REQUIRES_NEW)
public interface AbstractNotificationMessagePublisher {
    void send(ViewedProfileNotification notification);
}
