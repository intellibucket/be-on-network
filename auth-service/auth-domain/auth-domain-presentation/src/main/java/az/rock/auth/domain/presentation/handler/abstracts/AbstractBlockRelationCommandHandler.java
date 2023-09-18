package az.rock.auth.domain.presentation.handler.abstracts;

import az.rock.lib.domain.id.auth.UserID;
import com.intellibukcet.lib.payload.event.create.block.BlockRelationEvent;
import com.intellibukcet.lib.payload.event.create.block.UnblockRelationEvent;

import java.util.UUID;

public interface AbstractBlockRelationCommandHandler {

    BlockRelationEvent handleBlock(UUID targetUserUuid);

    UnblockRelationEvent handleUnblock(UUID userID);
}
