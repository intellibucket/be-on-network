package az.rock.flyjob.auth.dfs.service.concretes;

import az.rock.auth.domain.presentation.ports.output.dfs.AbstractFileStorageAdapter;
import az.rock.flyjob.auth.dfs.service.abstracts.AbstractMinioService;
import az.rock.lib.valueObject.FileMetaData;
import az.rock.lib.valueObject.MultipartFileWrapper;
import io.minio.errors.MinioException;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class MinioFileStorageService implements AbstractFileStorageAdapter {
    private final AbstractMinioService minioService;

    public MinioFileStorageService(AbstractMinioService minioService) {
        this.minioService = minioService;
    }

    @Override
    public FileMetaData uploadFile(MultipartFileWrapper multipartFileWrapper) {
        Path path = Paths.get("/image/profile/" + multipartFileWrapper.getFileName());
        try {
            var response = this.minioService.upload(path, multipartFileWrapper.getInputStream());
            return new FileMetaData( response.versionId(), response.etag(), response.bucket(), response.region());
        } catch (MinioException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public FileMetaData getFileMetaData(String fileName) {
        return null;
    }

    @Override
    public byte[] get(String path) {
        return this.minioService.get(path);
    }

    @Override
    public void deleteFile(String fileName) {

    }
}
