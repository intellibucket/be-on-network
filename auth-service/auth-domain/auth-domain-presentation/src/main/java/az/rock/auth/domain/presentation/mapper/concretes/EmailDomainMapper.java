package az.rock.auth.domain.presentation.mapper.concretes;

import az.rock.auth.domain.presentation.dto.request.EmailChangeRequest;
import az.rock.auth.domain.presentation.dto.request.EmailCreateRequest;
import az.rock.auth.domain.presentation.mapper.abstracts.AbstractEmailDomainMapper;
import az.rock.flyjob.auth.root.user.EmailRoot;
import az.rock.lib.domain.id.auth.EmailID;
import az.rock.lib.domain.id.auth.UserID;
import az.rock.lib.valueObject.EmailType;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.Version;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.UUID;
@Component
public class EmailDomainMapper implements AbstractEmailDomainMapper {
    @Override
    public EmailRoot toNewEmailRoot(UserID userID,String email) {
        return EmailRoot.Builder
                .builder()
                .uuid(EmailID.of(UUID.randomUUID()))
                .version(Version.ONE)
                .processStatus(ProcessStatus.COMPLETED)
                .rowStatus(RowStatus.ACTIVE)
                .user(userID)
                .type(EmailType.PERSONAL)
                .email(email)
                .isEnableNotification(Boolean.FALSE)
                .isPrimary(Boolean.TRUE)
                .isVerified(Boolean.FALSE)
                .verificationCodeSendCount(BigInteger.ZERO)
                .isSubscribedPromotions(Boolean.FALSE)
                .build();
    }

    @Override
    public EmailRoot toNewEmailRoot(UserID userID,EmailCreateRequest emailCreateRequest) {
        return  EmailRoot.Builder
                .builder()
                .uuid(EmailID.of(UUID.randomUUID()))
                .version(Version.ONE)
                .processStatus(ProcessStatus.COMPLETED)
                .rowStatus(RowStatus.ACTIVE)
                .user(userID)
                .type(emailCreateRequest.getType())
                .email(emailCreateRequest.getEmail())
                .isEnableNotification(Boolean.FALSE)
                .isPrimary(Boolean.FALSE)
                .isVerified(Boolean.FALSE)
                .verificationCodeSendCount(BigInteger.ZERO)
                .isSubscribedPromotions(Boolean.FALSE)
                .build();
    }

    @Override
    public EmailRoot mapToEmailRoot(EmailRoot oldEmail , EmailChangeRequest emailChangeRequest) {
        return EmailRoot.Builder
                .builder()
                .uuid(oldEmail.getRootID())
                .version(oldEmail.getVersion())
                .processStatus(ProcessStatus.COMPLETED)
                .rowStatus(RowStatus.ACTIVE)
                .user(oldEmail.getUserId())
                .type(emailChangeRequest.getType())
                .email(emailChangeRequest.getEmail())
                .isEnableNotification(oldEmail.isEnableNotification())
                .isPrimary(oldEmail.isPrimary())
                .isVerified(Boolean.FALSE)
                .verificationCodeSendCount(BigInteger.ZERO)
                .isSubscribedPromotions(oldEmail.isSubscribedPromotions())
                .build();
    }
}
