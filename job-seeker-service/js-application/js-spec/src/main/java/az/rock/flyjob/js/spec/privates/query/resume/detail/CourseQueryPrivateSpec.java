package az.rock.flyjob.js.spec.privates.query.resume.detail;

import az.rock.flyjob.js.domain.presentation.dto.response.resume.course.AnyCourseResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.course.MyCourseResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.course.simple.SimpleAnyCourseResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.course.simple.SimpleMyCourseResponseModel;
import az.rock.lib.valueObject.SimplePageableRequest;
import az.rock.lib.valueObject.SimplePageableResponse;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface CourseQueryPrivateSpec {
    ResponseEntity<SimplePageableResponse<MyCourseResponseModel>> queryAllMyCourses(SimplePageableRequest pageableRequest);

    ResponseEntity<SimplePageableResponse<AnyCourseResponseModel>> queryAllAnyCourses(SimplePageableRequest pageableRequest);

    ResponseEntity<SimplePageableResponse<SimpleMyCourseResponseModel>> queryAllMySimpleCourses(SimplePageableRequest pageableRequest);

    ResponseEntity<SimplePageableResponse<SimpleAnyCourseResponseModel>> queryAllAnySimpleCourses(SimplePageableRequest pageableRequest);

    ResponseEntity<MyCourseResponseModel> findMyCourseById(UUID id);

    ResponseEntity<AnyCourseResponseModel> findAnyCourseById(UUID id);
}
