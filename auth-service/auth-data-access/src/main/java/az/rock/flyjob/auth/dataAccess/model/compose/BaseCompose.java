package az.rock.flyjob.auth.dataAccess.model.compose;

import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import com.intellibucket.lib.fj.dataaccess.annotations.Compose;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Compose
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseCompose {
    private UUID uuid;

    private Long version;

    private ProcessStatus processStatus;

    private RowStatus rowStatus;

    private Timestamp createdDate;

    private Timestamp lastModifiedDate;
}
