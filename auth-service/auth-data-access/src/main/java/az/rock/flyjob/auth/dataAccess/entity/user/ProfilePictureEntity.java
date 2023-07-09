package az.rock.flyjob.auth.dataAccess.entity.user;

import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.PictureType;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "profile_pictures", schema = "auth")
@Entity(name = "ProfilePictureEntity")
public class ProfilePictureEntity extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity user;

    @Column(length = 32, columnDefinition = "varchar(32) default 'ONLY_AUTHENTICATED'")
    @Enumerated(EnumType.STRING)
    private AccessModifier accessModifier;

    @Column(name = "is_current", nullable = false, columnDefinition = "boolean default false")
    private Boolean isCurrent;

    @Column( nullable = false ,columnDefinition = "varchar(64) default 'eu-central-1'")
    private String region;

    @Column(name = "file_path", nullable = false)
    private String filepath;

    @Column(name = "file_name", nullable = false, updatable = false)
    private String filename;

    @Column(name = "file_format", nullable = false, updatable = false)
    private String fileFormat;

    @Column(name = "file_size", nullable = false , updatable = false)
    private Long filesize;

    @Column(name = "file_url_thumbnail", nullable = false, updatable = true)
    private String filepathThumbnail;

    @Column(name = "file_url_small", nullable = false, updatable = true)
    private String filepathMedium;

    @Column(name = "file_url_medium", nullable = false, updatable = true)
    private String filepathLarge;

    @Column(name = "file_url_large", nullable = false, updatable = true)
    private String filepathExtraLarge;

    @Column(name = "file_url_webp", nullable = false, updatable = true)
    private String filepathWebp;

    private ProfilePictureEntity(Builder builder) {
        setUser(builder.user);
        setAccessModifier(builder.accessModifier);
        setIsCurrent(builder.isCurrent);
        setRegion(builder.region);
        setFilepath(builder.filepath);
        setFilename(builder.filename);
        setFileFormat(builder.fileFormat);
        setFilesize(builder.filesize);
        setFilepathThumbnail(builder.filepathThumbnail);
        setFilepathMedium(builder.filepathMedium);
        setFilepathLarge(builder.filepathLarge);
        setFilepathExtraLarge(builder.filepathExtraLarge);
        setFilepathWebp(builder.filepathWebp);
        setUuid(builder.uuid);
        setVersion(builder.version);
        setProcessStatus(builder.processStatus);
        setRowStatus(builder.rowStatus);
        setCreatedDate(builder.createdDate);
        setLastModifiedDate(builder.lastModifiedDate);
    }


    public static final class Builder {
        private UserEntity user;
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
        private UUID uuid;
        private Long version;
        private ProcessStatus processStatus;
        private RowStatus rowStatus;
        private Timestamp createdDate;
        private Timestamp lastModifiedDate;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder user(UserEntity val) {
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

        public Builder filepathThumbnail(String val) {
            filepathThumbnail = val;
            return this;
        }

        public Builder filepathMedium(String val) {
            filepathMedium = val;
            return this;
        }

        public Builder filepathLarge(String val) {
            filepathLarge = val;
            return this;
        }

        public Builder filepathExtraLarge(String val) {
            filepathExtraLarge = val;
            return this;
        }

        public Builder filepathWebp(String val) {
            filepathWebp = val;
            return this;
        }

        public Builder uuid(UUID val) {
            uuid = val;
            return this;
        }

        public Builder version(Long val) {
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

        public Builder createdDate(Timestamp val) {
            createdDate = val;
            return this;
        }

        public Builder lastModifiedDate(Timestamp val) {
            lastModifiedDate = val;
            return this;
        }

        public ProfilePictureEntity build() {
            return new ProfilePictureEntity(this);
        }
    }
}
