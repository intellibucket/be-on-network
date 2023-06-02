package az.rock.spec.auth.privates.command;

import az.rock.lib.jresponse.response.success.JSuccessResponse;
import az.rock.lib.valueObject.BugReport;
import org.springframework.http.ResponseEntity;

public interface AccountPlanCommandPrivateControllerSpec {
    ResponseEntity<JSuccessResponse> updateToBasic();

    ResponseEntity<JSuccessResponse> updateToUltimate();

    ResponseEntity<JSuccessResponse> updateToBasicDemo();

    ResponseEntity<JSuccessResponse> updateToUltimateDemo();

    ResponseEntity<JSuccessResponse> cancelCurrentPlan();

    ResponseEntity<JSuccessResponse> reportBug(BugReport report);
}
