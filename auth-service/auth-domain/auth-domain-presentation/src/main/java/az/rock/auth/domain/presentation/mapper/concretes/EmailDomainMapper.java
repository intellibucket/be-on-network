package az.rock.auth.domain.presentation.mapper.concretes;

import az.rock.auth.domain.presentation.mapper.abstracts.AbstractEmailDomainMapper;
import az.rock.flyjob.auth.root.user.EmailRoot;
import az.rock.lib.domain.id.EmailID;
import az.rock.lib.domain.id.UserID;
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
}
