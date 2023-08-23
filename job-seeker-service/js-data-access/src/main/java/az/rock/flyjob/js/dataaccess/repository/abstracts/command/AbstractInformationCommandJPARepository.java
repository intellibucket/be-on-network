package az.rock.flyjob.js.dataaccess.repository.abstracts.command;

import az.rock.flyjob.js.dataaccess.model.entity.resume.main.InformationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AbstractInformationCommandJPARepository extends JpaRepository<InformationEntity, UUID> {
}
