package az.rock.flyjob.js.domain.presentation.ports.input.services.command.concretes;

import az.rock.flyjob.js.domain.presentation.ports.input.services.command.abstracts.AbstractTestCommandDomainPresentationService;
import az.rock.lib.annotation.InputPort;
import com.intellibucket.lib.client.abstracts.AuthorizationApi;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@InputPort
@Profile({"local", "devlop", "pre-develop"})
public class TestCommandDomainPresentationService implements AbstractTestCommandDomainPresentationService {
    private AuthorizationApi authorizationApi;

    @Override
    public String testAuthorizationApiForRelation(UUID sourceUserId, UUID targetUserId) {
        return this.authorizationApi.fetchRelationLevel(sourceUserId, targetUserId);
    }
}
