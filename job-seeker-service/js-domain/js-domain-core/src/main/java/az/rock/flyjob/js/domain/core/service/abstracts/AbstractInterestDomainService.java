package az.rock.flyjob.js.domain.core.service.abstracts;

import az.rock.flyjob.js.domain.core.exception.InterestNameIsExist;
import az.rock.flyjob.js.domain.core.root.detail.InterestRoot;

import java.util.List;

public interface AbstractInterestDomainService {
    InterestRoot validateInterestName(List<InterestRoot> savedPhoneNumbers, InterestRoot changedInterest) throws InterestNameIsExist;



}
