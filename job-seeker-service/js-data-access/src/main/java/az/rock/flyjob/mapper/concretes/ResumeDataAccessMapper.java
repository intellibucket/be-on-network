package az.rock.flyjob.mapper.concretes;

import az.rock.flyjob.js.domain.core.root.ResumeRoot;
import az.rock.flyjob.mapper.abstracts.AbstractResumeDataAccessMapper;
import az.rock.flyjob.model.entity.resume.ResumeEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ResumeDataAccessMapper implements AbstractResumeDataAccessMapper {
    @Override
    public Optional<ResumeRoot> toRoot(ResumeEntity entity) {
        return Optional.empty();
    }

    @Override
    public Optional<ResumeEntity> toEntity(ResumeRoot root) {
        return Optional.empty();
    }
}
