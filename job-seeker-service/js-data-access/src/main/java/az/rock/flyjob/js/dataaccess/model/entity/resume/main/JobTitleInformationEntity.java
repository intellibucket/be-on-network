package az.rock.flyjob.js.dataaccess.model.entity.resume.main;

import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.AccessModifier;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "job_title_information", schema = "resume")
@Entity(name = "JobTitleInformationEntity")
public class JobTitleInformationEntity extends BaseEntity {
    @OneToOne
    private InformationEntity information;

    @Column(length = 32, columnDefinition = "varchar(32) default 'AUTHENTICATED'")
    @Enumerated(EnumType.STRING)
    private AccessModifier accessModifier;

    private String jobTitle;
}
