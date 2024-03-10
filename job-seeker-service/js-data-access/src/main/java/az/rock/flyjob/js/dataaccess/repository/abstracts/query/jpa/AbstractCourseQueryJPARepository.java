package az.rock.flyjob.js.dataaccess.repository.abstracts.query.jpa;

import az.rock.flyjob.js.dataaccess.model.entity.resume.details.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AbstractCourseQueryJPARepository extends JpaRepository<CourseEntity, UUID> {
    @Query("SELECT COUNT(row) > 0 FROM CourseEntity row WHERE row.courseTitle = :title AND row.resume.uuid = :resume AND row.rowStatus = 'ACTIVE' AND row.uuid <> :course")
    Boolean existsByEquality(@Param("title") String title, @Param("resume") UUID resumeId, @Param("course") UUID courseId);

    @Query("SELECT c FROM CourseEntity c WHERE c.uuid=:id AND c.rowStatus = 'ACTIVE'")
    Optional<CourseEntity> findById(@Param("id") UUID id);

    @Query("SELECT c FROM CourseEntity c WHERE c.resume.uuid = :resume AND c.rowStatus = 'ACTIVE'")
    List<CourseEntity> findAllByResume(UUID resume);
}
