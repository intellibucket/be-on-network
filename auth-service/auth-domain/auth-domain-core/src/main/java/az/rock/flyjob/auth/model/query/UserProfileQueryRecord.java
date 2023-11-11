package az.rock.flyjob.auth.model.query;

import az.rock.lib.valueObject.Gender;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.UserType;
import lombok.Data;

import java.math.BigInteger;
import java.util.UUID;

@Data
public class UserProfileQueryRecord {
    private UUID userId;
    private Long version;
    private RowStatus rowStatus;
    private ProcessStatus processStatus;
    private String firstName;
    private String lastName;
    private String username;
    private String title;
    private String biography;
    private Gender gender;
    private UserType userType;
    private String timezone;
    private BigInteger followCount;
    private BigInteger networkCount;
}
