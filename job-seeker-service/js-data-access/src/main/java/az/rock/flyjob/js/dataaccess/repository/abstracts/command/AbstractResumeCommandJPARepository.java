package az.rock.flyjob.js.dataaccess.repository.abstracts.command;

import az.rock.flyjob.js.dataaccess.model.entity.resume.ResumeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AbstractResumeCommandJPARepository extends JpaRepository<ResumeEntity, UUID> {
}
