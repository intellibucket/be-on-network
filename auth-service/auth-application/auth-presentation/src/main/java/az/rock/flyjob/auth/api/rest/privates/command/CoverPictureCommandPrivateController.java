package az.rock.flyjob.auth.api.rest.privates.command;

import az.rock.auth.domain.presentation.ports.input.service.command.abstracts.AbstractCoverPictureCommandDomainPresentation;
import az.rock.flyjob.auth.mapper.MultipartFileWrapperMapper;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import az.rock.lib.valueObject.MultipartFileWrapper;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping(value = "/auth/1.0/private/command/cover-picture")
public class CoverPictureCommandPrivateController {

    private final AbstractCoverPictureCommandDomainPresentation coverPictureCommandDomainPresentation;
    private final MultipartFileWrapperMapper multipartFileWrapperMapper;

    public CoverPictureCommandPrivateController(AbstractCoverPictureCommandDomainPresentation coverPictureCommandDomainPresentation, MultipartFileWrapperMapper multipartFileWrapperMapper) {
        this.coverPictureCommandDomainPresentation = coverPictureCommandDomainPresentation;
        this.multipartFileWrapperMapper = multipartFileWrapperMapper;
    }

    @PostMapping(value = "/upload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE,
            MediaType.IMAGE_PNG_VALUE,
            MediaType.IMAGE_JPEG_VALUE})
    @Operation(summary = "Upload cover image")
    public ResponseEntity<JSuccessDataResponse<UUID>> uploadProfilePicture(@RequestBody MultipartFile file) {
        MultipartFileWrapper wrapFile = this.factoryWrapper(file);
        var response = this.coverPictureCommandDomainPresentation.uploadProfilePicture(wrapFile);
        return ResponseEntity.status(HttpStatus.CREATED).body(new JSuccessDataResponse<>(response));
    }

    private MultipartFileWrapper factoryWrapper(MultipartFile file) {
        MultipartFileWrapper wrapFile;
        try {
            wrapFile = this.multipartFileWrapperMapper.map(file);
        } catch (IOException e) {
            throw new RuntimeException("F0000000017");
        }
        return wrapFile;
    }
}
