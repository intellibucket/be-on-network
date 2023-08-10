package az.rock.flyjob.model.entity.resume.details;

import az.rock.flyjob.model.entity.resume.ResumeEntity;
import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.Switch;
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
@Table(name = "courses", schema = "resume")
@Entity(name = "CourseEntity")
public class CourseEntity extends BaseEntity {
    @ManyToOne
    private ResumeEntity resume;

    @Column(name = "order_number",nullable = false)
    private Integer orderNumber;

    @Column(name = "course_title", nullable = false)
    private String courseTitle;

    @Column(name = "institution", nullable = false)
    private String institution;

    @Column(name = "is_online", nullable = false)
    private Boolean isOnline;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Temporal(value = TemporalType.DATE)
    private Timestamp startDate;

    @Temporal(value = TemporalType.DATE)
    private Timestamp endDate;

    @Column(name = "is_continue")
    private String description;

    @Column(name = "certificate_file_path")
    private String certificateFilePath;

    @Column(name = "verification_address")
    private String verificationAddress;

}
