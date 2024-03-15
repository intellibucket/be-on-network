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
    @GetMapping("get-all-courses")
    public ResponseEntity<JSuccessDataResponse<SimplePageableResponse<MyCourseResponseModel>>> queryAllMyCourses(@RequestBody SimplePageableRequest pageableRequest) {
        System.out.println("1");
        var response = this.abstractCourseQueryDomainPresentationService.allMyCourses(pageableRequest);
        return ResponseEntity.ok(new JSuccessDataResponse<>(response));
    }

    @Override
    @GetMapping("get-all-any-courses/{targetResumeId}")
    public ResponseEntity<JSuccessDataResponse<SimplePageableResponse<AnyCourseResponseModel>>> queryAllAnyCourses(@PathVariable UUID targetResumeId, @RequestBody SimplePageableRequest pageableRequest) {
        var response = this.abstractCourseQueryDomainPresentationService.allAnyCourses(targetResumeId, pageableRequest);
        return ResponseEntity.ok(new JSuccessDataResponse<>(response));
    }

    @Override
    @GetMapping("/get-my-course/{id}")
    public ResponseEntity<JSuccessDataResponse<MyCourseResponseModel>> findMyCourseById(@PathVariable UUID id) {
        var response = this.abstractCourseQueryDomainPresentationService.myCourseById(id);
        return ResponseEntity.ok(new JSuccessDataResponse<>(response));
    }

    @Override
    @GetMapping("/get-all-any-simple-courses")
    public ResponseEntity<JSuccessDataResponse<SimplePageableResponse<SimpleAnyCourseResponseModel>>> queryAllAnySimpleCourses(UUID targetResumeId, SimplePageableRequest pageableRequest) {
        var response = abstractCourseQueryDomainPresentationService.allAnySimpleCourses(targetResumeId, pageableRequest);
        return ResponseEntity.ok(new JSuccessDataResponse<>(response));
    }
    @Override
    @GetMapping("/get-all-my-simple-courses")
    public ResponseEntity<JSuccessDataResponse<SimplePageableResponse<SimpleMyCourseResponseModel>>> queryAllMySimpleCourses(SimplePageableRequest pageableRequest) {
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