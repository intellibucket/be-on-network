package az.rock.lib.valueObject;

import az.rock.lib.annotation.ValueObject;

@ValueObject
public class FileMetaData {
    private  String etag;

    private  String versionId;

    private String object;

    private String region;

    private String bucket;

    private Long fileSize;

    private FileMetaData(Builder builder) {
        etag = builder.etag;
        versionId = builder.versionId;
        object = builder.object;
        region = builder.region;
        bucket = builder.bucket;
        fileSize = builder.fileSize;
    }

    public String fileFormat(){
        var split = object.split(",");
        return split[split.length-1];
    }


    public static final class Builder {
        private String etag;
        private String versionId;
        private String object;
        private String region;
        private String bucket;

        private Long fileSize;


        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder fileSize(Long val) {
            fileSize = val;
            return this;
        }
        public Builder etag(String val) {
            etag = val;
            return this;
        }

        public Builder versionId(String val) {
            versionId = val;
            return this;
        }

        public Builder object(String val) {
            object = val;
            return this;
        }

        public Builder region(String val) {
            region = val;
            return this;
        }

        public Builder bucket(String val) {
            bucket = val;
            return this;
        }

        public FileMetaData build() {
            return new FileMetaData(this);
        }
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public String getVersionId() {
        return versionId;
    }

    public void setVersionId(String versionId) {
        this.versionId = versionId;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }
}
