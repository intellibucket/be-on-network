package az.rock.flyjob.js.dataaccess.repository.abstracts.query.jpa;

import az.rock.flyjob.js.dataaccess.model.entity.resume.details.SkillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AbstractSkillQueryJPARepository extends JpaRepository<SkillEntity, UUID> {
}
