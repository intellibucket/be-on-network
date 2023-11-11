package az.rock.flyjob.auth.dataAccess.model.record;

import az.rock.lib.valueObject.UserType;
import com.intellibucket.lib.fj.dataaccess.annotations.QueryRecord;
import lombok.Data;

import java.math.BigInteger;
import java.util.UUID;

@Data
@QueryRecord
public class UserProfileRecord {
    private UUID userId;
    private String firstName;
    private String lastName;
    private String username;
    private String title;
    private UserType userType;
    private String timezone;
    private BigInteger followCount;
    private BigInteger networkCount;
}
