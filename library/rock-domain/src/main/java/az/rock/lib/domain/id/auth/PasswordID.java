package az.rock.lib.domain.id.auth;

import az.rock.lib.domain.RootID;
import az.rock.lib.domain.id.IdReference;

import java.util.UUID;

public class PasswordID extends RootID<UUID> implements IdReference<UUID> {
    protected PasswordID(UUID value) {
        super(value);
    }

    @Override
    public UUID getAbsoluteID() {
        return super.getRootID();
    }

    public static PasswordID of(UUID value){
        return new PasswordID(value);
    }

    public static PasswordID of(){
        return new PasswordID(UUID.randomUUID());
    }
}
