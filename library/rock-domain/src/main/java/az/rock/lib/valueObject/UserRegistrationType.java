package az.rock.lib.valueObject;

import az.rock.lib.annotation.ValueObject;
import az.rock.lib.domain.id.auth.RoleID;

@ValueObject
public enum UserRegistrationType {
    JOB_SEEKER(UserType.JOB_SEEKER),COMPANY(UserType.COMPANY);

    private final UserType type;

    private RoleID roleID;
    UserRegistrationType(UserType type) {
        this.type = type;
    }

    public UserType getType() {
        return type;
    }

    public RoleID getRoleID() {
        return roleID;
    }

    public void setRoleID(RoleID roleID) {
        this.roleID = roleID;
    }
}
