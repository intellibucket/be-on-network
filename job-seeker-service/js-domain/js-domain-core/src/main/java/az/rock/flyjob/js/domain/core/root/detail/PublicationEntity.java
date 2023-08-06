package az.rock.flyjob.js.domain.core.root.detail;

import az.rock.flyjob.model.entity.resume.ResumeEntity;
import az.rock.lib.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "publications", schema = "resume")
@Entity(name = "PublicationEntity")
public class PublicationEntity extends BaseEntity {
    @ManyToOne
    private ResumeEntity resume;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "link")
    private String link;

    @Temporal(value = TemporalType.DATE)
    private Timestamp startDate;

    @Temporal(value = TemporalType.DATE)
    private Timestamp endDate;

    @Column(name = "description")
    private String description;
}
