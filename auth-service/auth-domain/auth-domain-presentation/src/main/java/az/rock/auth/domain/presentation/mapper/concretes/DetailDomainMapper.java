package az.rock.auth.domain.presentation.mapper.concretes;

import az.rock.auth.domain.presentation.dto.request.CreateUserCommand;
import az.rock.auth.domain.presentation.mapper.abstracts.AbstractDetailDomainMapper;
import az.rock.flyjob.auth.model.root.RoleRoot;
import az.rock.flyjob.auth.model.root.detail.DetailRoot;
import az.rock.lib.domain.id.auth.*;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.Version;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.UUID;

@Component
public class DetailDomainMapper implements AbstractDetailDomainMapper {
    @Override
    public DetailRoot toNewDetailRoot(UserID userID,RoleRoot roleRoot,CreateUserCommand createUserCommand) {
        var detailId = DetailID.of(UUID.randomUUID());
        roleRoot.addDetail(detailId);
        return DetailRoot.Builder
                .builder()
                .detailID(detailId)
                .version(Version.ONE)
                .processStatus(ProcessStatus.COMPLETED)
                .rowStatus(RowStatus.ACTIVE)
                .userID(userID)
                .roles(Set.of(roleRoot))
                .isAccountNonExpired(true)
                .isAccountNonLocked(true)
                .isCredentialsNonExpired(true)
                .isEnabled(true)
                .isDeleted(false)
                .isFrozen(false)
                .build();
    }
}
