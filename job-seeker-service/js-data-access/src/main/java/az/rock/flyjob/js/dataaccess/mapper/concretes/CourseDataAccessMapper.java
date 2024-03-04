package az.rock.flyjob.js.dataaccess.mapper.concretes;

import az.rock.flyjob.js.dataaccess.mapper.abstracts.AbstractCourseDataAccessMapper;
import az.rock.flyjob.js.dataaccess.model.entity.resume.details.CourseEntity;
import az.rock.flyjob.js.domain.core.root.detail.CourseRoot;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CourseDataAccessMapper implements AbstractCourseDataAccessMapper {
    @Override
    public Optional<CourseRoot> toRoot(CourseEntity entity) {
        return Optional.empty();
    }

    @Override
    public Optional<CourseEntity> toEntity(CourseRoot root) {
        return Optional.empty();
    }
}
