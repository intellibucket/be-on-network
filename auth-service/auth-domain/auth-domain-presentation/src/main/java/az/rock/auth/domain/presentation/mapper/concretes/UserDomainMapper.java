package az.rock.auth.domain.presentation.mapper.concretes;

import az.rock.auth.domain.presentation.dto.request.CreateUserCommand;
import az.rock.auth.domain.presentation.mapper.abstracts.*;
import az.rock.flyjob.auth.model.root.RoleRoot;
import az.rock.flyjob.auth.model.root.user.UserRoot;
import az.rock.lib.domain.id.auth.*;
import az.rock.lib.util.StringUtils;
import az.rock.lib.valueObject.*;
import org.springframework.stereotype.Component;

import java.util.Locale;
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


    @Override
    public UserRoot registrationUserRoot(RoleRoot roleRoot, CreateUserCommand createUserCommand) {
        var userId = UserID.of(UUID.randomUUID());
        var emailRoot = this.emailDomainMapper.toNewEmailRoot(userId,createUserCommand.getEmail());
        var passwordRoot = this.passwordDomainMapper.generatePasswordRoot(userId,createUserCommand.getPassword());
        var detailRoot = this.detailDomainMapper.toNewDetailRoot(userId,roleRoot,createUserCommand);
        var freeAccountsPlan = this.accountPlanDomainMapper.freeAccountPlan(userId);
        var userSettingsRoot = this.userSettingsDomainMapper.defaultUserSettingsRoot(userId);
        return UserRoot.Builder
                .builder()
                .id(userId)
                .version(Version.ONE)
                .processStatus(ProcessStatus.ON_WAITING)
                .rowStatus(RowStatus.ACTIVE)
                .accessModifier(AccessModifier.PUBLIC)
                .userType(UserType.of(roleRoot.getName()))
                .key(UUID.randomUUID())
                .firstName(StringUtils.capitalize(createUserCommand.getFirstName()))
                .lastName(StringUtils.capitalize(createUserCommand.getLastName()))
                .username(createUserCommand.getUsername().toLowerCase(Locale.ROOT))
                .timezone(TimeZoneID.Prototype.ASIA_BAKU)
                .gender(createUserCommand.getGender())
                .password(passwordRoot)
                .email(emailRoot)
                .detail(detailRoot)
                .accountPlan(freeAccountsPlan)
                .userSettings(userSettingsRoot)
                .build();
    }
}
