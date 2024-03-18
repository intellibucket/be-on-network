package az.rock.flyjob.js.domain.presentation.handler.concretes;

import az.rock.flyjob.js.domain.core.exception.course.CourseNotFoundException;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.course.AnyCourseResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.course.MyCourseResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.course.simple.SimpleAnyCourseResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.course.simple.SimpleMyCourseResponseModel;
import az.rock.flyjob.js.domain.presentation.handler.abstracts.AbstractCourseQueryHandler;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.query.AbstractCourseQueryRepositoryAdapter;
import az.rock.flyjob.js.domain.presentation.security.AbstractSecurityContextHolder;
import az.rock.lib.domain.id.js.CourseID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.SimplePageableRequest;
import az.rock.lib.valueObject.SimplePageableResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;


@Component
public class CourseQueryHandler implements AbstractCourseQueryHandler {


    private final AbstractSecurityContextHolder securityContextHolder;

    private final AbstractCourseQueryRepositoryAdapter courseQueryRepositoryAdapter;

    private List<AccessModifier> mockAccessModifiers = List.of(AccessModifier.values());

    public CourseQueryHandler(AbstractSecurityContextHolder securityContextHolder, AbstractCourseQueryRepositoryAdapter courseQueryRepositoryAdapter) {
        this.securityContextHolder = securityContextHolder;
        this.courseQueryRepositoryAdapter = courseQueryRepositoryAdapter;
    }

    @Override
    public SimplePageableResponse<MyCourseResponseModel> allMyCourses(SimplePageableRequest pageableRequest) {
        var resumeId = securityContextHolder.availableResumeID();
        var courses = courseQueryRepositoryAdapter.findAllMyCourses(pageableRequest,resumeId)
                .stream()
                .map(MyCourseResponseModel::of)
                .toList();
        return SimplePageableResponse.of(pageableRequest.getSize(), pageableRequest.getPage(),null,courses);
    }

    @Override
    public SimplePageableResponse<AnyCourseResponseModel> allAnyCourses(UUID targetResumeId, SimplePageableRequest pageableRequest) {
        var courses = courseQueryRepositoryAdapter.findAllAnyCourses(ResumeID.of(targetResumeId),pageableRequest,mockAccessModifiers)
                .stream()
                .map(AnyCourseResponseModel::of)
                .toList();
        return SimplePageableResponse.of(pageableRequest.getSize(), pageableRequest.getPage(),null,courses);
    }

    @Override
    public MyCourseResponseModel myCourseById(UUID id){
        var course = courseQueryRepositoryAdapter.findMyCourseById(CourseID.of(id),securityContextHolder.availableResumeID());
        return MyCourseResponseModel.of(course.orElseThrow());
    }


    @Override
    public AnyCourseResponseModel findAnyCourse(UUID uuid) {
        return null;
    }

    @Override
    public SimplePageableResponse<SimpleMyCourseResponseModel> allMySimpleCourses(SimplePageableRequest simplePageableRequest) {
        return null;
    }

    @Override
    public SimplePageableResponse<SimpleAnyCourseResponseModel> allAnySimpleCourses(UUID targetResumeId, SimplePageableRequest pageableRequest) {
        return null;
    }
}
