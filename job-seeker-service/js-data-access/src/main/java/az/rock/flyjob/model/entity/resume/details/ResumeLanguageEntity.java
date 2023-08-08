package az.rock.flyjob.model.entity.resume.details;

import az.rock.flyjob.model.entity.resume.ResumeEntity;
import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.LanguageLevel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "resume_languages", schema = "resume")
@Entity(name = "ResumeLanguageEntity")
public class ResumeLanguageEntity extends BaseEntity {
    @ManyToOne
    private ResumeEntity resume;

    @Column(name = "language_uuid", nullable = false)
    private UUID languageUUID;

    @Column(name = "name")
    private String additionalInfo;

    @Enumerated(EnumType.STRING)
    private LanguageLevel level;
}