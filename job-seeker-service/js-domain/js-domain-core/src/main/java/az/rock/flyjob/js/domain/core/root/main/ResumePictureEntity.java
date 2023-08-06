package az.rock.flyjob.js.domain.core.root.main;

import az.rock.flyjob.model.entity.resume.ResumeEntity;
import az.rock.lib.domain.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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
