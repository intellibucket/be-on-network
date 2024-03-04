package az.rock.flyjob.js.domain.presentation.ports.input.services.command.concretes;

import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.CreateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.item.EducationCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ReorderCommandModel;
import az.rock.flyjob.js.domain.presentation.handler.abstracts.AbstractEducationCommandHandler;
import az.rock.flyjob.js.domain.presentation.ports.input.services.command.abstracts.AbstractEducationCommandDomainPresentationsService;
import az.rock.lib.annotation.InputPort;
import org.springframework.stereotype.Service;

import java.util.UUID;
@InputPort
@Service
public class EducationCommandDomainPresentationService implements AbstractEducationCommandDomainPresentationsService {

    private final AbstractEducationCommandHandler abstractEducationCommandHandler;

    public EducationCommandDomainPresentationService(AbstractEducationCommandHandler abstractEducationCommandHandler) {
        this.abstractEducationCommandHandler = abstractEducationCommandHandler;
    }

    @Override
    public void create(CreateRequest<EducationCommandModel> request) {

    }

    @Override
    public void update(UpdateRequest<EducationCommandModel> request) {

    }

    @Override
    public void delete(UUID educationId) {

    }

    @Override
    public void reorder(ReorderCommandModel request) {

    }
}
