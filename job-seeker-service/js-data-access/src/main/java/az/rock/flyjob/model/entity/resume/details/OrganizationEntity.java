package az.rock.flyjob.model.entity.resume.details;

import az.rock.flyjob.model.entity.resume.ResumeEntity;
import az.rock.lib.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "organizations", schema = "resume")
@Entity(name = "OrganizationEntity")
public class OrganizationEntity extends BaseEntity {
    @ManyToOne
    private ResumeEntity resume;

    @Column(name = "organization_name")
    private String organizationName;

    @Column(name = "position")
    private String position;

    @Temporal(value = TemporalType.DATE)
    private Timestamp startDate;

    @Temporal(value = TemporalType.DATE)
    private Timestamp endDate;

    @Column(name = "city_id")
    private UUID cityId;

    @Column(name = "description")
    private String description;

}
