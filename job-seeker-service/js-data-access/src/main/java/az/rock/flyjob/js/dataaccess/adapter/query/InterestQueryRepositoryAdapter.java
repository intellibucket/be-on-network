package az.rock.flyjob.js.dataaccess.adapter.query;

import az.rock.flyjob.js.dataaccess.repository.abstracts.query.batis.AbstractInterestQueryBatisRepository;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.AnyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.simple.SimpleAnyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.query.AbstractInterestQueryRepositoryAdapter;

import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.SimplePageableRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class InterestQueryRepositoryAdapter implements AbstractInterestQueryRepositoryAdapter {

    private final AbstractInterestQueryBatisRepository batisRepository;

    public InterestQueryRepositoryAdapter(AbstractInterestQueryBatisRepository batisRepository) {
        this.batisRepository = batisRepository;
    }

    @Override
    public Optional<AnyInterestResponseModel> findAntById(UUID resumeId, UUID id, List<AccessModifier> modifier) {
        return Optional.ofNullable(
                this.batisRepository.findAnyInterestById(resumeId,id,modifier).get()
        );

    }

    @Override
    public Page<AnyInterestResponseModel> findAllAnyInterests(UUID targetResumeId,
                                                              Pageable pageable,
                                                              List<AccessModifier> modifier) {
        var allAnyInterests = this.batisRepository.findAllAnyInterests(targetResumeId, modifier, pageable);
        if(!allAnyInterests.isEmpty()){
            return allAnyInterests;
        }else return Page.empty();

    }

    @Override
    public Page<SimpleAnyInterestResponseModel> findAllAnySimpleInterest(UUID targetResumeId,Pageable pageable,List<AccessModifier> modifier) {
      var allAnySimpleInterests = this.batisRepository.findAllAnySimpleInterests(targetResumeId, modifier, pageable);
        if(!allAnySimpleInterests.isEmpty()){
            return allAnySimpleInterests;
        }return Page.empty();

    }
}
