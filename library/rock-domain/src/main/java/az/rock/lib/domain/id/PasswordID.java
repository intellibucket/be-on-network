package az.rock.lib.domain.id;

import az.rock.lib.domain.RootID;

import java.util.UUID;

public class PasswordID extends RootID<UUID> implements IdReference<UUID>{
    protected PasswordID(UUID value) {
        super(value);
    }

    @Override
    public UUID getAbsoluteID() {
        return super.getUUID();
    }

    public static PasswordID of(UUID value){
        return new PasswordID(value);
    }

    public static PasswordID of(){
        return new PasswordID(UUID.randomUUID());
    }
}
