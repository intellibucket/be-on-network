package az.rock.flyjob.js.dataaccess.adapter.query.detail;

import az.rock.flyjob.js.dataaccess.mapper.abstracts.AbstractInterestDataAccessMapper;
import az.rock.flyjob.js.dataaccess.model.batis.model.InterestCompose;
import az.rock.flyjob.js.dataaccess.model.batis.model.InterestComposeExample;
import az.rock.flyjob.js.dataaccess.repository.abstracts.query.batis.InterestBatisRepository;
import az.rock.flyjob.js.dataaccess.repository.abstracts.query.jpa.AbstractInterestQueryJPARepository;
import az.rock.flyjob.js.domain.core.exception.interest.InterestOverLimit;
import az.rock.flyjob.js.domain.core.root.detail.InterestRoot;
import az.rock.flyjob.js.domain.presentation.dto.criteria.InterestCriteria;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.AnyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.simple.SimpleAnyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.query.AbstractInterestQueryRepositoryAdapter;
import az.rock.lib.domain.id.js.InterestID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.SimplePageableRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;


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
        if (interestCompose.size() == 1) {
            var root = this.interestDataAccessMapper.toRoot(interestCompose.get(0));
            return Optional.ofNullable(AnyInterestResponseModel.of(root.get()));
        }
        return Optional.empty();
    }

    @Override
    public List<SimpleAnyInterestResponseModel> fetchAllAnySimpleInterest(InterestCriteria criteria, SimplePageableRequest request) throws InterestOverLimit {
        var interestComposeExample = InterestComposeExample.of(criteria);
        var interestCount = this.batisRepository.countByExample(interestComposeExample);

        interestComposeExample.addPageable(InterestComposeExample.Pageable.createPageable(request, interestCount));

        final List<InterestCompose> interestComposes = this.batisRepository.selectByExample(interestComposeExample);
        if (!interestComposes.isEmpty()) {
            return interestComposes.stream().map(interestDataAccessMapper::toRoot)
                    .filter(Optional::isPresent)
                    .toList()
                    .stream()
                    .map(root -> SimpleAnyInterestResponseModel.of(root.get())).collect(Collectors.toList());
        }
        return List.of();

    }

    @Override
    public List<AnyInterestResponseModel> fetchAllAnyInterests(InterestCriteria criteria, SimplePageableRequest request) throws InterestOverLimit {
        InterestComposeExample interestComposeExample = InterestComposeExample.of(criteria);
        var interestCount = this.batisRepository.countByExample(interestComposeExample);
        interestComposeExample.addPageable(InterestComposeExample.Pageable.createPageable(request, interestCount));

        final List<InterestCompose> interestComposes = this.batisRepository.selectByExample(interestComposeExample);
        if (!interestComposes.isEmpty()) {
            return interestComposes.stream().map(interestDataAccessMapper::toRoot)
                    .filter(Optional::isPresent)
                    .toList()
                    .stream()
                    .map(root -> AnyInterestResponseModel.of(root.get())).collect(Collectors.toList());
        }
        return List.of();
    }


    @Override
    public Optional<InterestRoot> findMyInterestById(InterestCriteria criteria) {
        InterestComposeExample interestComposeExample = InterestComposeExample.of(criteria);
        interestComposeExample.setOrderByClause("order_number");
        return batisRepository.selectByExample(interestComposeExample)
                .stream()
                .findFirst()
                .map(interestDataAccessMapper::toRoot)
                .flatMap(Function.identity());
    }

    @Override
    public List<InterestRoot> queryAllMyInterests(InterestCriteria criteria,SimplePageableRequest pageableRequest) {
        InterestComposeExample interestComposeExample = InterestComposeExample.of(criteria);
        interestComposeExample.setOrderByClause("order_number");
        return batisRepository.selectByExample(interestComposeExample)
                .stream()
                .map(interestDataAccessMapper::toRoot)
                .flatMap(Optional::stream)
                .toList();
    }

    @Override
    public List<InterestRoot> queryAllMySimpleInterests(InterestCriteria criteria,SimplePageableRequest pageableRequest) {
        InterestComposeExample interestComposeExample = InterestComposeExample.of(criteria);
        interestComposeExample.setOrderByClause("order_number");
        return batisRepository.selectByExample(interestComposeExample)
                .stream()
                .map(interestDataAccessMapper::toRoot)
                .flatMap(Optional::stream)
                .toList();
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
