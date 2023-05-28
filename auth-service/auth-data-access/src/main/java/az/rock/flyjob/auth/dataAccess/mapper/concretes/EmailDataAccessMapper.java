package az.rock.flyjob.auth.dataAccess.mapper.concretes;

import az.rock.flyjob.auth.dataAccess.entity.user.EmailEntity;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractEmailDataAccessMapper;
import az.rock.flyjob.auth.root.user.EmailRoot;
import az.rock.lib.util.GDateTime;
import org.springframework.stereotype.Component;

@Component
public class EmailDataAccessMapper  implements AbstractEmailDataAccessMapper<EmailEntity, EmailRoot> {
    @Override
    public EmailRoot toRoot(EmailEntity entity) {
        return null;
    }

    @Override
    public EmailEntity toEntity(EmailRoot root) {
        return null;
    }

    @Override
    public EmailEntity toNewEntity(EmailRoot root) {
        return EmailEntity.Builder
                .builder()
                .uuid(root.getUUID().getId())
                .processStatus(root.getProcessStatus())
                .rowStatus(root.getRowStatus())
                .version(root.getVersion().value())
                .type(root.getType())
                .email(root.getEmail())
                .isEnableNotification(root.isEnableNotification())
                .isPrimary(root.isPrimary())
                .isVerified(root.isVerified())
                .verificationCode(root.getVerificationCode())
                .verificationCodeExpireDate(GDateTime.toTimestamp(root.getVerificationCodeExpireDate()))
                .verificationCodeSendDate(GDateTime.toTimestamp(root.getVerificationCodeSendDate()))
                .verificationCodeSendCount(root.getVerificationCodeSendCount())
                .isSubscribedPromotions(root.isSubscribedPromotions())
                .subscribedDate(GDateTime.toTimestamp(root.getSubscribedDate()))
                .build();
    }
}

