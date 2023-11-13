package az.rock.lib.valueObject;

import az.rock.lib.annotation.ValueObject;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Arrays;

@ValueObject
public enum AccessModifier {
    PUBLIC(0),
    AUTHENTICATED(1),
    ONLY_FOLLOWERS_AND_NETWORK(2),
    ONLY_NETWORK(3),
    PRIVATE(4),
    UNKNOWN(5);
    private final Integer senstivity;
    private
    AccessModifier(Integer senstivity) {
        this.senstivity = senstivity;
    }

    @JsonIgnore
    public Integer getSenstivity() {
        return senstivity;
    }

    public static AccessModifier find(Integer senstivity) {
        return Arrays.stream(AccessModifier.values())
                .filter(accessModifier -> accessModifier.getSenstivity().equals(senstivity))
                .findFirst()
                .orElse(UNKNOWN);
    }

    @JsonIgnore
    public boolean isPublic() {
        return this == PUBLIC;
    }

    @JsonIgnore
    public boolean isAuthenticated() {
        return this == AUTHENTICATED;
    }

    @JsonIgnore
    public boolean isOnlyNetwork() {
        return this == ONLY_NETWORK;
    }

    @JsonIgnore
    public boolean isOnlyFollowersAndNetworks() {
        return this == ONLY_FOLLOWERS_AND_NETWORK;
    }

    @JsonIgnore
    public boolean isPrivate() {
        return this == PRIVATE;
    }

    @JsonIgnore
    public boolean isUnknown() {
        return this == UNKNOWN;
    }


}
