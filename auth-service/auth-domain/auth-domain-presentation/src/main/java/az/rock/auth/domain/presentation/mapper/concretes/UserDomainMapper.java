package az.rock.auth.domain.presentation.mapper.concretes;

import az.rock.auth.domain.presentation.dto.request.CreateUserCommand;
import az.rock.auth.domain.presentation.dto.response.CreateUserResponse;
import az.rock.auth.domain.presentation.mapper.abstracts.*;
import az.rock.flyjob.auth.root.user.UserRoot;
import az.rock.lib.domain.id.UserID;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.TimeZoneID;
import az.rock.lib.valueObject.Version;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserDomainMapper implements AbstractUserDomainMapper {

    private final AbstractPasswordDomainMapper passwordDomainMapper;

    private final AbstractDetailDomainMapper detailDomainMapper;

    private final AbstractEmailDomainMapper emailDomainMapper;

    private final AbstractAccountPlanDomainMapper accountPlanDomainMapper;

    private final AbstractDeviceDomainMapper deviceDomainMapper;

    private final AbstractUserSettingsDomainMapper userSettingsDomainMapper;


    public UserDomainMapper(AbstractPasswordDomainMapper passwordDomainMapper,
                            AbstractDetailDomainMapper detailDomainMapper,
                            AbstractEmailDomainMapper emailDomainMapper,
                            AbstractAccountPlanDomainMapper accountPlanDomainMapper,
                            AbstractDeviceDomainMapper deviceDomainMapper,
                            AbstractUserSettingsDomainMapper userSettingsDomainMapper) {
        this.passwordDomainMapper = passwordDomainMapper;
        this.detailDomainMapper = detailDomainMapper;
        this.emailDomainMapper = emailDomainMapper;
        this.accountPlanDomainMapper = accountPlanDomainMapper;
        this.deviceDomainMapper = deviceDomainMapper;
        this.userSettingsDomainMapper = userSettingsDomainMapper;
    }

    public CreateUserResponse toCreateUserResponse(UserRoot userRoot) {
        return new CreateUserResponse(userRoot.getUUID().getId(),userRoot.getFirstName(), userRoot.getUsername(), userRoot.getAbsoluteEmail());
    }

    @Override
    public UserRoot registrationUserRoot(CreateUserCommand createUserCommand) {
        var userId = UserID.of(UUID.randomUUID());
        var emailRoot = this.emailDomainMapper.toNewEmailRoot(userId,createUserCommand.getEmail());
        var passwordRoot = this.passwordDomainMapper.generatePasswordRoot(userId,createUserCommand.getPassword());
        var detailRoot = this.detailDomainMapper.toNewDetailRoot(userId,createUserCommand);
        var freeAccountsPlan = this.accountPlanDomainMapper.freeAccountPlan(userId);
        var deviceRoot = this.deviceDomainMapper.registrationDevice(userId);
        var userSettingsRoot = this.userSettingsDomainMapper.defaultUserSettingsRoot(userId);
        var userRoot =  UserRoot.Builder
                .builder()
                .id(userId)
                .version(Version.ONE)
                .processStatus(ProcessStatus.ON_WAITING)
                .rowStatus(RowStatus.ACTIVE)
                .key(UUID.randomUUID())
                .firstName(createUserCommand.getFirstName())
                .lastName(createUserCommand.getLastName())
                .username(createUserCommand.getUsername())
                .timezone(TimeZoneID.Prototype.ASIA_BAKU)
                .gender(createUserCommand.getGender())
                .password(passwordRoot)
                .email(emailRoot)
                .detail(detailRoot)
                .accountPlan(freeAccountsPlan)
                .userSettings(userSettingsRoot)
                .build();
        return userRoot;
    }
}
