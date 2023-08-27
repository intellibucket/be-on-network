package az.rock.auth.domain.presentation.dto.request;

import az.rock.lib.valueObject.SquareImageCropCoordinate;
import org.springframework.web.multipart.MultipartFile;

public class ProfilePictureCreateRequest {
    private MultipartFile file;
    private SquareImageCropCoordinate coordinate;


    public ProfilePictureCreateRequest(MultipartFile file, SquareImageCropCoordinate coordinate) {
        this.file = file;
        this.coordinate = coordinate;
    }

    public MultipartFile getFile() {
        return file;
    }

    public SquareImageCropCoordinate getCoordinate() {
        return coordinate;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public void setCoordinate(SquareImageCropCoordinate coordinate) {
        this.coordinate = coordinate;
    }


}
