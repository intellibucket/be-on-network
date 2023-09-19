package az.rock.auth.domain.presentation.ports.input.service.command.concretes;

import az.rock.auth.domain.presentation.handler.abstracts.AbstractBlockRelationCommandHandler;
import az.rock.auth.domain.presentation.ports.input.service.command.abstracts.AbstractBlockRelationCommandDomainPresentationService;
import az.rock.auth.domain.presentation.ports.output.publisher.AbstractBlockRelationMessagePublisher;
import az.rock.lib.domain.id.auth.UserID;
import com.intellibukcet.lib.payload.event.create.block.BlockRelationEvent;
import com.intellibukcet.lib.payload.event.create.block.UnblockRelationEvent;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BlockRelationCommandDomainPresentationService implements AbstractBlockRelationCommandDomainPresentationService {

    private final AbstractBlockRelationMessagePublisher blockRelationMessagePublisher;

    private final AbstractBlockRelationCommandHandler blockRelationCommandHandler;

    public BlockRelationCommandDomainPresentationService(AbstractBlockRelationMessagePublisher blockRelationMessagePublisher,
                                                         AbstractBlockRelationCommandHandler blockRelationCommandHandler) {
        this.blockRelationMessagePublisher = blockRelationMessagePublisher;
        this.blockRelationCommandHandler = blockRelationCommandHandler;
    }

    @Override
    public void block(UUID targetUserID) {
        BlockRelationEvent blockRelationEvent = this.blockRelationCommandHandler.handleBlock(targetUserID);
    }

    @Override
    public void unblock(UUID userID) {
        UnblockRelationEvent unBlockRelationEvent = this.blockRelationCommandHandler.handleUnblock(userID);

    }
}
