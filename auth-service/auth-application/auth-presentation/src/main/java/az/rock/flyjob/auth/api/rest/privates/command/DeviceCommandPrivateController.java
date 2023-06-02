package az.rock.flyjob.auth.api.rest.privates.command;

import az.rock.spec.auth.privates.command.DeviceCommandPrivateSpec;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(value = "/auth/1.0/private/command/device",produces = MediaType.APPLICATION_JSON_VALUE)
public class DeviceCommandPrivateController implements DeviceCommandPrivateSpec {
}
