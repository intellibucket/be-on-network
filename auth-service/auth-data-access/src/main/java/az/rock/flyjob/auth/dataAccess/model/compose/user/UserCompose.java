package az.rock.flyjob.auth.dataAccess.model.compose.user;

import az.rock.flyjob.auth.dataAccess.model.compose.BaseCompose;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.Gender;
import az.rock.lib.valueObject.UserType;
import com.intellibucket.lib.fj.dataaccess.annotations.Compose;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Compose
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserCompose extends BaseCompose {

    private AccessModifier accessModifier;

    private UserType userType;

    private UUID key;

    private String firstName;

    private String lastName;

    private String username;

    private String timezone;

    private Gender gender;

    private List<PasswordCompose> passwords;

    private List<EmailCompose> emails;

    private List<PhoneNumberCompose> phoneNumbers;

    private DetailCompose detail;

    private List<AccountPlanCompose> accountPlans;

    private List<DeviceCompose> devices;

    private UserSettingsCompose settings;

}
