package az.rock.auth.domain.presentation.ports.output.dfs;

import az.rock.lib.valueObject.FileMetaData;
import az.rock.lib.valueObject.MultipartFileWrapper;
import jakarta.transaction.Transactional;

@Transactional
public interface AbstractFileStorageAdapter {
    FileMetaData uploadFile(MultipartFileWrapper multipartFileWrapper);


    FileMetaData getFileMetaData(String fileName);

    byte[] get(String path);

    void deleteFile(String fileName);

}
