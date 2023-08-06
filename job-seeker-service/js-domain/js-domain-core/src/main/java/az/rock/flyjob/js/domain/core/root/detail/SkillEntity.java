package az.rock.flyjob.js.domain.core.root.detail;

import az.rock.flyjob.model.entity.resume.ResumeEntity;
import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.js.SkillLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "skills", schema = "resume")
@Entity(name = "SkillEntity")
public class SkillEntity extends BaseEntity {
    @ManyToOne
    private ResumeEntity resume;

    @Column(name = "skill_name", nullable = false)
    private String skillName;

    @Enumerated(EnumType.STRING)
    private SkillLevel skillLevel;

    @Column(name = "information")
    private String informatin;
}
