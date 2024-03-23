package az.rock.flyjob.js.domain.presentation.ports.input.services.command.concretes;

import az.rock.flyjob.js.domain.presentation.dto.response.resume.course.AnyCourseResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.course.MyCourseResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.course.simple.SimpleAnyCourseResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.course.simple.SimpleMyCourseResponseModel;
import az.rock.flyjob.js.domain.presentation.handler.abstracts.AbstractCourseQueryHandler;
import az.rock.flyjob.js.domain.presentation.ports.input.services.command.abstracts.AbstractCourseQueryDomainPresentationService;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.query.AbstractCourseQueryRepositoryAdapter;
import az.rock.flyjob.js.domain.presentation.security.AbstractSecurityContextHolder;
import az.rock.lib.domain.id.js.CourseID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.SimplePageableRequest;
import az.rock.lib.valueObject.SimplePageableResponse;
import az.rock.lib.valueObject.common.PageableRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class CourseQueryDomainPresentationService implements AbstractCourseQueryDomainPresentationService {

    private final AbstractCourseQueryHandler queryHandler;

    public CourseQueryDomainPresentationService(AbstractCourseQueryHandler queryHandler) {
        this.queryHandler = queryHandler;
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
        return (SimplePageableResponse<MyCourseResponseModel>) queryHandler.allMyCourses(pageableRequest).getPayload().getPayload();
    }

    @Override
    public SimplePageableResponse<AnyCourseResponseModel> allAnyCourses(UUID targetResumeId, SimplePageableRequest pageableRequest) {
        return (SimplePageableResponse<AnyCourseResponseModel>) queryHandler.allAnyCourses(targetResumeId, pageableRequest).getPayload().getPayload();
    }

    @Override
    public MyCourseResponseModel myCourseById(UUID id) {
        return (MyCourseResponseModel) queryHandler.myCourseById(id).getPayload().getPayload();
    }
}