package az.rock.auth.domain.presentation.mapper.abstracts;

import az.rock.flyjob.auth.root.DetailRoot;
import az.rock.flyjob.auth.root.UserRoot;

public interface AbstractDetailDomainMapper {
    DetailRoot toNewDetailRoot(UserRoot userRoot);
}
