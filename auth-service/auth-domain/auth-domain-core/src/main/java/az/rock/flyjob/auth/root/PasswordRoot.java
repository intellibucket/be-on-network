package az.rock.flyjob.auth.root;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.PasswordID;

public class PasswordRoot extends AggregateRoot<PasswordID>{

    private final UserRoot user;
    private final String salt;
    private final String hash;

    protected PasswordRoot(PasswordID passwordID,
                           UserRoot user,
                           String salt,
                           String hash) {
        super(passwordID);
        this.user = user;
        this.salt = salt;
        this.hash = hash;
    }

    public String getSalt() {
        return salt;
    }

    public String getHash() {
        return hash;
    }

    @Override
    public String toString() {
        return "PasswordRoot{" +
                "user id=" + user.getUUID().getId() +
                '}';
    }
}
