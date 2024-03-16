package az.rock.flyjob.js.domain.presentation.ports.output.repository.query;


import az.rock.flyjob.js.domain.core.root.detail.CourseRoot;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.course.MyCourseResponseModel;
import az.rock.lib.annotation.DomainOutputPort;
import az.rock.lib.domain.id.js.CourseID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.SimplePageableRequest;
import az.rock.lib.valueObject.SimplePageableResponse;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@DomainOutputPort
public interface AbstractCourseQueryRepositoryAdapter{

    Boolean existsByEquality(CourseRoot root);

    Optional<CourseRoot> findById(CourseID courseID,ResumeID resumeID,List<AccessModifier> accessModifiers);

    List<CourseRoot> findAllByResume(ResumeID resumeID,List<AccessModifier> accessModifiers);

    Boolean isInLimit(Long limit,ResumeID resumeId);

    List<CourseRoot> findAllMyCourses(SimplePageableRequest pageableRequest,ResumeID resumeID);

    List<CourseRoot> findAllAnyCourses(ResumeID targetResumeId, SimplePageableRequest pageableRequest,List<AccessModifier> accessModifiers);

    Optional<CourseRoot> findMyCourseById(CourseID id,ResumeID resumeID);

}
