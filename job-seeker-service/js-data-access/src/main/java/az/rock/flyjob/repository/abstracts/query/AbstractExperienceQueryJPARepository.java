package az.rock.flyjob.repository.abstracts.query;

import az.rock.flyjob.model.entity.resume.details.ContactEntity;
import az.rock.flyjob.model.entity.resume.details.ExperienceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AbstractExperienceQueryJPARepository extends JpaRepository<ExperienceEntity, UUID> {
}
