package az.rock.flyjob.repository.abstracts.query;

import az.rock.flyjob.model.entity.resume.ResumeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AbstractResumeQueryJPARepository extends JpaRepository<ResumeEntity, UUID> {
}
