package az.rock.flyjob.js.dataaccess.repository.abstracts.query.jpa;

import az.rock.flyjob.js.dataaccess.model.entity.resume.details.EducationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface EducationQueryJpaRepository extends JpaRepository<EducationEntity, UUID> {
    @Query("SELECT e FROM EducationEntity e WHERE e.resume.uuid = :resumeID AND e.uuid = :educationId AND e.rowStatus = 'ACTIVE'")
    Optional<EducationEntity> findByIdAndResumeIdAndRowStatusActive(@Param("resumeID") UUID resumeID, @Param("educationId") UUID educationId);
}
