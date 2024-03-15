package az.rock.flyjob.js.domain.presentation.ports.input.services.command.concretes;


import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.CreateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.item.CourseCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ReorderCommandModel;
import az.rock.flyjob.js.domain.presentation.handler.abstracts.AbstractCourseCommandHandler;
import az.rock.flyjob.js.domain.presentation.ports.input.services.command.abstracts.AbstractCourseCommandDomainPresentationService;
import az.rock.lib.annotation.InputPort;
import az.rock.lib.jexception.JRuntimeException;
import az.rock.lib.valueObject.MultipartFileWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@InputPort
@Slf4j
public class CourseCommandDomainPresentationService implements AbstractCourseCommandDomainPresentationService {
    private  AbstractCourseCommandHandler commandHandler;

    public CourseCommandDomainPresentationService(AbstractCourseCommandHandler commandHandler) {
        this.commandHandler = commandHandler;
    }


    @Override
    public void create(CreateRequest<CourseCommandModel> command) {
        try {
            var courseCreatedEvent = commandHandler.create(command.getModel());
        } catch (Exception e) {
            throw new JRuntimeException(e.getMessage(), e);
        }
    }

    @Override
    public void update(UpdateRequest<CourseCommandModel> command) {
        try {
            var courseUpdatedEvent = commandHandler.merge(command.getModel(), command.getTargetId());
        } catch (Exception e) {
            throw new JRuntimeException(e.getMessage(), e);
        }
    }

    @Override
    public void delete(UUID courseId) {
        try {
            var courseDeleteEvent = commandHandler.delete(courseId);
        } catch (Exception e) {
            throw new JRuntimeException(e.getMessage(), e);
        }
    }

    @Override
    public void reorder(ReorderCommandModel command) {
        try {
            var reorderEvent = commandHandler.reorder(command);
        } catch (Exception e) {
            throw new JRuntimeException(e.getMessage(), e);
        }
    }

    @Override
    public void uploadCertificate(UUID courseId, MultipartFileWrapper file) {
        try {
            var certificateEvent = commandHandler.uploadCertificate(courseId, file);
        } catch (Exception e) {
            throw new JRuntimeException(e.getMessage(), e);
        }

    }
}
