package az.rock.flyjob.js.domain.core.service.concretes;

import az.rock.flyjob.js.domain.core.exception.InterestNameIsExist;
import az.rock.flyjob.js.domain.core.root.detail.InterestRoot;
import az.rock.flyjob.js.domain.core.service.abstracts.AbstractInterestDomainService;

import java.util.List;

public class InterestDomainService implements AbstractInterestDomainService {
    @Override
    public InterestRoot validateInterestName(List<InterestRoot> savedPhoneNumbers, InterestRoot changedInterest) throws InterestNameIsExist {
        if (savedPhoneNumbers.stream().anyMatch(item -> item
                .getName()
                .equals(changedInterest.getName()))) {
            throw new InterestNameIsExist("Interest Name is exist");
        }
        return changedInterest;
    }
}
