package az.rock.auth.domain.presentation.ports.input.util;

import az.rock.lib.valueObject.AccessModifier;

public class AccessResult {
    private final Integer senstivity;

    private AccessResult(Integer senstivity) {
        this.senstivity = senstivity;
    }

    public AccessModifier getAccessModifier(){
        return AccessModifier.find(this.senstivity);
    }

    public Integer getSenstivity() {
        return senstivity;
    }

    public boolean isPublic() {
        return this == Prototype.PUBLIC_ACCESS;
    }

    public boolean isOnlyAuthenticated() {
        return this == Prototype.AUTHENTICATED_ACCESS;
    }

    public boolean isOnlyNetwork() {
        return this == Prototype.NETWORK_ACCESS;
    }

    public boolean isOnlyFollowers() {
        return this == Prototype.FOLLOWERS_ACCESS;
    }

    public boolean isPrivate() {
        return this == Prototype.PRIVATE_ACCESS;
    }

    public boolean isUnknown() {
        return this == Prototype.UNKNOWN_ACCESS;
    }

    public boolean isPublicOrOnlyAuthenticated() {
        return isPublic() || isOnlyAuthenticated();
    }

    public boolean isPublicOrOnlyAuthenticatedOrOnlyNetwork() {
        return isPublic() || isOnlyAuthenticated() || isOnlyNetwork();
    }

    public boolean isPublicOrOnlyAuthenticatedOrOnlyNetworkOrOnlyFollowers() {
        return isPublic() || isOnlyAuthenticated() || isOnlyNetwork() || isOnlyFollowers();
    }

    public static class Prototype{
        public static final AccessResult PUBLIC_ACCESS = new AccessResult(0);
        public static final AccessResult AUTHENTICATED_ACCESS = new AccessResult(1);
        public static final AccessResult FOLLOWERS_ACCESS = new AccessResult(2);
        public static final AccessResult NETWORK_ACCESS = new AccessResult(3);
        public static final AccessResult PRIVATE_ACCESS = new AccessResult(4);
        public static final AccessResult UNKNOWN_ACCESS = new AccessResult(5);
    }
}
