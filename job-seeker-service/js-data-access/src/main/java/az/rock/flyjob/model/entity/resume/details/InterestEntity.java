package az.rock.flyjob.model.entity.resume.details;

import az.rock.flyjob.model.entity.resume.ResumeEntity;
import az.rock.lib.domain.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "interests", schema = "resume")
@Entity(name = "InterestEntity")
public class InterestEntity extends BaseEntity {
    @ManyToOne
    private ResumeEntity resume;

    @Column(name = "is_hobby", nullable = false)
    private Boolean isHobby;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;
}
