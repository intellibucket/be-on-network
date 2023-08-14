package az.rock.flyjob.auth.api.rest.privates.query;

import az.rock.auth.domain.presentation.ports.input.service.query.abstracts.AbstractNetworkQueryDomainPresentation;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import az.rock.spec.auth.privates.query.NetworkQueryPrivateSpec;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping(value = "/auth/1.0/private/query/network",produces = MediaType.APPLICATION_JSON_VALUE)
public class NetworkQueryPrivateController implements NetworkQueryPrivateSpec {
    private final AbstractNetworkQueryDomainPresentation networkQueryDomainPresentation;

    public NetworkQueryPrivateController(AbstractNetworkQueryDomainPresentation networkQueryDomainPresentation) {
        this.networkQueryDomainPresentation = networkQueryDomainPresentation;
    }

    @Override
    public ResponseEntity<JSuccessDataResponse<List<UUID>>> queryMyNetworks() {
        var response = this.networkQueryDomainPresentation.findMyNetworks();
        return ResponseEntity.ok(new JSuccessDataResponse<>(response));
    }

    @Override
    public ResponseEntity<JSuccessDataResponse<List<UUID>>> queryInMyNetworkPendingRequests() {
        var response = this.networkQueryDomainPresentation.findInMyNetworkPendingRequests();
        return ResponseEntity.ok(new JSuccessDataResponse<>(response));
    }

    @Override
    public ResponseEntity<JSuccessDataResponse<List<UUID>>> queryMyPendingRequests() {
        var response = this.networkQueryDomainPresentation.findMyPendingRequests();
        return ResponseEntity.ok(new JSuccessDataResponse<>(response));
    }

}
