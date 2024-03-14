package az.rock.flyjob.js.presentation.api.rest.privates.query;

import az.rock.flyjob.js.domain.presentation.dto.response.resume.course.AnyCourseResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.course.MyCourseResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.course.simple.SimpleAnyCourseResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.course.simple.SimpleMyCourseResponseModel;
import az.rock.flyjob.js.domain.presentation.ports.input.services.command.abstracts.AbstractCourseQueryDomainPresentationService;
import az.rock.flyjob.js.spec.privates.query.resume.detail.CourseQueryPrivateSpec;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import az.rock.lib.valueObject.SimplePageableRequest;
import az.rock.lib.valueObject.SimplePageableResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping(value = "/js/1.0/private/query/course", produces = MediaType.APPLICATION_JSON_VALUE)
public class CourseQueryPrivateController implements CourseQueryPrivateSpec {


    private final AbstractCourseQueryDomainPresentationService abstractCourseQueryDomainPresentationService;

    public CourseQueryPrivateController(AbstractCourseQueryDomainPresentationService
                                                abstractCourseQueryDomainPresentationService) {
        this.abstractCourseQueryDomainPresentationService = abstractCourseQueryDomainPresentationService;
    }

    @Override
    public ResponseEntity<JSuccessDataResponse<SimplePageableResponse<MyCourseResponseModel>>> queryAllMyCourses(SimplePageableRequest pageableRequest) {
        return null;
    }

    @Override
    public ResponseEntity<JSuccessDataResponse<SimplePageableResponse<AnyCourseResponseModel>>> queryAllAnyCourses(UUID targetResumeId, SimplePageableRequest pageableRequest) {
        return null;
    }

    @Override
    public ResponseEntity<JSuccessDataResponse<MyCourseResponseModel>> findMyCourseById(UUID id) {
        return null;
    }

    @Override
    @GetMapping("/get-all-any-simple-courses/{targetResumeId}")
    public ResponseEntity<JSuccessDataResponse<SimplePageableResponse<SimpleAnyCourseResponseModel>>> queryAllAnySimpleCourses(@PathVariable(name = "targetResumeId") UUID targetResumeId, @RequestBody SimplePageableRequest pageableRequest) {
        var response = abstractCourseQueryDomainPresentationService.allAnySimpleCourses(targetResumeId, pageableRequest);
        return ResponseEntity.ok(new JSuccessDataResponse<>(response));
    }

    @Override
    @GetMapping("/get-all-my-simple-courses")
    public ResponseEntity<JSuccessDataResponse<SimplePageableResponse<SimpleMyCourseResponseModel>>> queryAllMySimpleCourses(@RequestBody SimplePageableRequest pageableRequest) {
        var response = abstractCourseQueryDomainPresentationService.allMySimpleCourses(pageableRequest);
        return ResponseEntity.ok(new JSuccessDataResponse<>(response));
    }


    @Override
    @GetMapping("/get-any-course/{id}")
    public ResponseEntity<JSuccessDataResponse<AnyCourseResponseModel>> findAnyCourseById(@PathVariable(name = "id") UUID id) {
        var response = abstractCourseQueryDomainPresentationService.findAnyCourse(id);
        return ResponseEntity.ok(new JSuccessDataResponse<>(response));
    }


}
