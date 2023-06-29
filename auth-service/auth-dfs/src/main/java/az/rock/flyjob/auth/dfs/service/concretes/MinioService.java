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
        var names = fileName.split("\\.");
        return names[0]
                .concat("_")
                .concat(String.valueOf(System.currentTimeMillis()))
                .concat(".")
                .concat(names[1]);
    }

    @Override
    public ObjectWriteResponse upload(Path path, InputStream inputStream)  throws MinioException {
        try {
            var args = PutObjectArgs
                    .builder()
                    .bucket(this.bucketName)
                    .object(this.generateFileName(path.toFile().getAbsolutePath()))
                    .stream(inputStream, -1, 10485760)
                    .build();
            return this.minioClient.putObject(args);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
