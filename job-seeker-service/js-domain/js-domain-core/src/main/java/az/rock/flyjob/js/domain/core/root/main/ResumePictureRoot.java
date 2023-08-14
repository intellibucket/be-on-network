package az.rock.flyjob.js.domain.core.root.main;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.js.AwardID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.domain.id.js.ResumePictureID;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.Version;

import java.time.ZonedDateTime;

public class ResumePictureRoot extends AggregateRoot<ResumePictureID> {
    private ResumeID resume;

    private AccessModifier accessModifier;

    private Boolean isCurrent;

    private String region;

    private String filepath;

    private String filename;

    private String fileFormat;

    private ResumePictureRoot(Builder builder) {
        super(builder.id,builder.version,  builder.processStatus, builder.rowStatus, builder.createdDate, builder.lastModifiedDate);
        this.accessModifier = builder.accessModifier;
        resume = builder.resume;
        isCurrent = builder.isCurrent;
        region = builder.region;
        filepath = builder.filepath;
        filename = builder.filename;
        fileFormat = builder.fileFormat;
    }


    public ResumeID getResume() {
        return resume;
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

    public AccessModifier getAccessModifier() {
        return accessModifier;
    }

    public static final class Builder {
        private ResumePictureID id;
        private Version version;
        private ProcessStatus processStatus;
        private RowStatus rowStatus;
        private ZonedDateTime createdDate;
        private ZonedDateTime lastModifiedDate;

        private AccessModifier accessModifier;
        private ResumeID resume;
        private Boolean isCurrent;
        private String region;
        private String filepath;
        private String filename;
        private String fileFormat;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder id(ResumePictureID val) {
            id = val;
            return this;
        }

        public Builder version(Version val) {
            version = val;
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

        public Builder lastModifiedDate(ZonedDateTime val) {
            lastModifiedDate = val;
            return this;
        }

        public Builder accessModifier(AccessModifier accessModifier){
            this.accessModifier = accessModifier;
            return this;
        }

        public Builder resume(ResumeID val) {
            resume = val;
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

        public ResumePictureRoot build() {
            return new ResumePictureRoot(this);
        }
    }
}
