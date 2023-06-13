package az.rock.flyjob.auth.dfs.service.concretes;

import az.rock.flyjob.auth.dfs.service.abstracts.AbstractFileStorageService;
import az.rock.lib.valueObject.FileMetaData;
import az.rock.lib.valueObject.MultipartFileWrapper;
import com.jlefebure.spring.boot.minio.MinioException;
import com.jlefebure.spring.boot.minio.MinioService;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class MinioFileStorageService implements AbstractFileStorageService {
    private final MinioService minioService;

    public MinioFileStorageService(MinioService minioService) {
        this.minioService = minioService;
    }

    @Override
    public FileMetaData uploadFile(MultipartFileWrapper multipartFileWrapper) {
        Path path = Paths.get("./uploads/pictures/profile/" + multipartFileWrapper.getFileName());
        try {
            this.minioService.upload(path, multipartFileWrapper.getInputStream());
        } catch (MinioException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public FileMetaData getFileMetaData(String fileName) {
        return null;
    }

    @Override
    public byte[] downloadFile(String fileName) {
        return new byte[0];
    }

    @Override
    public void deleteFile(String fileName) {

    }
}
