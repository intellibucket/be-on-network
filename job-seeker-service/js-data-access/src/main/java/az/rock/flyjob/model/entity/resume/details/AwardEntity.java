package az.rock.flyjob.model.entity.resume.details;

import az.rock.flyjob.model.entity.resume.ResumeEntity;
import az.rock.lib.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "awards", schema = "resume")
@Entity(name = "AwardEntity")
public class AwardEntity extends BaseEntity {
    @ManyToOne
    private ResumeEntity resume;

    @Column(name = "order_number",nullable = false)
    private Integer orderNumber;

    @Column(name = "award",nullable = false)
    private String award;

    @Column(name = "link")
    private String link;

    private String issuer;

    @Temporal(value = TemporalType.DATE)
    private Timestamp date;

    @Column(name = "description")
    private String description;
}
