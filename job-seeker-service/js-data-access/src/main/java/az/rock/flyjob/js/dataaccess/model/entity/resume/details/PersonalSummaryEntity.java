package az.rock.flyjob.js.dataaccess.model.entity.resume.details;

import az.rock.flyjob.js.dataaccess.model.entity.resume.ResumeEntity;
import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.AccessModifier;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "personal_summaries", schema = "resume", indexes = {
        @Index(name = "idx_personalsummaryentity_resume_uuid", columnList = "resume_uuid, accessModifier")
})
@Entity(name = "PersonalSummaryEntity")
public class PersonalSummaryEntity extends BaseEntity {
    @OneToOne
    private ResumeEntity resume;

    @Column(length = 32, columnDefinition = "varchar(32) default 'AUTHENTICATED'")
    @Enumerated(EnumType.STRING)
    private AccessModifier accessModifier;

    @Size(max = 2000)
    @Column(name = "summary")
    private String summary;
}
