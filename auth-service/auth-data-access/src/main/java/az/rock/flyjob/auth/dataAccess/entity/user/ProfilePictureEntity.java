package az.rock.flyjob.auth.dataAccess.entity.user;

import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.PictureType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "profile_pictures", schema = "auth")
@Entity(name = "ProfilePictureEntity")
public class ProfilePictureEntity extends BaseEntity {

    @Column(length = 32, columnDefinition = "varchar(32) default 'ONLY_AUTHENTICATED'")
    @Enumerated(EnumType.STRING)
    private AccessModifier accessModifier;

    @Enumerated(EnumType.STRING)
    private PictureType type;

    @Column(name = "is_current", nullable = false, columnDefinition = "boolean default false")
    private Boolean isCurrent;

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
}
