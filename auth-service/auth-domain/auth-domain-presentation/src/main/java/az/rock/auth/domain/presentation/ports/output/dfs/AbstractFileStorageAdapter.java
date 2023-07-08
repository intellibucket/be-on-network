package az.rock.auth.domain.presentation.ports.output.dfs;

import az.rock.lib.valueObject.FileMetaData;
import az.rock.lib.valueObject.MultipartFileWrapper;
import jakarta.transaction.Transactional;

@Transactional
public interface AbstractFileStorageAdapter {
    FileMetaData uploadFile(MultipartFileWrapper multipartFileWrapper);

    byte[] get(String path);

}
