package az.rock.lib.valueObject;

import az.rock.lib.annotation.ValueObject;

@ValueObject
public class FileMetaData {
    private  String fileName;
    private  String contentType;
    private  long size;
    private  String url;
    private  String bucketName;
    private  String versionId;
    private String etag;

    private Object object;

    private String region;

    public FileMetaData(String fileName, String contentType, long size, String url, String bucketName, String versionId) {
        this.fileName = fileName;
        this.contentType = contentType;
        this.size = size;
        this.url = url;
        this.bucketName = bucketName;
        this.versionId = versionId;
    }

    public FileMetaData(String versionId,String etag) {
        this.versionId = versionId;
        this.etag = etag;
    }

    public FileMetaData(String versionId,String etag,String bucketName,String region){
        this.versionId = versionId;
        this.etag = etag;
        this.bucketName = bucketName;
        this.region = region;
    }
}
