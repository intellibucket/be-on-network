package az.rock.flyjob.auth.root.user;

import az.rock.lib.domain.id.auth.PasswordID;
import az.rock.lib.domain.id.auth.UserID;

public class PasswordProxyRoot extends PasswordRoot {

    protected PasswordProxyRoot(PasswordID passwordID, UserID userID, String salt, String hash) {
        super(passwordID, userID, salt, hash);
    }

    public static PasswordProxyRoot of(PasswordID passwordID,UserID userID) {
        return new PasswordProxyRoot(passwordID,userID,null,null);
    }

    public static PasswordProxyRoot of(PasswordRoot passwordRoot) {
        return PasswordProxyRoot.of(passwordRoot.getRootID(),passwordRoot.getUserID());
    }

    @Override
    public String toString() {
        return "PasswordProxyRoot{" +
                "passwordID= " + super.getRootID().toString() + " ," +
                "userID= " + super.getUserID().toString() + " }";
    }
}
