package az.rock.auth.domain.presentation.mapper.concretes;

import az.rock.auth.domain.presentation.mapper.abstracts.AbstractDetailDomainMapper;
import az.rock.flyjob.auth.root.DetailRoot;
import az.rock.flyjob.auth.root.user.UserRoot;
import org.springframework.stereotype.Component;

@Component
public class DetailDomainMapper implements AbstractDetailDomainMapper {
    @Override
    public DetailRoot toNewDetailRoot(UserRoot userRoot) {
        return null;
    }
}
