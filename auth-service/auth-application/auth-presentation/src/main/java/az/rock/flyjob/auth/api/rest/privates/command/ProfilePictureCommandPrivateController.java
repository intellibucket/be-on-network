package az.rock.flyjob.auth.api.rest.privates.command;

import az.rock.lib.jresponse.response.success.JSuccessResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin
@RestController
@RequestMapping(value = "/auth/1.0/private/command/profile-picture")
public class ProfilePictureCommandPrivateController {

    @PostMapping("/upload")
    public ResponseEntity<JSuccessResponse> uploadProfilePicture(@RequestBody MultipartFile file) {
        return null;
    }
}
