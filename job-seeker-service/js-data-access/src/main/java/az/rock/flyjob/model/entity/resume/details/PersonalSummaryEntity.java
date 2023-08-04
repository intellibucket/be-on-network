package az.rock.flyjob.model.entity.resume.details;

import az.rock.flyjob.model.entity.resume.ResumeEntity;
import az.rock.lib.domain.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "personal_summaries", schema = "resume")
@Entity(name = "PersonalSummaryEntity")
public class PersonalSummaryEntity extends BaseEntity {
    @OneToOne
    private ResumeEntity resume;

    @Size(max = 2000)
    @Column(name = "summary")
    private String summary;
}
