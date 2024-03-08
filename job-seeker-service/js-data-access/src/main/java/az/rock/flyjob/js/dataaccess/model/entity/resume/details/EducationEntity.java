package az.rock.flyjob.js.dataaccess.model.entity.resume.details;

import az.rock.flyjob.js.dataaccess.model.entity.resume.ResumeEntity;
import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.js.EducationDegree;
import az.rock.lib.valueObject.js.EducationState;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "educations", schema = "resume", indexes = {
        @Index(name = "idx_educationentity_resume_uuid", columnList = "resume_uuid, accessModifier")
})
@Entity(name = "EducationEntity")
public class EducationEntity extends BaseEntity {
    @ManyToOne
    private ResumeEntity resume;

    @Column(length = 32, columnDefinition = "varchar(32) default 'AUTHENTICATED'")
    @Enumerated(EnumType.STRING)
    private AccessModifier accessModifier;

    @Column(name = "order_number",nullable = false)
    private Integer orderNumber;

    @Enumerated(EnumType.STRING)
    private EducationDegree degree;

    @Enumerated(EnumType.STRING)
    private EducationState state;

    @Column(name = "link")
    private String link;

    @Column(name = "establishment_uuid")
    private UUID establishmentUUID;

    @Column(name = "establishment_name", nullable = false)
    private String establishmentName;

    @Column(name = "city_id")
    private UUID cityId;

    @Column(name = "start_date", columnDefinition = "DATE")
    private LocalDate startDate;

    @Column(name = "end_date", columnDefinition = "DATE")
    private LocalDate endDate;

    @Column(name = "description")
    private String description;
}
