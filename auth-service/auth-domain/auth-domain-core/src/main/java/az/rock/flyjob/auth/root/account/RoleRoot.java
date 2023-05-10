package az.rock.flyjob.auth.root.account;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.RoleID;
import az.rock.lib.valueObject.DataStatus;
import az.rock.lib.valueObject.ProcessStatus;

import java.time.ZonedDateTime;

public class RoleRoot extends AggregateRoot<RoleID> {

    private final AccountRoot account;
    private final String name;
    private final String description;
    public RoleRoot(RoleID roleID,
                    Long version,
                    ProcessStatus processStatus,
                    DataStatus dataStatus,
                    ZonedDateTime createdDate,
                    ZonedDateTime modificationDate,
                    AccountRoot account,
                    String name,
                    String description) {
        super(roleID, version, processStatus, dataStatus, createdDate, modificationDate);
        this.account = account;
        this.name = name;
        this.description = description;
    }


}
