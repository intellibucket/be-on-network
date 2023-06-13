package az.rock.flyjob.auth.dfs.service.abstracts;

import az.rock.lib.valueObject.FileMetaData;
import az.rock.lib.valueObject.MultipartFileWrapper;
import jakarta.transaction.Transactional;

@Transactional
public interface AbstractFileStorageService {
    FileMetaData uploadFile(MultipartFileWrapper multipartFileWrapper);

    FileMetaData getFileMetaData(String fileName);

    byte[] downloadFile(String fileName);

    void deleteFile(String fileName);

}
