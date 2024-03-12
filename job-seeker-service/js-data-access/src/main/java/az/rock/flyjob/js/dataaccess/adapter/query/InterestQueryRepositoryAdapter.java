package az.rock.flyjob.js.dataaccess.adapter.query;

import az.rock.flyjob.js.dataaccess.repository.abstracts.query.batis.AbstractInterestQueryBatisRepository;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.query.AbstractInterestQueryRepositoryAdapter;

import org.springframework.stereotype.Component;

@Component
public class InterestQueryRepositoryAdapter implements AbstractInterestQueryRepositoryAdapter {

    private final AbstractInterestQueryBatisRepository batisRepository;

    public InterestQueryRepositoryAdapter(AbstractInterestQueryBatisRepository batisRepository) {
        this.batisRepository = batisRepository;
    }

}
