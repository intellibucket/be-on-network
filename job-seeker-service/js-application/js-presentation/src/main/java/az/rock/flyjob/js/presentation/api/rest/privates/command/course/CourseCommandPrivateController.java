package az.rock.flyjob.js.presentation.api.rest.privates.command.course;

import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.CreateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.item.CourseCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ReorderCommandModel;
import az.rock.flyjob.js.domain.presentation.ports.input.services.command.abstracts.AbstractCourseCommandDomainPresentationService;
import az.rock.flyjob.js.spec.privates.command.resume.detail.CourseCommandPrivateSpec;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;


@CrossOrigin
@RestController
@RequestMapping(value = "/js/1.0/private/command/course", produces = MediaType.APPLICATION_JSON_VALUE)
public class CourseCommandPrivateController implements CourseCommandPrivateSpec {
    //TODO requestlerin url-lerin duzelt
    private final AbstractCourseCommandDomainPresentationService courseCommandDomainPresentationService;

    public CourseCommandPrivateController(AbstractCourseCommandDomainPresentationService
                                                  courseCommandDomainPresentationService) {
        this.courseCommandDomainPresentationService = courseCommandDomainPresentationService;
    }

    @Override
    @PostMapping("/create")
    public ResponseEntity<JSuccessResponse> create(CreateRequest<CourseCommandModel> request) {
        this.courseCommandDomainPresentationService.create(request);
        return ResponseEntity.ok(new JSuccessResponse());
    }

    @Override
    @PutMapping("/update")
    public ResponseEntity<JSuccessResponse> update(UpdateRequest<CourseCommandModel> request) {
        this.courseCommandDomainPresentationService.update(request);
        return ResponseEntity.ok(new JSuccessResponse());
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<JSuccessResponse> delete(@PathVariable("id") UUID courseId) {
        this.courseCommandDomainPresentationService.delete(courseId);
        return ResponseEntity.ok(new JSuccessResponse());
    }

    @Override
    @PutMapping("/reorder")
    public ResponseEntity<JSuccessResponse> reorder(ReorderCommandModel request) {
        this.courseCommandDomainPresentationService.reorder(request);
        return ResponseEntity.ok(new JSuccessResponse());
    }

    @Override
    @PostMapping("/{courseId}/certificates")
    public ResponseEntity<JSuccessResponse> uploadCertificate(@PathVariable UUID courseId, @RequestBody MultipartFile file) {
        //TODO MultipartFileWrapperMapper class-ni static e cevirmek? or yene ele bir compananent yazmaq?InputSourceStream?
//        this.courseCommandDomainPresentationService.uploadCertificate(courseId,file);
        return ResponseEntity.ok(new JSuccessResponse());
    }
}
