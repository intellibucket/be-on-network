package az.rock.flyjob.auth.dfs.service.concretes;

import az.rock.flyjob.auth.dfs.service.abstracts.AbstractFileStorageService;
import az.rock.lib.valueObject.FileMetaData;
import az.rock.lib.valueObject.MultipartFileWrapper;
import com.jlefebure.spring.boot.minio.MinioService;

public class MinioFileStorageService implements AbstractFileStorageService {
    private MinioService minioService;

    @Override
    public FileMetaData uploadFile(MultipartFileWrapper multipartFileWrapper) {
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
