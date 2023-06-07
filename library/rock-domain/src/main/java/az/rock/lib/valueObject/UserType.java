package az.rock.lib.valueObject;

import az.rock.lib.annotation.ValueObject;

@ValueObject
public enum UserType {
    GUEST,COMPANY,JOB_SEEKER;

    public String asRoleName() {
        return "ROLE_" + this.name();
    }
}
