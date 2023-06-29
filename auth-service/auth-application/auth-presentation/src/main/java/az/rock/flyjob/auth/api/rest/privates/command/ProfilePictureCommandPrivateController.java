package az.rock.flyjob.auth.api.rest.privates.command;

import az.rock.auth.domain.presentation.ports.input.service.command.abstracts.AbstractProfilePictureCommandDomainPresentation;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import az.rock.lib.valueObject.MultipartFileWrapper;
import io.swagger.v3.oas.annotations.Operation;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping(value = "/auth/1.0/private/command/profile-picture")
public class ProfilePictureCommandPrivateController {
    private final AbstractProfilePictureCommandDomainPresentation profilePictureCommandDomainPresentation;

    public ProfilePictureCommandPrivateController(AbstractProfilePictureCommandDomainPresentation profilePictureCommandDomainPresentation) {
        this.profilePictureCommandDomainPresentation = profilePictureCommandDomainPresentation;
    }

    @PostMapping(value = "/upload",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE,MediaType.IMAGE_PNG_VALUE,MediaType.IMAGE_JPEG_VALUE})
    @Operation(summary = "Upload profile picture")
    public ResponseEntity<JSuccessDataResponse<UUID>> uploadProfilePicture(@RequestBody MultipartFile file) {
        MultipartFileWrapper wrapFile = this.factoryWrapper(file);
        var response = this.profilePictureCommandDomainPresentation.uploadProfilePicture(wrapFile);
        return ResponseEntity.status(HttpStatus.CREATED).body(new JSuccessDataResponse<>(response));
    }

    @NotNull
    private MultipartFileWrapper factoryWrapper(MultipartFile file) {
        MultipartFileWrapper wrapFile = null;
        try {
            wrapFile = MultipartFileWrapper.of(file.getOriginalFilename(), file.getContentType(), file.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException("F0000000017");
        }
        return wrapFile;
    }
}
