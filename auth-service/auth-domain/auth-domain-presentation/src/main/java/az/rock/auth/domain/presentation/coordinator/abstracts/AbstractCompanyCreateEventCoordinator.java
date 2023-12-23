package az.rock.auth.domain.presentation.coordinator.abstracts;


import com.intellibucket.lib.payload.event.abstracts.AbstractEventCoordinator;
import com.intellibucket.lib.payload.event.create.user.CompanyCreatedEvent;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRES_NEW)
public abstract class AbstractCompanyCreateEventCoordinator extends AbstractEventCoordinator<CompanyCreatedEvent> {
}
