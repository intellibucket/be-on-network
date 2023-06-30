package az.rock.flyjob.auth.dfs.service.concretes;

import az.rock.flyjob.auth.dfs.service.abstracts.AbstractMinioService;
import az.rock.lib.util.DFSUtil;
import io.minio.MinioClient;
import io.minio.ObjectWriteResponse;
import io.minio.PutObjectArgs;
import io.minio.errors.MinioException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.nio.file.Path;

@Component
public class AuthMinioService implements AbstractMinioService {

    private final String bucketName = "auth-bucket";
    private final String folderName = "profile";
    private final MinioClient minioClient;

    public AuthMinioService(@Qualifier(value = "authMinioClient") MinioClient minioClient) {
        this.minioClient = minioClient;
    }

    @Override
    public ObjectWriteResponse upload(Path path, InputStream inputStream)  throws MinioException {
        try {
            var args = PutObjectArgs
                    .builder()
                    .bucket(this.bucketName)
                    .object(DFSUtil.generateFileName(path.toFile().getAbsolutePath()))
                    .stream(inputStream, -1, 10485760)
                    .build();
            return this.minioClient.putObject(args);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
