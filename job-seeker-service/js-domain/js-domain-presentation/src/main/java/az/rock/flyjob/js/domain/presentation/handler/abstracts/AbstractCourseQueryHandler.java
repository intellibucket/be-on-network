package az.rock.flyjob.js.domain.presentation.handler.abstracts;

import az.rock.flyjob.js.domain.presentation.dto.response.resume.course.AnyCourseResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.course.MyCourseResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.course.simple.SimpleAnyCourseResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.course.simple.SimpleMyCourseResponseModel;
import az.rock.lib.valueObject.SimplePageableRequest;
import az.rock.lib.valueObject.SimplePageableResponse;
import com.intellibucket.lib.payload.event.query.CourseFetchEvent;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Transactional(propagation = Propagation.REQUIRES_NEW)
public interface AbstractCourseQueryHandler {
    CourseFetchEvent allMyCourses(SimplePageableRequest pageableRequest);

    CourseFetchEvent allAnyCourses(UUID targetResumeId, SimplePageableRequest pageableRequest);

    CourseFetchEvent myCourseById(UUID id);

    AnyCourseResponseModel findAnyCourse(UUID uuid);

    SimplePageableResponse<SimpleMyCourseResponseModel> allMySimpleCourses(SimplePageableRequest simplePageableRequest);

    SimplePageableResponse<SimpleAnyCourseResponseModel> allAnySimpleCourses(UUID targetResumeId, SimplePageableRequest pageableRequest);
}
