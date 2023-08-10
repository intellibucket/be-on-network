package az.rock.flyjob.auth.root.user;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.auth.ProfilePictureID;
import az.rock.lib.domain.id.auth.UserID;
import az.rock.lib.valueObject.*;

import java.time.ZonedDateTime;

public class ProfilePictureRoot extends AggregateRoot<ProfilePictureID> {

    private UserID userID;

    private AccessModifier accessModifier;

    private Boolean isCurrent;

    private String region;

    private String filepath;

    private String filename;

    private String fileFormat;

    private Long filesize;

    private String filepathThumbnail;

    private String filepathMedium;

    private String filepathLarge;

    private String filepathExtraLarge;

    private String filepathWebp;

    private ProfilePictureRoot(Builder builder) {
        super(builder.id, builder.version, builder.processStatus, builder.rowStatus, builder.createdDate, builder.modificationDate);
        userID = builder.userID;
        accessModifier = builder.accessModifier;
        region = builder.region;
        isCurrent = builder.isCurrent;
        filepath = builder.filepath;
        filename = builder.filename;
        fileFormat = builder.fileFormat;
        filesize = builder.filesize;
        filepathThumbnail = builder.filepathThumbnail;
        filepathMedium = builder.filepathMedium;
        filepathLarge = builder.filepathLarge;
        filepathExtraLarge = builder.filepathExtraLarge;
        filepathWebp = builder.filepathWebp;
    }


    public static final class Builder {
        private ProfilePictureID id;
        private Version version;
        private ProcessStatus processStatus;
        private RowStatus rowStatus;
        private ZonedDateTime createdDate;
        private ZonedDateTime modificationDate;
        private UserID userID;
        private AccessModifier accessModifier;
        private String region;
        private Boolean isCurrent;
        private String filepath;
        private String filename;
        private String fileFormat;
        private Long filesize;
        private String filepathThumbnail;
        private String filepathMedium;
        private String filepathLarge;
        private String filepathExtraLarge;
        private String filepathWebp;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }


        public Builder userID(UserID userID) {
            this.userID = userID;
            return this;
        }

        public Builder region(String region) {
            this.region = region;
            return this;
        }

        public Builder id(ProfilePictureID id) {
            this.id = id;
            return this;
        }

        public Builder version(Version version) {
            this.version = version;
            return this;
        }

        public Builder processStatus(ProcessStatus processStatus) {
            this.processStatus = processStatus;
            return this;
        }

        public Builder rowStatus(RowStatus rowStatus) {
            this.rowStatus = rowStatus;
            return this;
        }

        public Builder createdDate(ZonedDateTime createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public Builder modificationDate(ZonedDateTime modificationDate) {
            this.modificationDate = modificationDate;
            return this;
        }

        public Builder accessModifier(AccessModifier accessModifier) {
            this.accessModifier = accessModifier;
            return this;
        }

        public Builder isCurrent(Boolean isCurrent) {
            this.isCurrent = isCurrent;
            return this;
        }

        public Builder filepath(String filepath) {
            this.filepath = filepath;
            return this;
        }

        public Builder filename(String filename) {
            this.filename = filename;
            return this;
        }

        public Builder fileFormat(String fileFormat) {
            this.fileFormat = fileFormat;
            return this;
        }

        public Builder filesize(Long filesize) {
            this.filesize = filesize;
            return this;
        }

        public Builder filepathThumbnail(String filepathThumbnail) {
            this.filepathThumbnail = filepathThumbnail;
            return this;
        }

        public Builder filepathMedium(String filepathMedium) {
            this.filepathMedium = filepathMedium;
            return this;
        }

        public Builder filepathLarge(String filepathLarge) {
            this.filepathLarge = filepathLarge;
            return this;
        }

        public Builder filepathExtraLarge(String filepathExtraLarge) {
            this.filepathExtraLarge = filepathExtraLarge;
            return this;
        }

        public Builder filepathWebp(String filepathWebp) {
            this.filepathWebp = filepathWebp;
            return this;
        }

        public ProfilePictureRoot build() {
            return new ProfilePictureRoot(this);
        }
    }

    public UserID getUserID() {
        return userID;
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

    public String getFilepathThumbnail() {
        return filepathThumbnail;
    }

    public String getFilepathMedium() {
        return filepathMedium;
    }

    public String getFilepathLarge() {
        return filepathLarge;
    }

    public String getFilepathExtraLarge() {
        return filepathExtraLarge;
    }

    public String getFilepathWebp() {
        return filepathWebp;
    }
}
