package az.rock.flyjob.js.dataaccess.model.entity.resume.details;

import az.rock.flyjob.js.dataaccess.model.entity.resume.ResumeEntity;
import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.AccessModifier;
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
@Table(name = "awards", schema = "resume", indexes = {
        @Index(name = "idx_awardentity_resume_uuid", columnList = "resume_uuid, accessModifier")
})
@Entity(name = "AwardEntity")
public class AwardEntity extends BaseEntity {
    @ManyToOne
    private ResumeEntity resume;

    @Column(length = 32, columnDefinition = "varchar(32) default 'AUTHENTICATED'")
    @Enumerated(EnumType.STRING)
    private AccessModifier accessModifier;

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
