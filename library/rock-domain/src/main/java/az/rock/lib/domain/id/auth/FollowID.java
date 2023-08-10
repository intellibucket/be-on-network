package az.rock.lib.domain.id.auth;

import az.rock.lib.domain.RootID;
import az.rock.lib.domain.id.IdReference;

import java.util.UUID;

public class FollowID  extends RootID<UUID> implements IdReference<UUID> {
    protected FollowID(UUID value) {
        super(value);
    }

    public static FollowID of(UUID value) {
        return new FollowID(value);
    }

    @Override
    public UUID getAbsoluteID() {
        return super.getRootID();
    }
}
