package az.rock.flyjob.js.dataaccess.repository.abstracts.query.jpa;

import az.rock.flyjob.js.dataaccess.model.entity.resume.details.InterestEntity;
import az.rock.flyjob.js.domain.core.root.detail.InterestRoot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AbstractInterestQueryJPARepository extends JpaRepository<InterestEntity, UUID> {
    @Query("select i from InterestEntity i where i.resume.uuid=:resumeId or i.rowStatus='ACTIVE'")
    List<InterestEntity> findAllByResumeID(@Param(value = "resumeId") UUID resumeID);


    @Query("select  i from InterestEntity  i where i.resume.uuid=:resumeId and i.uuid=:interestId and i.rowStatus='ACTIVE' ")
    Optional<InterestEntity> findByResumeAndInterestId(@Param(value = "resumeId") UUID resumeID, @Param(value = "interestId") UUID interestID);
}
