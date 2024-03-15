package az.rock.flyjob.js.domain.presentation.ports.input.services.command.concretes;

import az.rock.flyjob.js.domain.presentation.dto.response.resume.course.AnyCourseResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.course.MyCourseResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.course.simple.SimpleAnyCourseResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.course.simple.SimpleMyCourseResponseModel;
import az.rock.flyjob.js.domain.presentation.ports.input.services.command.abstracts.AbstractCourseQueryDomainPresentationService;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.query.AbstractCourseQueryRepositoryAdapter;
import az.rock.flyjob.js.domain.presentation.security.AbstractSecurityContextHolder;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.SimplePageableRequest;
import az.rock.lib.valueObject.SimplePageableResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class CourseQueryDomainPresentationService implements AbstractCourseQueryDomainPresentationService {

    private final AbstractSecurityContextHolder securityContextHolder;

    private final AbstractCourseQueryRepositoryAdapter courseQueryRepositoryAdapter;

    private List<AccessModifier> mockAccessModifiers = List.of(AccessModifier.values());

    public CourseQueryDomainPresentationService(AbstractSecurityContextHolder securityContextHolder,
                                                AbstractCourseQueryRepositoryAdapter courseQueryRepositoryAdapter) {
        this.securityContextHolder = securityContextHolder;
        this.courseQueryRepositoryAdapter = courseQueryRepositoryAdapter;
    }

    @Override
    public SimplePageableResponse<SimpleAnyCourseResponseModel> allAnySimpleCourses(UUID targetResumeId, SimplePageableRequest pageableRequest) {
        return null;
    }

    @Override
    public SimplePageableResponse<SimpleMyCourseResponseModel> allMySimpleCourses(SimplePageableRequest simplePageableRequest) {
        return null;
    }

    @Override
    public AnyCourseResponseModel findAnyCourse(UUID uuid) {
        return null;
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
        var resumeId = securityContextHolder.availableResumeID();
        var courses = courseQueryRepositoryAdapter.findAllMyCourses(pageableRequest,resumeId)
                .stream()
                .map(AnyCourseResponseModel::of)
                .toList();
        return SimplePageableResponse.of(pageableRequest.getSize(), pageableRequest.getPage(),null,courses);
    }

    @Override
    public MyCourseResponseModel myCourseById(UUID id) {
        return null;
    }
}