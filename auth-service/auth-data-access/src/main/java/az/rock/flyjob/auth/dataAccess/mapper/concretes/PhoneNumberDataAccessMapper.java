package az.rock.flyjob.auth.dataAccess.mapper.concretes;

import az.rock.flyjob.auth.dataAccess.entity.user.PhoneNumberEntity;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractPhoneNumberDataAccessMapper;
import az.rock.flyjob.auth.root.user.PhoneNumberRoot;
import az.rock.lib.util.GDateTime;
import org.springframework.stereotype.Component;

@Component
public class PhoneNumberDataAccessMapper implements AbstractPhoneNumberDataAccessMapper<PhoneNumberEntity, PhoneNumberRoot> {
    @Override
    public PhoneNumberRoot toRoot(PhoneNumberEntity entity) {
        return null;
    }

    @Override
    public PhoneNumberEntity toEntity(PhoneNumberRoot root) {
        return null;
    }

    @Override
    public PhoneNumberEntity toNewEntity(PhoneNumberRoot root) {
        return PhoneNumberEntity.Builder
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
                .build();
    }
}
