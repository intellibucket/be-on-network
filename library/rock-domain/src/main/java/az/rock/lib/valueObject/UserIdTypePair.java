package az.rock.lib.valueObject;

import az.rock.lib.annotation.ValueObject;
import az.rock.lib.domain.id.auth.*;

@ValueObject
public class UserIdTypePair {

    private final UserID userID;

    private final UserType userType;

    public UserIdTypePair(UserID userID, UserType userType){
        this.userID = userID;
        this.userType = userType;
    }

    public UserID getUserID() {
        return userID;
    }

    public UserType getUserType(){
        return userType;
    }
}
