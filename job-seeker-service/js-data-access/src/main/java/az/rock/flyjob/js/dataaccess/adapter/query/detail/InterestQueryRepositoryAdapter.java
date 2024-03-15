package az.rock.flyjob.js.dataaccess.adapter.query.detail;

import az.rock.flyjob.js.dataaccess.mapper.abstracts.AbstractInterestDataAccessMapper;
import az.rock.flyjob.js.dataaccess.repository.abstracts.query.batis.AbstractInterestQueryBatisRepository;
import az.rock.flyjob.js.dataaccess.repository.abstracts.query.jpa.AbstractInterestQueryJPARepository;
import az.rock.flyjob.js.domain.core.root.detail.InterestRoot;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.AnyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.simple.SimpleAnyInterestResponseModel;
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

@Component
public class InterestQueryRepositoryAdapter implements AbstractInterestQueryRepositoryAdapter {

    private final AbstractInterestQueryBatisRepository batisRepository;
    private final AbstractInterestQueryJPARepository repository;

    private final AbstractInterestDataAccessMapper interestDataAccessMapper;

    public InterestQueryRepositoryAdapter(AbstractInterestQueryBatisRepository batisRepository, AbstractInterestQueryJPARepository companyProfileQueryJPARepository,
                                          @Qualifier("interestDataAccessMapper") AbstractInterestDataAccessMapper companyProfileDataAccessMapper) {
        this.batisRepository = batisRepository;
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
        var entity = repository.findById(rootId);
        if(entity.isEmpty()) return Optional.empty();
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

    @Override
    public Optional<AnyInterestResponseModel> findAntById(UUID resumeId, UUID interestId, List<AccessModifier> modifier) {
        return Optional.ofNullable(
                this.batisRepository.findAnyInterestById(resumeId,interestId,modifier).get()
        );

    }

    @Override
    public List<AnyInterestResponseModel> findAllAnyInterests(UUID targetResumeId,
                                                              SimplePageableRequest pageable,
                                                              List<AccessModifier> modifier) {
        var allAnyInterests = this.batisRepository.findAllAnyInterests(targetResumeId, modifier, pageable);
        if(!allAnyInterests.isEmpty()){
            return allAnyInterests;
        }else return List.of();

    }

    @Override
    public List<SimpleAnyInterestResponseModel> findAllAnySimpleInterest(UUID targetResumeId,SimplePageableRequest pageable,List<AccessModifier> modifier) {
        var allAnySimpleInterests = this.batisRepository.findAllAnySimpleInterests(targetResumeId, modifier, pageable);
        if(!allAnySimpleInterests.isEmpty()){
            return allAnySimpleInterests;
        }return List.of();

    }




}
