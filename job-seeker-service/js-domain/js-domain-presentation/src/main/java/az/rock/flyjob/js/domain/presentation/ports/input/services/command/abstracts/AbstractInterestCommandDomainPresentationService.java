package az.rock.flyjob.js.domain.presentation.ports.input.services.command.abstracts;

import az.rock.flyjob.js.domain.presentation.dto.request.item.InterestCommandModel;
import az.rock.lib.annotation.InputPort;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@InputPort
@Transactional
public interface AbstractInterestCommandDomainPresentationService {
    void create(InterestCommandModel newInterestCommandModel);
}
