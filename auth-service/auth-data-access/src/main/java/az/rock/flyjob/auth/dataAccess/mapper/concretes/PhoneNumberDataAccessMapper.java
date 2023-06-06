package az.rock.flyjob.auth.dataAccess.mapper.concretes;

import az.rock.flyjob.auth.dataAccess.entity.user.PhoneNumberEntity;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractPhoneNumberDataAccessMapper;
import az.rock.flyjob.auth.root.user.PhoneNumberRoot;
import az.rock.lib.domain.id.PhoneNumberID;
import az.rock.lib.util.GDateTime;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PhoneNumberDataAccessMapper implements AbstractPhoneNumberDataAccessMapper<PhoneNumberEntity, PhoneNumberRoot> {
    @Override
    public Optional<PhoneNumberRoot> toRoot(PhoneNumberEntity entity) {
        var optionalEntity = Optional.ofNullable(entity);
        if (optionalEntity.isEmpty()) return Optional.empty();
        return Optional.of(PhoneNumberRoot.Builder
                .builder()
                .uuid(PhoneNumberID.of(entity.getUuid()))
                .version(entity.getVersion())
                .rowStatus(entity.getRowStatus())
                .processStatus(entity.getProcessStatus())
                .createdDate(GDateTime.toZonedDateTime(entity.getCreatedDate()))
                .modificationDate(GDateTime.toZonedDateTime(entity.getLastModifiedDate()))
                .countryCode(entity.getCountryCode())
                .phoneNumber(entity.getPhoneNumber())
                .type(entity.getType())
                .isEnableSmsNotification(entity.getIsEnableSmsNotification())
                .isEnableWhatsappNotification(entity.getIsEnableWhatsappNotification())
                .isPrimary(entity.getIsPrimary())
                .isVerified(entity.getIsVerified())
                .verificationCode(entity.getVerificationCode())
                .verificationCodeExpireDate(GDateTime.toZonedDateTime(entity.getVerificationCodeExpireDate()))
                .verificationCodeSendDate(GDateTime.toZonedDateTime(entity.getVerificationCodeSendDate()))
                .verificationCodeSendCount(entity.getVerificationCodeSendCount())
                .build());
    }

    @Override
    public Optional<PhoneNumberEntity> toEntity(PhoneNumberRoot root) {
        var optionalRoot = Optional.ofNullable(root);
        if (optionalRoot.isEmpty()) return Optional.empty();
        return Optional.of(PhoneNumberEntity.Builder
                .builder()
                .uuid(root.getUUID().getId())
                .version(root.getVersion().value())
                .rowStatus(root.getRowStatus())
                .processStatus(root.getProcessStatus())
                .countryCode(root.getCountryCode())
                .phoneNumber(root.getPhoneNumber())
                .type(root.getType())
                .isEnableSmsNotification(root.getEnableSmsNotification())
                .isEnableWhatsappNotification(root.getEnableWhatsappNotification())
                .isPrimary(root.getPrimary())
                .isVerified(root.getVerified())
                .verificationCode(root.getVerificationCode())
                .verificationCodeExpireDate(GDateTime.toTimestamp(root.getVerificationCodeExpireDate()))
                .verificationCodeSendDate(GDateTime.toTimestamp(root.getVerificationCodeSendDate()))
                .verificationCodeSendCount(root.getVerificationCodeSendCount())
                .build());
    }

    @Override
    public Optional<PhoneNumberEntity> toNewEntity(PhoneNumberRoot root) {
        var optionalRoot = Optional.ofNullable(root);
        if (optionalRoot.isEmpty()) return Optional.empty();
        return Optional.of(PhoneNumberEntity.Builder
                .builder()
                .uuid(root.getUUID().getId())
                .version(root.getVersion().value())
                .rowStatus(root.getRowStatus())
                .processStatus(root.getProcessStatus())
                .countryCode(root.getCountryCode())
                .phoneNumber(root.getPhoneNumber())
                .type(root.getType())
                .isEnableSmsNotification(root.getEnableSmsNotification())
                .isEnableWhatsappNotification(root.getEnableWhatsappNotification())
                .isPrimary(root.getPrimary())
                .isVerified(root.getVerified())
                .verificationCode(root.getVerificationCode())
                .verificationCodeExpireDate(GDateTime.toTimestamp(root.getVerificationCodeExpireDate()))
                .verificationCodeSendDate(GDateTime.toTimestamp(root.getVerificationCodeSendDate()))
                .verificationCodeSendCount(root.getVerificationCodeSendCount())
                .build());
    }
}
