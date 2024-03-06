package az.rock.lib.domain.id.replica;

import az.rock.lib.domain.RootID;
import az.rock.lib.domain.id.IdReference;

import java.util.UUID;

public class LanguageID extends RootID<UUID>  implements IdReference<UUID> {
    protected LanguageID(UUID value) {
        super(value);
    }
    @Override
    public UUID getAbsoluteID() {
        return super.getRootID();
    }
}
