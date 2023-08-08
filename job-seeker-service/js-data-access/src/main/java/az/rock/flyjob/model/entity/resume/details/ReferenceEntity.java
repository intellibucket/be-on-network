package az.rock.flyjob.model.entity.resume.details;

import az.rock.flyjob.model.entity.resume.ResumeEntity;
import az.rock.lib.domain.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "references", schema = "resume")
@Entity(name = "ReferenceEntity")
public class ReferenceEntity extends BaseEntity {
    @ManyToOne
    private ResumeEntity resume;

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
