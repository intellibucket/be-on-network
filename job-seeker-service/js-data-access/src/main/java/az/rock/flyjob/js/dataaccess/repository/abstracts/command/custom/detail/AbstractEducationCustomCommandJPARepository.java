package az.rock.flyjob.js.dataaccess.repository.abstracts.command.custom.detail;

import az.rock.flyjob.js.dataaccess.model.entity.resume.details.EducationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AbstractEducationCustomCommandJPARepository extends JpaRepository<EducationEntity, UUID> {

}
