package az.rock.flyjob.auth.dfs.service.abstracts;

import io.minio.ObjectWriteResponse;
import io.minio.errors.MinioException;

import java.io.InputStream;
import java.nio.file.Path;

public interface AbstractMinioService {
    ObjectWriteResponse upload(Path path, InputStream inputStream) throws MinioException;
}
