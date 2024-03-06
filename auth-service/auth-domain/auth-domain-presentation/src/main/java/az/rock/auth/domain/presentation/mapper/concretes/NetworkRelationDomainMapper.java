package az.rock.auth.domain.presentation.mapper.concretes;

import az.rock.auth.domain.presentation.mapper.abstracts.AbstractNetworkRelationDomainMapper;
import az.rock.flyjob.auth.model.root.network.NetworkRelationRoot;
import az.rock.lib.domain.id.auth.NetworkID;
import az.rock.lib.domain.id.auth.UserID;
import az.rock.lib.valueObject.*;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class NetworkRelationDomainMapper implements AbstractNetworkRelationDomainMapper {
    @Override
    public NetworkRelationRoot toNewNetworkRelationRoot(UserID userID, UserID targetUserID) {
        return NetworkRelationRoot.Builder
                .builder()
                .networkID(NetworkID.of(UUID.randomUUID()))
                .version(Version.ONE)
                .processStatus(ProcessStatus.COMPLETED)
                .rowStatus(RowStatus.ACTIVE)
                .requestOwnerId(userID.getAbsoluteID())
                .requestTargetId(targetUserID.getAbsoluteID())
                .networkStatus(NetworkStatus.PENDING)
                .blockReasonStatus(BlockReasonStatus.UNKNOWN)
                .build();
    }


}
