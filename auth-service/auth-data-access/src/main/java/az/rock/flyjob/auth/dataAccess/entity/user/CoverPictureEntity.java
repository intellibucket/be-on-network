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
@Table(name = "cover_pictures", schema = "auth")
@Entity(name = "CoverPictureEntity")
public class CoverPictureEntity extends BaseEntity {

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

    @Column(name = "header_line_color", columnDefinition = "varchar(14) default '#ffffff'")
    private String headerLineColor;

}
