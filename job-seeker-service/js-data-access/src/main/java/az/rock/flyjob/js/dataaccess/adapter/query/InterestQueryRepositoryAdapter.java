package az.rock.flyjob.js.dataaccess.adapter.query;

import az.rock.flyjob.js.dataaccess.repository.abstracts.query.batis.AbstractInterestQueryBatisRepository;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.AnyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.simple.SimpleAnyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.query.AbstractInterestQueryRepositoryAdapter;

import az.rock.lib.valueObject.SimplePageableRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class InterestQueryRepositoryAdapter implements AbstractInterestQueryRepositoryAdapter {

    private final AbstractInterestQueryBatisRepository batisRepository;

    public InterestQueryRepositoryAdapter(AbstractInterestQueryBatisRepository batisRepository) {
        this.batisRepository = batisRepository;
    }

    @Override
    public AnyInterestResponseModel findAnyInterestByResumeId(UUID id) {
        return null;
    }

    @Override
    public List<AnyInterestResponseModel> findAllAnyInterests(SimplePageableRequest pageableRequest) {
        return null;
    }

    @Override
    public List<SimpleAnyInterestResponseModel> findAllAnySimpleInterest(SimplePageableRequest pageableRequest) {
        return null;
    }
}
