package az.rock.auth.domain.presentation.mapper.abstracts;

import az.rock.flyjob.auth.root.detail.DetailRoot;
import az.rock.flyjob.auth.root.user.UserRoot;

public interface AbstractDetailDomainMapper {
    DetailRoot toNewDetailRoot(UserRoot userRoot);
}
