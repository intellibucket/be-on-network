package az.rock.auth.domain.presentation.dto.response;

import az.rock.flyjob.auth.model.root.user.EmailRoot;
import az.rock.lib.valueObject.EmailType;

import java.util.UUID;

public record EmailClientModelResponse(UUID uuid,
                                       UUID userID,
                                       EmailType type,
                                       String email) {
    private EmailClientModelResponse(EmailRoot root) {
        this(root.getRootID().getAbsoluteID(), root.getUserId().getAbsoluteID(), root.getType(), root.getEmail());
    }

    public static EmailClientModelResponse of(EmailRoot root) {
        return new EmailClientModelResponse(root);
    }
}
