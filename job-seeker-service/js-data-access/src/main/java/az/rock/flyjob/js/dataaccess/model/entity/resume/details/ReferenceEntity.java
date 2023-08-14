package az.rock.flyjob.js.dataaccess.model.entity.resume.details;

import az.rock.flyjob.js.dataaccess.model.entity.resume.ResumeEntity;
import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.AccessModifier;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "references", schema = "resume", indexes = {
        @Index(name = "idx_referenceentity_resume_uuid", columnList = "resume_uuid, accessModifier")
})
@Entity(name = "ReferenceEntity")
public class ReferenceEntity extends BaseEntity {
    @ManyToOne
    private ResumeEntity resume;

    @Column(length = 32, columnDefinition = "varchar(32) default 'ONLY_AUTHENTICATED'")
    @Enumerated(EnumType.STRING)
    private AccessModifier accessModifier;

    @Column(name = "order_number",nullable = false)
    private Integer orderNumber;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "position", nullable = false)
    private String position;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "organization")
    private String organization;

    @Column(name = "email")
    @Email
    private String email;

    @Column(name = "phone")
    private String phone;

}
