package az.rock.flyjob.js.spec.privates.command.resume.detail;

import az.rock.lib.annotation.FileSupport;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import az.rock.lib.valueObject.common.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface SignatureDeclarationCommandPrivateSpec {
    @FileSupport(types = MediaType.BYTE_ARRAY)
    ResponseEntity<JSuccessResponse> upload(MultipartFile multipartFile);
}
