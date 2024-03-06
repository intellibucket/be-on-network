package az.rock.flyjob.js.dataaccess.adapter.query;

import az.rock.flyjob.js.dataaccess.mapper.abstracts.AbstractCourseDataAccessMapper;
import az.rock.flyjob.js.dataaccess.model.entity.resume.ResumeEntity;
import az.rock.flyjob.js.dataaccess.repository.abstracts.query.AbstractCourseQueryJPARepository;
import az.rock.flyjob.js.domain.core.root.detail.CourseRoot;
import az.rock.flyjob.js.domain.presentation.mapper.abstracts.AbstractCourseDomainMapper;
import az.rock.flyjob.js.domain.presentation.mapper.concretes.CourseDomainMapper;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.query.AbstractCourseQueryRepositoryAdapter;
import az.rock.lib.domain.id.js.CourseID;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;


@Component
public class CourseQueryRepositoryAdapter implements AbstractCourseQueryRepositoryAdapter {

    private final AbstractCourseQueryJPARepository courseQueryJPARepository;

    private final AbstractCourseDataAccessMapper courseDataAccessMapper;

    public CourseQueryRepositoryAdapter(AbstractCourseQueryJPARepository courseQueryJPARepository, AbstractCourseDataAccessMapper courseDataAccessMapper) {
        this.courseQueryJPARepository = courseQueryJPARepository;
        this.courseDataAccessMapper = courseDataAccessMapper;
    }

    @Override
    public Boolean existsByTitleAndResume(String courseName, UUID resumeID) {
        return courseQueryJPARepository.existsByTitleAndResume(courseName, resumeID);
    }

    @Override
    public Optional<CourseRoot> findById(CourseID courseID){
        var courseEntity = courseQueryJPARepository.findById(courseID.getAbsoluteID());
        if(courseID.isEmpty())return Optional.empty();
        return courseDataAccessMapper.toRoot(courseEntity.get());
    }
}
