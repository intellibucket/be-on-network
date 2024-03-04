package az.rock.flyjob.js.domain.presentation.ports.input.services.command.concretes;


import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.CreateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.item.CourseCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ReorderCommandModel;
import az.rock.flyjob.js.domain.presentation.handler.abstracts.AbstractCourseCreateCommandHandler;
import az.rock.flyjob.js.domain.presentation.ports.input.services.command.abstracts.AbstractCourseCommandDomainPresentationService;
import az.rock.lib.annotation.InputPort;
import az.rock.lib.valueObject.MultipartFileWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@InputPort
@Slf4j
public class CourseCommandDomainPresentationService implements AbstractCourseCommandDomainPresentationService{
    //TODO ADD SAGA,XUSUSI ERROR
    private AbstractCourseCreateCommandHandler courseMergeCommandHandler;

    public CourseCommandDomainPresentationService(AbstractCourseCreateCommandHandler courseMergeCommandHandler) {
        this.courseMergeCommandHandler = courseMergeCommandHandler;
    }

//    private final AbstractCourseUpdateCommandHandler userUpdateCommandHandler;
//    private final AbstractJobSeekerCreateEventCoordinator jobSeekerCreateEventCoordinator;
//    private final AbstractCompanyCreateEventCoordinator companyCreateEventCoordinator;

    @Override
    public void create(CreateRequest<CourseCommandModel> command) {
        var courseCommandModel = Optional.of(command.getModel()).orElseThrow(()->new RuntimeException(""));
        var courseCreatedEvent = courseMergeCommandHandler.mergeCourse(courseCommandModel);

    }

    @Override
    public void update(UpdateRequest<CourseCommandModel> command) {
        var courseCommandModel = Optional.of(command.getModel()).orElseThrow(()->new RuntimeException(""));
        var courseUpdatedEvent = courseMergeCommandHandler.mergeCourse(courseCommandModel);
    }

    @Override
    public void delete(UUID courseId) {
        var courseDeleteEvent = courseMergeCommandHandler.deleteCourse(courseId);
    }

    @Override
    public void reorder(ReorderCommandModel request) {

    }

    @Override
    public void uploadCertificate(UUID courseId, MultipartFileWrapper file) {

    }
}
