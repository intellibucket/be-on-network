package az.rock.flyjob.auth.dataAccess.model.compose.user;

import az.rock.flyjob.auth.dataAccess.model.compose.BaseCompose;
import com.intellibucket.lib.fj.dataaccess.annotations.Compose;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Compose
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationLogCompose extends BaseCompose {
    private UUID deviceUUID;
    private UUID deviceToken;
}
