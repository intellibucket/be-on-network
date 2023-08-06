package az.rock.lib.domain.id.js;

import az.rock.lib.domain.RootID;
import az.rock.lib.domain.id.IdReference;

import java.util.UUID;

public class SignatureDeclarationID extends RootID<UUID> implements IdReference<UUID> {

    public static final SignatureDeclarationID NULL = new SignatureDeclarationID(null);
    protected SignatureDeclarationID(UUID value) {
        super(value);
    }

    @Override
    public UUID getAbsoluteID() {
        return super.getRootID();
    }

    public static SignatureDeclarationID of(UUID value){
        return new SignatureDeclarationID(value);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        if (!(o instanceof SignatureDeclarationID)) return false;
        return this.getAbsoluteID().equals(((SignatureDeclarationID)o).getAbsoluteID());
    }
}
