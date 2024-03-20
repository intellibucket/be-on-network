package az.rock.flyjob.js.dataaccess.adapter.query.detail;

import az.rock.flyjob.js.dataaccess.mapper.abstracts.AbstractInterestDataAccessMapper;
import az.rock.flyjob.js.dataaccess.model.batis.model.InterestCompose;
import az.rock.flyjob.js.dataaccess.model.batis.model.InterestComposeExample;
import az.rock.flyjob.js.dataaccess.repository.abstracts.query.batis.AbstractInterestQueryBatisRepository;
import az.rock.flyjob.js.dataaccess.repository.abstracts.query.batis.InterestBatisRepository;
import az.rock.flyjob.js.dataaccess.repository.abstracts.query.jpa.AbstractInterestQueryJPARepository;
import az.rock.flyjob.js.domain.core.exception.interest.InterestNotFound;
import az.rock.flyjob.js.domain.core.root.detail.InterestRoot;
import az.rock.flyjob.js.domain.presentation.dto.criteria.InterestCriteria;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.AnyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.MyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.simple.SimpleAnyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.simple.SimpleMyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.query.AbstractInterestQueryRepositoryAdapter;
import az.rock.lib.domain.id.js.InterestID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.SimplePageableRequest;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class InterestQueryRepositoryAdapter implements AbstractInterestQueryRepositoryAdapter {

    private final InterestBatisRepository batisRepository;
    private final AbstractInterestQueryJPARepository repository;
    private final AbstractInterestDataAccessMapper interestDataAccessMapper;

    public InterestQueryRepositoryAdapter(InterestBatisRepository batisRepository, AbstractInterestQueryJPARepository repository, AbstractInterestDataAccessMapper interestDataAccessMapper) {
        this.batisRepository = batisRepository;
        this.repository = repository;
        this.interestDataAccessMapper = interestDataAccessMapper;
    }


    @Override
    public Optional<AnyInterestResponseModel> fetchAnyById(InterestCriteria interestCriteria) {
        var interestComposeExample = InterestComposeExample.of(interestCriteria);
        var interestCompose = this.batisRepository.selectByExample(interestComposeExample);
        if (!interestCompose.isEmpty() && interestCompose.size() == 1) {
            var root = this.interestDataAccessMapper.toRoot(interestCompose.get(0));
            return Optional.ofNullable(AnyInterestResponseModel.of(root.get()));
        }
        return Optional.empty();
    }

    @Override
    public List<SimpleAnyInterestResponseModel> fetchAllAnySimpleInterest(InterestCriteria criteria, SimplePageableRequest request) {
        InterestComposeExample interestComposeExample = InterestComposeExample.of(criteria);
        interestComposeExample.setPageable(interestComposeExample.new Pageable().of(request));

        final List<InterestCompose> interestComposes = this.batisRepository.selectByExample(interestComposeExample);
        if (!interestComposes.isEmpty()) {
            return interestComposes.stream().map(interestDataAccessMapper::toRoot)
                    .filter(item -> item.isPresent())
                    .toList()
                    .stream()
                    .map(root -> SimpleAnyInterestResponseModel.of(root.get())).collect(Collectors.toList());
        }
        return List.of();

    }

    @Override
    public List<AnyInterestResponseModel> findAllAnyInterests(UUID targetResumeId, SimplePageableRequest pageableRequest, List<AccessModifier> modifier) {
        return null;
    }


    @Override
    public Optional<InterestRoot> findMyInterestById(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<InterestRoot> queryAllMyInterests(SimplePageableRequest pageableRequest) {
        return null;
    }

    @Override
    public List<InterestRoot> queryAllMySimpleInterests(SimplePageableRequest pageableRequest) {
        return null;
    }

    @Override
    public Optional<InterestRoot> findOwnByID(ResumeID parentID, InterestID rootId, List<AccessModifier> accessModifiers) {
        var entity = repository.findByResumeAndInterestId(parentID.getAbsoluteID(), rootId.getAbsoluteID(), accessModifiers);
        if (entity.isEmpty()) return Optional.empty();
        return this.interestDataAccessMapper.toRoot(entity.get());
    }

    @Override
    public Optional<InterestRoot> findById(InterestID rootId) {
        var entity = repository.findById(rootId);
        if (entity.isEmpty()) return Optional.empty();
        return this.interestDataAccessMapper.toRoot(entity.get());
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


}
