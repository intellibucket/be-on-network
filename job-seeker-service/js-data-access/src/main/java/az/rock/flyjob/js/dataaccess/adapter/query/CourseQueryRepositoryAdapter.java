package az.rock.flyjob.js.dataaccess.adapter.query;

import az.rock.flyjob.js.dataaccess.mapper.abstracts.AbstractCourseDataAccessMapper;
import az.rock.flyjob.js.dataaccess.repository.abstracts.query.jpa.AbstractCourseQueryJPARepository;
import az.rock.flyjob.js.domain.core.root.detail.CourseRoot;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.query.AbstractCourseQueryRepositoryAdapter;
import az.rock.lib.domain.id.js.CourseID;
import az.rock.lib.domain.id.js.ResumeID;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class CourseQueryRepositoryAdapter implements AbstractCourseQueryRepositoryAdapter {

    private final AbstractCourseQueryJPARepository courseQueryJPARepository;

    private final AbstractCourseDataAccessMapper courseDataAccessMapper;

    public CourseQueryRepositoryAdapter(AbstractCourseQueryJPARepository courseQueryJPARepository, AbstractCourseDataAccessMapper courseDataAccessMapper) {
        this.courseQueryJPARepository = courseQueryJPARepository;
        this.courseDataAccessMapper = courseDataAccessMapper;
    }

    @Override
    public Boolean existsByEquality(CourseRoot root) {
        return courseQueryJPARepository.existsByEquality(root.getCourseTitle(), root.getResume().getRootID(),root.getRootID().getRootID());
    }

    @Override
    public Optional<CourseRoot> findById(CourseID courseID){
        var courseEntity = courseQueryJPARepository.findById(courseID.getAbsoluteID());
        if(courseEntity.isEmpty())return Optional.empty();
        return courseDataAccessMapper.toRoot(courseEntity.get());
    }
}
