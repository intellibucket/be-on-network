package az.rock.lib.valueObject;

import az.rock.lib.annotation.ValueObject;

import java.util.Locale;

@ValueObject
public enum UserType {
    GUEST,COMPANY,JOB_SEEKER;

    public static UserType of(String roleRootName) {
        var splits = roleRootName.split("_", 2);
        var name = splits[splits.length - 1];
        return UserType.valueOf(name);
    }

    public String asRoleName() {
        return "ROLE_" + this.name();
    }

    private Role asRole(String accountType) {
        if (accountType == null || accountType.trim().isEmpty()) {
            return Role.valueOf("ROLE_".concat(this.asRoleName()));
        }
        accountType = accountType.trim().toUpperCase(Locale.ROOT);
        return Role.valueOf("ROLE_".concat(accountType).concat(this.asRoleName()));
    }

    public Role asFreeRole() {
        return this.asRole(null);
    }

    public Role asBasicRole() {
        return this.asRole("BASIC_");
    }

    public Role asUltimateRole() {
        return this.asRole("ULTIMATE_");
    }
}
