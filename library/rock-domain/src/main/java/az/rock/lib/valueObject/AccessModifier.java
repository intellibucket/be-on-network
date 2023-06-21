package az.rock.lib.valueObject;

import az.rock.lib.annotation.ValueObject;

@ValueObject
public enum AccessModifier {
    PUBLIC,
    ONLY_AUTHENTICATED,
    ONLY_FOLLOWERS,
    ONLY_NETWORK,
    PRIVATE,

    UNKNOWN;

    public boolean isPublic() {
        return this == PUBLIC;
    }

    public boolean isOnlyAuthenticated() {
        return this == ONLY_AUTHENTICATED;
    }

    public boolean isOnlyNetwork() {
        return this == ONLY_NETWORK;
    }

    public boolean isOnlyFollowers() {
        return this == ONLY_FOLLOWERS;
    }

    public boolean isPrivate() {
        return this == PRIVATE;
    }

    public boolean isUnknown() {
        return this == UNKNOWN;
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

    public boolean isPublicOrOnlyAuthenticatedOrOnlyNetworkOrOnlyFollowersOrPrivate() {
        return isPublic() || isOnlyAuthenticated() || isOnlyNetwork() || isOnlyFollowers() || isPrivate();
    }


    public boolean isOnlyAuthenticatedOrOnlyNetwork() {
        return isOnlyAuthenticated() || isOnlyNetwork();
    }

    public boolean isOnlyAuthenticatedOrOnlyNetworkOrOnlyFollowers() {
        return isOnlyAuthenticated() || isOnlyNetwork() || isOnlyFollowers();
    }

    public boolean isOnlyAuthenticatedOrOnlyNetworkOrOnlyFollowersOrPrivate() {
        return isOnlyAuthenticated() || isOnlyNetwork() || isOnlyFollowers() || isPrivate();
    }


    public boolean isOnlyNetworkOrOnlyFollowers() {
        return isOnlyNetwork() || isOnlyFollowers();
    }

    public boolean isOnlyNetworkOrOnlyFollowersOrPrivate() {
        return isOnlyNetwork() || isOnlyFollowers() || isPrivate();
    }

}
