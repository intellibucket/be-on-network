package az.rock.flyjob.js.dataaccess.adapter.query.detail;

import az.rock.flyjob.js.dataaccess.mapper.abstracts.AbstractInterestDataAccessMapper;
import az.rock.flyjob.js.dataaccess.model.entity.resume.details.InterestEntity;
import az.rock.flyjob.js.dataaccess.repository.abstracts.query.jpa.AbstractInterestQueryJPARepository;
import az.rock.flyjob.js.domain.core.root.detail.InterestRoot;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.query.AbstractInterestQueryRepositoryAdapter;
import az.rock.lib.domain.id.js.InterestID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.AccessModifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class InterestQueryRepositoryAdapter implements AbstractInterestQueryRepositoryAdapter {
    private final AbstractInterestQueryJPARepository repository;

    private final AbstractInterestDataAccessMapper<InterestEntity, InterestRoot> interestDataAccessMapper;

    public InterestQueryRepositoryAdapter(AbstractInterestQueryJPARepository companyProfileQueryJPARepository,
                                          AbstractInterestDataAccessMapper<InterestEntity, InterestRoot> companyProfileDataAccessMapper) {
        this.repository = companyProfileQueryJPARepository;
        this.interestDataAccessMapper = companyProfileDataAccessMapper;
    }

    @Override
    public Optional<InterestRoot> findOwnByID(ResumeID parentID, InterestID rootId, List<AccessModifier> accessModifiers) {
        var entity = repository.findByResumeAndInterestId(parentID.getAbsoluteID(), rootId.getAbsoluteID(), accessModifiers);
        if (entity.isEmpty()) return Optional.empty();
        return this.interestDataAccessMapper.toRoot(entity.get());
    }

    @Override
    public Optional<InterestRoot> findById(InterestID rootId) {
        return Optional.empty();
    }

    @Override
    public Optional<InterestRoot> findByPID(ResumeID parentID, List<AccessModifier> accessModifiers) {
        return AbstractInterestQueryRepositoryAdapter.super.findByPID(parentID);
    }


    @Override
    public List<InterestRoot> findAllByPID(ResumeID parentID, List<AccessModifier> modifierList) {
        var allByResumeID = repository.findAllByResumeID(parentID.getAbsoluteID(), modifierList);
        return allByResumeID.stream()
                .map(this.interestDataAccessMapper::toRoot)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }

    @Override
    public Optional<Integer> getLimit(ResumeID resumeID) {
        final Optional<Integer> interestCount = repository.limitCount(resumeID.getAbsoluteID());
        if (interestCount.isPresent()) {
            return interestCount;
        }
        return Optional.empty();
    }

    @Override
    public Boolean existByResumeIDAndName(ResumeID resumeID, InterestRoot interestRoot) {
        return null;
    }


}
