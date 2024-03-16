package az.rock.flyjob.js.dataaccess.repository.abstracts.query.jpa;

import az.rock.flyjob.js.dataaccess.model.entity.resume.ResumeEntity;
import az.rock.flyjob.js.dataaccess.model.entity.resume.details.ContactEntity;
import az.rock.flyjob.js.dataaccess.model.entity.resume.details.EducationEntity;
import az.rock.flyjob.js.dataaccess.model.entity.resume.details.InterestEntity;
import az.rock.flyjob.js.dataaccess.repository.abstracts.GJpaRepository;
import az.rock.flyjob.js.domain.core.root.detail.ContactRoot;
import az.rock.lib.valueObject.AccessModifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AbstractContactQueryJPARepository extends GJpaRepository<ContactEntity, UUID> {

    @Query("SELECT count(row) > 0 FROM ContactEntity row " +
            "WHERE (:resume = row.resume) and (row.rowStatus = 'ACTIVE')")
    Boolean existByContact(ContactRoot resume);
    @Query("select  e from ContactEntity  e where e.resume.uuid=:resumeId and e.uuid=:contactId and e.rowStatus='ACTIVE' ")
    Optional<ContactEntity> findResumeIDandContactID(@Param(value = "resumeId") UUID resumeID, @Param(value = "contactId") UUID contactId);
    @Query("SELECT e FROM ContactEntity e WHERE e.resume.uuid = :resumeID AND e.rowStatus = 'ACTIVE' order by e.orderNumber")
    Optional<ContactEntity> findByPID(@Param("resumeID") UUID resumeID);
    @Query("SELECT e FROM ContactEntity e WHERE e.uuid = :contactId AND e.rowStatus = 'ACTIVE'")
    Optional<ContactEntity> findById(@Param("educationId") UUID contactId);
    @Query("SELECT e FROM ContactEntity e WHERE e.resume.uuid = :resumeID AND e.rowStatus = 'ACTIVE' order by e.orderNumber")
    List<ContactEntity> findAll(@Param("resumeID") UUID resumeID);

}
