package az.rock.flyjob.js.dataaccess.repository.abstracts.query;

import az.rock.flyjob.js.dataaccess.model.entity.resume.ResumeEntity;
import az.rock.flyjob.js.dataaccess.model.entity.resume.details.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AbstractCourseQueryJPARepository extends JpaRepository<CourseEntity, UUID> {

    @Query("SELECT count(row) > 0 FROM CourseEntity row " +
            "WHERE (:title = row.course_title) AND (:resume = row.resume)")
    Boolean existsByTitleAndResume(String title, ResumeEntity resume);
}
