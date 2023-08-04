package az.rock.flyjob.model.entity.resume.main;

import az.rock.lib.domain.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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

    private String jobTitle;
}
