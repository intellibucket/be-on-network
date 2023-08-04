package az.rock.flyjob.model.entity.resume.template;

import az.rock.flyjob.model.entity.resume.ResumeEntity;
import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.js.ResumeTemplateType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "resume_templates", schema = "resume")
@Entity(name = "ResumeTemplateEntity")
public class ResumeTemplateEntity extends BaseEntity {
    @OneToOne
    private ResumeEntity resume;

    @Enumerated(EnumType.STRING)
    private ResumeTemplateType resumeTemplateType;
}
