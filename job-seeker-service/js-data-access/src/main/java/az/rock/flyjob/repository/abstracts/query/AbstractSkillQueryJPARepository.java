package az.rock.flyjob.repository.abstracts.query;

import az.rock.flyjob.model.entity.resume.details.AwardEntity;
import az.rock.flyjob.model.entity.resume.details.SkillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AbstractSkillQueryJPARepository extends JpaRepository<SkillEntity, UUID> {
}