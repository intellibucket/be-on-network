package az.rock.auth.domain.presentation.mapper.concretes;

import az.rock.auth.domain.presentation.mapper.abstracts.AbstractBlockRelationDomainMapper;
import az.rock.flyjob.auth.model.root.network.BlockRelationRoot;
import az.rock.lib.domain.id.BlockID;
import az.rock.lib.valueObject.*;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class BlockRelationDomainMapper implements AbstractBlockRelationDomainMapper {

    @Override
    public BlockRelationRoot toNewBlockRelationRoot(UserIdTypePair currentUserIdAndTypePair, UserIdTypePair targetUserIdAndTypePair) {
        return BlockRelationRoot.Builder
                .builder()
                .uuid(BlockID.of(UUID.randomUUID()))
                .version(Version.ONE)
                .processStatus(ProcessStatus.COMPLETED)
                .rowStatus(RowStatus.ACTIVE)
                .userType(currentUserIdAndTypePair.getUserType())
                .userId(currentUserIdAndTypePair.getUserID().getAbsoluteID())
                .targetUserType(targetUserIdAndTypePair.getUserType())
                .targetUserId(targetUserIdAndTypePair.getUserID().getAbsoluteID())
                .description(null)
                .build();
    }
}
