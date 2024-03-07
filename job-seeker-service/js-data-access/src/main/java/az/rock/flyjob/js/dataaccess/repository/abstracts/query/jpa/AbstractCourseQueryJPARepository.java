package az.rock.flyjob.js.dataaccess.repository.abstracts.query.jpa;

import az.rock.flyjob.js.dataaccess.model.entity.resume.ResumeEntity;
import az.rock.flyjob.js.dataaccess.model.entity.resume.details.CourseEntity;
import az.rock.lib.domain.id.js.ResumeID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AbstractCourseQueryJPARepository extends JpaRepository<CourseEntity, UUID> {
    @Query("SELECT COUNT(c) > 0 FROM CourseEntity c WHERE c.courseTitle = :title AND c.resume.id = :resume")
    Boolean existsByTitleAndResume(@Param("title") String title, @Param("resume") UUID resume);


}
