package az.rock.flyjob.js.dataaccess.model.entity.resume.main;

import az.rock.flyjob.js.dataaccess.model.entity.resume.ResumeEntity;
import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.AccessModifier;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "resume_pictures", schema = "resume")
@Entity(name = "ResumePictureEntity")
public class ResumePictureEntity extends BaseEntity {
    @OneToOne
    private ResumeEntity resume;

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
}
