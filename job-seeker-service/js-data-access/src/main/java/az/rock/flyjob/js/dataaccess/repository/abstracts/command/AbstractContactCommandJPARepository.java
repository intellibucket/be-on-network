package az.rock.flyjob.js.dataaccess.repository.abstracts.command;

import az.rock.flyjob.js.dataaccess.model.entity.resume.details.ContactEntity;
import az.rock.flyjob.js.dataaccess.model.entity.resume.details.CourseEntity;
import az.rock.flyjob.js.domain.core.root.ResumeRoot;
import az.rock.lib.valueObject.RowStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.rmi.server.UID;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface AbstractContactCommandJPARepository extends JpaRepository<ContactEntity, UUID> {
    @Transactional
    @Modifying
    @Query("UPDATE CourseEntity c SET c.rowStatus = :rowStatus WHERE c.uuid = :uuid")
    ContactEntity setRowStatusById(UUID uuid, RowStatus rowStatus);
}
