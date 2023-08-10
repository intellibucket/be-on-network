package az.rock.flyjob.model.entity.resume.main;

import az.rock.flyjob.model.entity.resume.ResumeEntity;
import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "informations", schema = "resume")
@Entity(name = "InformationEntity")
public class InformationEntity extends BaseEntity {

    @OneToOne
    private ResumeEntity resume;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToOne(mappedBy = "information")
    private JobTitleInformationEntity jobTitleInformation;

    @Temporal(value = TemporalType.DATE)
    private Timestamp birthDate;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "passport")
    private String passport;

    @Column(name = "marital_status")
    private String maritalStatus;

    @Column(name = "military_service")
    private String militaryService;

    @Column(name = "driving_license")
    private String drivingLicense;

    @OneToMany(mappedBy = "information")
    private List<LinkEntity> links;

    @OneToOne(mappedBy = "information")
    private AddressEntity address;
}
