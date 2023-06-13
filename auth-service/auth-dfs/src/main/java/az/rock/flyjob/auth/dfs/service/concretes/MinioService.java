package az.rock.flyjob.auth.dfs.service.concretes;

import az.rock.flyjob.auth.dfs.service.abstracts.AbstractMinioService;
import io.minio.MinioClient;
import io.minio.ObjectWriteResponse;
import io.minio.PutObjectArgs;
import io.minio.errors.MinioException;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.nio.file.Path;

@Component
public class MinioService implements AbstractMinioService {

    private final String bucketName = "auth-bucket";
    private final String folderName = "profile";
    private final MinioClient minioClient;

    public MinioService(MinioClient minioClient) {
        this.minioClient = minioClient;
    }

    private String generateFileName(String fileName) {
        return String.valueOf(System.currentTimeMillis()).concat("_").concat(fileName);
    }

    @Override
    public ObjectWriteResponse upload(Path path, InputStream inputStream)  throws MinioException {
        try {
            var args = PutObjectArgs
                    .builder()
                    .bucket(this.bucketName)
                    .object(this.generateFileName(path.getFileName().toString()))
                    .stream(inputStream, -1, 10485760)
                    .build();
            return this.minioClient.putObject(args);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
