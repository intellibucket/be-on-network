package az.rock.flyjob.auth.dataAccess.mapper.concretes;

import az.rock.flyjob.auth.dataAccess.entity.user.EmailEntity;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractEmailDataAccessMapper;
import az.rock.flyjob.auth.root.user.EmailRoot;
import az.rock.lib.domain.id.EmailID;
import az.rock.lib.util.GDateTime;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EmailDataAccessMapper  implements AbstractEmailDataAccessMapper<EmailEntity, EmailRoot> {
    @Override
    public Optional<EmailRoot> toRoot(EmailEntity entity) {
        var optionalEmailEntity = Optional.ofNullable(entity);
        if (optionalEmailEntity.isEmpty()) return Optional.empty();
        return Optional.of(EmailRoot.Builder
                .builder()
                .uuid(EmailID.of(entity.getUuid()))
                .version(entity.getVersion())
                .accessModifier(entity.getAccessModifier())
                .processStatus(entity.getProcessStatus())
                .rowStatus(entity.getRowStatus())
                .type(entity.getType())
                .email(entity.getEmail())
                .isEnableNotification(entity.getIsEnableNotification())
                .isPrimary(entity.getIsPrimary())
                .isVerified(entity.getIsVerified())
                .verificationCode(entity.getVerificationCode())
                .verificationCodeExpireDate(GDateTime.toZonedDateTime(entity.getVerificationCodeExpireDate()))
                .verificationCodeSendDate(GDateTime.toZonedDateTime(entity.getVerificationCodeSendDate()))
                .verificationCodeSendCount(entity.getVerificationCodeSendCount())
                .isSubscribedPromotions(entity.getIsSubscribedPromotions())
                .subscribedDate(GDateTime.toZonedDateTime(entity.getSubscribedDate()))
                .build());
    }

    @Override
    public Optional<EmailEntity> toEntity(EmailRoot root) {
        var optionalEmailRoot = Optional.ofNullable(root);
        if (optionalEmailRoot.isEmpty()) return Optional.empty();
        return Optional.of(EmailEntity.Builder
                .builder()
                .uuid(root.getUUID().getId())
                .processStatus(root.getProcessStatus())
                .rowStatus(root.getRowStatus())
                .version(root.getVersion().value())
                .accessModifier(root.getAccessModifier())
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
                .build());
    }

    @Override
    public Optional<EmailEntity> toNewEntity(EmailRoot root) {
        var optionalEmailRoot = Optional.ofNullable(root);
        if (optionalEmailRoot.isEmpty()) return Optional.empty();
        return Optional.of(EmailEntity.Builder
                .builder()
                .uuid(root.getUUID().getId())
                .processStatus(root.getProcessStatus())
                .rowStatus(root.getRowStatus())
                .version(root.getVersion().value())
                .accessModifier(root.getAccessModifier())
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
                .build());
    }
}

