package az.rock.flyjob.js.dataaccess.adapter.query;

import az.rock.flyjob.js.dataaccess.model.entity.resume.ResumeEntity;
import az.rock.flyjob.js.dataaccess.repository.abstracts.query.jpa.AbstractCourseQueryJPARepository;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.query.AbstractCourseQueryRepositoryAdapter;
import org.springframework.stereotype.Component;

import java.util.UUID;


@Component
public class CourseQueryRepositoryAdapter implements AbstractCourseQueryRepositoryAdapter {

    private final AbstractCourseQueryJPARepository courseQueryJPARepository;

    public CourseQueryRepositoryAdapter(AbstractCourseQueryJPARepository courseQueryJPARepository) {
        this.courseQueryJPARepository = courseQueryJPARepository;
    }

    @Override
    public Boolean existsByTitleAndResume(String courseName, UUID resumeID) {
        return courseQueryJPARepository.existsByTitleAndResume(courseName, ResumeEntity.referenceOf(resumeID));
    }
}
