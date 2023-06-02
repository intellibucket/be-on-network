package az.rock.auth.domain.presentation.dto.response;

import az.rock.flyjob.auth.root.user.EmailRoot;
import az.rock.lib.domain.id.UserID;
import az.rock.lib.valueObject.EmailType;
import lombok.Getter;

import java.util.UUID;

public record EmailModelResponse(UUID uuid,
                                 UUID userID,
                                 EmailType type,
                                 String email,
                                 Boolean isEnableNotification,
                                 Boolean isPrimary,
                                 Boolean isVerified,
                                 Boolean isSubscribedPromotions) {
    private EmailModelResponse(EmailRoot root) {
        this(root.getUUID().getId(), root.getUserId().getId(), root.getType(), root.getEmail(), root.isEnableNotification(),
                root.isPrimary(), root.isVerified(), root.isSubscribedPromotions());
    }

    public static EmailModelResponse of(EmailRoot root) {
        return new EmailModelResponse(root);
    }
}
