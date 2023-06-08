package az.rock.lib.domain.id;

import az.rock.lib.domain.RootID;

import java.util.UUID;

public class PhoneNumberID  extends RootID<UUID> implements IdReference<UUID> {
    protected PhoneNumberID(UUID value) {
        super(value);
    }

    @Override
    public UUID getAbsoluteID() {
        return super.getUUID();
    }

    public static PhoneNumberID of(UUID value) {
        return new PhoneNumberID(value);
    }
}
