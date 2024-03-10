package az.rock.flyjob.js.domain.presentation.ports.input.services.command.abstracts;

import az.rock.flyjob.js.domain.core.exception.InterestNameIsExist;
import az.rock.flyjob.js.domain.core.exception.InterestNotFound;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.item.InterestCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ReorderCommandModel;
import az.rock.lib.annotation.InputPort;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@InputPort
@Transactional
public interface AbstractInterestCommandDomainPresentationService  {
    void create(InterestCommandModel newInterestCommandModel) throws InterestNameIsExist;


    void update(UpdateRequest<InterestCommandModel> updateRequest) throws Exception;

    void delete(UUID interestId) throws InterestNotFound;

    void  reorder(ReorderCommandModel request) throws InterestNotFound;
}
