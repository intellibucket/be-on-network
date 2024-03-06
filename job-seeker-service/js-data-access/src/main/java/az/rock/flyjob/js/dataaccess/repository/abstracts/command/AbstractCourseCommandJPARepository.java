package az.rock.flyjob.js.dataaccess.repository.abstracts.command;

import az.rock.flyjob.js.dataaccess.model.entity.resume.details.CourseEntity;
import az.rock.lib.valueObject.RowStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AbstractCourseCommandJPARepository extends JpaRepository<CourseEntity, UUID> {
    @Transactional
    @Modifying
    @Query("UPDATE CourseEntity c SET c.rowStatus = :rowStatus WHERE c.uuid = :uuid")
    CourseEntity setRowStatusById(UUID uuid, RowStatus rowStatus);

    @Transactional
    @Modifying
    @Query("UPDATE CourseEntity c SET c.certificateFilePath = :newFilePath WHERE c.uuid = :uuid")
    CourseEntity setCourseCertificatePath(UUID uuid,String newFilePath);





}
