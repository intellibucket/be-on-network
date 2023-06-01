package az.rock.auth.domain.presentation.context;

import az.rock.lib.domain.id.UserID;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Profile({"local"})
@Component
public class TestSecurityContextHolder implements AbstractSecurityContextHolder{
    public UserID currentUser() {
        return UserID.of(UUID.fromString("476143fe-c158-4473-a62c-a1cd31a91583"));
    }
}
