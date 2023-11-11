package az.rock.flyjob.auth.model.root.user;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.auth.CoverPictureID;
import az.rock.lib.domain.id.auth.UserID;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.Version;

import java.time.ZonedDateTime;

public class CoverPictureRoot extends AggregateRoot<CoverPictureID> {
    private UserID user;

    private AccessModifier accessModifier;

    private Boolean isCurrent;

    private String region;

    private String filepath;

    private String filename;

    private String fileFormat;

    private Long filesize;

    private String headerLineColor;

    private CoverPictureRoot(Builder builder) {
        super(builder.id, builder.version, builder.processStatus, builder.rowStatus, builder.createdDate, builder.modificationDate);
        user = builder.user;
        accessModifier = builder.accessModifier;
        isCurrent = builder.isCurrent;
        region = builder.region;
        filepath = builder.filepath;
        filename = builder.filename;
        fileFormat = builder.fileFormat;
        filesize = builder.filesize;
        headerLineColor = builder.headerLineColor;
    }


    public static final class Builder {
        private CoverPictureID id;
        private Version version;
        private ProcessStatus processStatus;
        private RowStatus rowStatus;
        private ZonedDateTime createdDate;
        private ZonedDateTime modificationDate;
        private UserID user;
        private AccessModifier accessModifier;
        private Boolean isCurrent;
        private String region;
        private String filepath;
        private String filename;
        private String fileFormat;
        private Long filesize;
        private String headerLineColor;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder id(CoverPictureID val) {
            id = val;
            return this;
        }

        public Builder version(Version val) {
            version = val;
            return this;
        }

        public Builder version(Long val) {
            version = new Version(val);
            return this;
        }

        public Builder processStatus(ProcessStatus val) {
            processStatus = val;
            return this;
        }

        public Builder rowStatus(RowStatus val) {
            rowStatus = val;
            return this;
        }

        public Builder createdDate(ZonedDateTime val) {
            createdDate = val;
            return this;
        }

        public Builder modificationDate(ZonedDateTime val) {
            modificationDate = val;
            return this;
        }

        public Builder userId(UserID val) {
            user = val;
            return this;
        }

        public Builder accessModifier(AccessModifier val) {
            accessModifier = val;
            return this;
        }

        public Builder isCurrent(Boolean val) {
            isCurrent = val;
            return this;
        }

        public Builder region(String val) {
            region = val;
            return this;
        }

        public Builder filepath(String val) {
            filepath = val;
            return this;
        }

        public Builder filename(String val) {
            filename = val;
            return this;
        }

        public Builder fileFormat(String val) {
            fileFormat = val;
            return this;
        }

        public Builder filesize(Long val) {
            filesize = val;
            return this;
        }

        public Builder headerLineColor(String val) {
            headerLineColor = val;
            return this;
        }

        public CoverPictureRoot build() {
            return new CoverPictureRoot(this);
        }
    }

    public UserID getUser() {
        return user;
    }

    public AccessModifier getAccessModifier() {
        return accessModifier;
    }

    public Boolean getCurrent() {
        return isCurrent;
    }

    public String getRegion() {
        return region;
    }

    public String getFilepath() {
        return filepath;
    }

    public String getFilename() {
        return filename;
    }

    public String getFileFormat() {
        return fileFormat;
    }

    public Long getFilesize() {
        return filesize;
    }

    public String getHeaderLineColor() {
        return headerLineColor;
    }
}
