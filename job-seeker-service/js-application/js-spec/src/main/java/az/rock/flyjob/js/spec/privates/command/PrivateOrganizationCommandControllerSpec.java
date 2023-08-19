package az.rock.flyjob.js.spec.privates.command;

import az.rock.lib.jresponse.response.success.JSuccessResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;

public interface PrivateOrganizationCommandControllerSpec {

    ResponseEntity<JSuccessResponse> searchJob();
    ResponseEntity<JSuccessResponse> addJob();
    ResponseEntity<JSuccessResponse> deleteJob();
    ResponseEntity<JSuccessResponse> upgradeJobToPremium();

    @PutMapping("/upgrade-job-to-ultimate")
    ResponseEntity<JSuccessResponse> upgradeJobToUltimate();
}
