package az.rock.lib.valueObject;

import az.rock.lib.annotation.ValueObject;

@ValueObject
public enum Role {
    ROLE_GUEST,
    ROLE_COMPANY,
    ROLE_JOB_SEEKER,
    ROLE_BASIC_JOB_SEEKER,
    ROLE_BASIC_COMPANY,
    ROLE_ULTIMATE_JOB_SEEKER,
    ROLE_ULTIMATE_COMPANY,
    ROLE_SUPER_ADMIN;
}
